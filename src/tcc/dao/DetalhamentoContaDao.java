/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.ClienteFisico;
import tcc.dominio.DetalhamentoConta;
import tcc.dominio.Venda;


/**
 *
 * @author Breno-
 */
public class DetalhamentoContaDao extends GenericDAO {
    
        public int detalharConta(DetalhamentoConta detalhamento, int idVenda) throws SQLException {
        getConnection();
        int resultado = 0;
        try {
            getConnection();
                pstmt = connection.prepareStatement("INSERT INTO detalhamentoConta (cliente, dataInformada, observacao, valor, idVenda, situacao, formaPagamento, datasVencimento, valorPago, saldoDevedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, detalhamento.getCliente().getIdCliente());
            pstmt.setString(2, detalhamento.getData());
            pstmt.setString(3, detalhamento.getObservação());
            pstmt.setBigDecimal(4, detalhamento.getValor());
            pstmt.setInt(5, idVenda);
            pstmt.setString(6, detalhamento.getSituacao());
            pstmt.setString(7, detalhamento.getFormaPagamento());
            pstmt.setString(8, detalhamento.getDatasVencimento());
            pstmt.setBigDecimal(9, detalhamento.getValorPago());
            pstmt.setBigDecimal(10, detalhamento.getSaldoDevedor());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
        public int CDetalhamento(DetalhamentoConta detalhamento) throws SQLException {
        getConnection();
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO detalhamentoConta (cliente, dataInformada, observacao, valor, idVenda, datasVencimento, situacao, formaPagamento, valorPago, saldoDevedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, detalhamento.getCliente().getIdCliente());
            pstmt.setString(2, detalhamento.getData());
            pstmt.setString(3, detalhamento.getObservação());
            pstmt.setBigDecimal(4, detalhamento.getValor());
            pstmt.setInt(5, detalhamento.getVenda().getIdVenda());
            pstmt.setString(6, detalhamento.getDatasVencimento());
            pstmt.setString(7, detalhamento.getSituacao());
            pstmt.setString(8, detalhamento.getFormaPagamento());
            pstmt.setBigDecimal(9, detalhamento.getValorPago());
            pstmt.setBigDecimal(10, detalhamento.getSaldoDevedor());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
     
        public int atualizarDetalhamentoNaLista(DetalhamentoConta detalhamento) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("UPDATE detalhamentoConta SET dataInformada =?, valor =?, cliente =?, observacao = ?, valorPago =?, valorCompras =?, saldoDevedor=?, idVenda =?, formaPagamento = ?, datasVencimento = ?, situacao =? WHERE idDetalhamento =?");
            pstmt.setString(1,     detalhamento.getData());
            pstmt.setBigDecimal(2,  detalhamento.getValor());
            pstmt.setInt(3,    detalhamento.getCliente().getIdCliente());
            pstmt.setString(4,  detalhamento.getObservação());
            pstmt.setBigDecimal(5,  detalhamento.getValorPago());
            pstmt.setBigDecimal(6,  detalhamento.getValorCompras());
            pstmt.setBigDecimal(7,  detalhamento.getSaldoDevedor());
            pstmt.setInt(8, detalhamento.getVenda().getIdVenda());
            pstmt.setString(9,  detalhamento.getFormaPagamento());
            pstmt.setString(10,  detalhamento.getDatasVencimento());
            pstmt.setString(11,  detalhamento.getSituacao());
             pstmt.setInt(12, detalhamento.getIdDetalhamento());
            pstmt.executeUpdate();
            
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
   
          public int apagarDetalhamento(DetalhamentoConta detalhamento) throws SQLException {
         getConnection();
         int resultado = 0;
        try {
            pstmt = connection.prepareStatement("DELETE FROM detalhamentoConta WHERE idVenda = ?");
            pstmt.setInt(1, detalhamento.getVenda().getIdVenda());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     public List<DetalhamentoConta> buscarDetalhamentoDasContas(int pesquisar) throws SQLException {
        List<DetalhamentoConta> y = new ArrayList<DetalhamentoConta>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT c.idCliente, c.nomeCliente, d.idDetalhamento, d.saldoDevedor, d.valorPago, d.formaPagamento, d.cliente as idCliente, d.valor, d.dataInformada, d.observacao, d.idVenda, d.datasVencimento, d.situacao FROM detalhamentoConta d INNER JOIN cliente_fisico c INNER JOIN venda v ON(c.idCliente = d.cliente = v.idVenda) WHERE c.idCliente LIKE ? ORDER BY d.idDetalhamento ASC, v.idVenda ASC");
            pstmt.setInt(1, pesquisar);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
               DetalhamentoConta dc = new DetalhamentoConta();
               ClienteFisico cliente = new ClienteFisico();
               Venda venda = new Venda();
               
                venda.setIdVenda(resultSet.getInt("idVenda"));
                
                dc.setIdDetalhamento(resultSet.getInt("idDetalhamento"));
                dc.setCliente(cliente);
                dc.setData(resultSet.getString("dataInformada"));
                dc.setValor(resultSet.getBigDecimal("valor"));
                dc.setObservação(resultSet.getString("observacao"));
                dc.setDatasVencimento(resultSet.getString("datasVencimento"));
                dc.setSituacao(resultSet.getString("situacao"));
                dc.setFormaPagamento(resultSet.getString("formaPagamento"));
                dc.setValorPago(resultSet.getBigDecimal("valorPago"));
                dc.setSaldoDevedor(resultSet.getBigDecimal("saldoDevedor"));
                dc.setVenda(venda);
                venda.getDetalhamentoConta().add(dc);
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nomeCliente"));
                y.add(dc);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
     
     public List<DetalhamentoConta> buscarDetalhamentoDasContasPorData(String pesquisa) throws SQLException {
        List<DetalhamentoConta> y = new ArrayList<DetalhamentoConta>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT c.idCliente, c.nomeCliente, d.valorPago, d.saldoDevedor, d.idDetalhamento, d.formaPagamento, d.situacao, d.cliente as idCliente, d.valor, d.dataInformada, d.observacao, d.idVenda, d.datasVencimento FROM detalhamentoConta d INNER JOIN cliente_fisico c INNER JOIN venda v ON(c.idCliente = d.cliente = v.idVenda) WHERE d.dataInformada LIKE ? ORDER BY d.idDetalhamento ASC, v.idVenda ASC");
            pstmt.setString(1, "%"+pesquisa+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
               DetalhamentoConta dc = new DetalhamentoConta();
               ClienteFisico cliente = new ClienteFisico();
               Venda venda = new Venda();
               
                venda.setIdVenda(resultSet.getInt("idVenda"));
                
                dc.setIdDetalhamento(resultSet.getInt("idDetalhamento"));
                dc.setCliente(cliente);
                dc.setData(resultSet.getString("dataInformada"));
                dc.setValor(resultSet.getBigDecimal("valor"));
                dc.setObservação(resultSet.getString("observacao"));
                dc.setDatasVencimento(resultSet.getString("datasVencimento"));
                dc.setSituacao(resultSet.getString("situacao"));
                dc.setFormaPagamento(resultSet.getString("formaPagamento"));
                dc.setValorPago(resultSet.getBigDecimal("valorPago"));
                dc.setSaldoDevedor(resultSet.getBigDecimal("saldoDevedor"));
                dc.setVenda(venda);
                venda.getDetalhamentoConta().add(dc);
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nomeCliente"));
                y.add(dc);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
     
      public List<DetalhamentoConta> buscarDetalhamentoDasContasPeloCodVenda(String pesquisa) throws SQLException {
        List<DetalhamentoConta> y = new ArrayList<DetalhamentoConta>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT c.idCliente, c.nomeCliente, d.valorPago, d.saldoDevedor, d.idDetalhamento, d.formaPagamento, d.situacao, d.cliente as idCliente, d.valor, d.dataInformada, d.observacao, d.idVenda, d.datasVencimento FROM detalhamentoConta d INNER JOIN cliente_fisico c INNER JOIN venda v ON(c.idCliente = d.cliente = v.idVenda) WHERE d.idVenda LIKE ? ORDER BY d.idDetalhamento ASC, v.idVenda ASC");
            pstmt.setString(1, "%"+pesquisa+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
               DetalhamentoConta dc = new DetalhamentoConta();
               ClienteFisico cliente = new ClienteFisico();
               Venda venda = new Venda();
               
                venda.setIdVenda(resultSet.getInt("idVenda"));
                
                dc.setIdDetalhamento(resultSet.getInt("idDetalhamento"));
                dc.setCliente(cliente);
                dc.setData(resultSet.getString("dataInformada"));
                dc.setValor(resultSet.getBigDecimal("valor"));
                dc.setObservação(resultSet.getString("observacao"));
                dc.setDatasVencimento(resultSet.getString("datasVencimento"));
                dc.setSituacao(resultSet.getString("situacao"));
                dc.setFormaPagamento(resultSet.getString("formaPagamento"));
                dc.setValorPago(resultSet.getBigDecimal("valorPago"));
                dc.setSaldoDevedor(resultSet.getBigDecimal("saldoDevedor"));
                dc.setVenda(venda);
                venda.getDetalhamentoConta().add(dc);
                
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nomeCliente"));
                y.add(dc);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
     
     
    /* public List<DetalhamentoConta> listarDetalhamentoDasContas() throws SQLException {
        List<DetalhamentoConta> y = new ArrayList<DetalhamentoConta>();
        try {
            getConnection();
          pstmt = connection.prepareStatement("SELECT v.idVenda, v.dataVenda, v.dataVencimento, v.observacoes,v.acrescimos ,v.desconto, v.totalCompra ,v.qtdVolumes, v.total, v.idVendedor, v.totalConta, v.situacao, v.totalRestante, v.totalPago, c.idCliente, c.nomeCliente, c.cpf, c.cidade, c.email, c.rgInscricao, c.estado, c.endereco, c.tCelular, c.tResidencial, d.idDetalhamento, d.cliente, d.valor, d.dataInformada, d.observacao, d.idVenda FROM detalhamentoConta d INNER JOIN cliente_fisico c INNER JOIN venda v ON(c.idCliente = d.cliente = v.idCliente) ORDER BY c.nome ASC ");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                    DetalhamentoConta dc = new DetalhamentoConta();
                Venda venda = new Venda();
                ClienteFisico cliente = new ClienteFisico();
                              
                venda.setId_venda(resultSet.getInt("idVenda"));
                venda.setData_venda(resultSet.getString("dataVenda"));
                venda.setTotal(resultSet.getBigDecimal("total"));
                venda.setObservacoes(resultSet.getString("observacoes"));
                venda.setAcrescimos(resultSet.getBigDecimal("acrescimos"));
                venda.setDesconto(resultSet.getBigDecimal("desconto"));
                venda.setQtd_volume(resultSet.getInt("qtdVolumes"));
                venda.setTotal_conta(resultSet.getBigDecimal("totalConta"));
                venda.setSituacao(resultSet.getString("situacao"));
                venda.setTotalCompra(resultSet.getBigDecimal("totalCompra"));
                venda.setTotalRestante(resultSet.getBigDecimal("totalRestante"));
                venda.setTotalPago(resultSet.getBigDecimal("totalPago"));
                venda.setDataVencimento(resultSet.getString("dataVencimento"));
               
                dc.setIdDetalhamento(resultSet.getInt("idDetalhamento"));
                dc.setCliente(cliente);
                dc.setData(resultSet.getString("dataInformada"));
                dc.setValor(resultSet.getBigDecimal("valor"));
                dc.setObservação(resultSet.getString("observacao"));
                dc.setVenda(venda);
                
                cliente.setId(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nomeCliente"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setRginscricao(resultSet.getString("rgInscricao"));
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setT_celular(resultSet.getString("tCelular"));
                cliente.setT_residencial(resultSet.getString("tResidencial"));
                y.add(dc);
                
            }
        } finally {
            finishConnection();
        }
        return y;
    }*/
}
