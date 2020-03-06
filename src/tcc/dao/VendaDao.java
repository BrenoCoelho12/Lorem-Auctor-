/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.ClienteFisico;
import tcc.dominio.ItemProduto;
import tcc.dominio.Produtos;
import tcc.dominio.TipoProduto;
import tcc.dominio.Venda;
import tcc.dominio.Vendedor;

/**
 *
 * @author Breno-
 */
public class VendaDao extends GenericDAO {

    public int CadastrarVenda(Venda venda) throws SQLException {
        int idVendaGerado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO venda (idCliente, idVendedor, dataVenda, observacoes, acrescimos, total, qtdVolumes, situacao, totalCompra, totalRestante, totalPago, formaPagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, venda.getClienteFisico().getIdCliente());
            pstmt.setInt(2, venda.getVendedor().getIdVendedor());
            pstmt.setString(3, venda.getDataVenda());
            pstmt.setString(4, venda.getObservacoes());
            pstmt.setBigDecimal(5, venda.getAcrescimos());
            pstmt.setBigDecimal(6, venda.getTotal());
            pstmt.setInt(7, venda.getQtdVolume());
            pstmt.setString(8, venda.getSituacao());
            pstmt.setBigDecimal(9, venda.getTotalCompra());
            pstmt.setBigDecimal(10, venda.getTotalRestante());
            pstmt.setBigDecimal(11, venda.getTotalPago());
            pstmt.setString(12, venda.getFormaPagamento());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()) {
                idVendaGerado = rs.getInt(1);
            }
        } finally {
            finishConnection();
        }
        return idVendaGerado;
    }

    public int apagarVenda(Venda venda) throws SQLException {
        getConnection();
        int resultado = 0;
        try {
            pstmt = connection.prepareStatement("DELETE FROM venda WHERE idVenda = ?");
            pstmt.setInt(1, venda.getIdVenda());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }

    public List<Venda> listarVendas() throws SQLException {
        List<Venda> y = new ArrayList<Venda>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT v.idVenda, v.dataVenda, v.formaPagamento, v.observacoes,v.acrescimos , v.totalCompra ,v.qtdVolumes, v.total, v.idVendedor, v.situacao, v.totalRestante, v.totalPago, cf.idCliente, cf.nomeCliente ,cf.cpf ,cf.rgInscricao, cf.email ,cf.cidade ,cf.estado ,cf.endereco ,cf.tCelular ,cf.tResidencial, vd.idVendedor, vd.nomeVendedor, vd.salario FROM venda v INNER JOIN cliente_fisico cf INNER JOIN vendedor vd ON (v.idCliente = cf.idCliente = vd.idVendedor) ORDER BY nomeCliente ASC");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setIdCliente(resultSet.getInt("idCliente"));
                cf.setNome(resultSet.getString("nomeCliente"));
                cf.setCpf(resultSet.getString("cpf"));
                cf.setCidade(resultSet.getString("cidade"));
                cf.setEmail(resultSet.getString("email"));
                cf.setEndereco(resultSet.getString("endereco"));
                cf.setEstado(resultSet.getString("estado"));
                cf.setRginscricao(resultSet.getString("rgInscricao"));
                cf.setT_celular(resultSet.getString("tCelular"));
                cf.setT_residencial(resultSet.getString("tResidencial"));

                Vendedor v = new Vendedor();
                v.setIdVendedor(resultSet.getInt("idVendedor"));
                v.setNomeVendedor(resultSet.getString("nomeVendedor"));

                Venda venda = new Venda();
                venda.setClienteFisico(cf);
                venda.setVendedor(v);
                venda.setIdVenda(resultSet.getInt("idVenda"));
                venda.setDataVenda(resultSet.getString("dataVenda"));
                venda.setTotal(resultSet.getBigDecimal("total"));
                venda.setObservacoes(resultSet.getString("observacoes"));
                venda.setAcrescimos(resultSet.getBigDecimal("acrescimos"));
                venda.setQtdVolume(resultSet.getInt("qtdVolumes"));
                venda.setSituacao(resultSet.getString("situacao"));
                venda.setTotalCompra(resultSet.getBigDecimal("totalCompra"));
                venda.setTotalRestante(resultSet.getBigDecimal("totalRestante"));
                venda.setTotalPago(resultSet.getBigDecimal("totalPago"));
                venda.setFormaPagamento(resultSet.getString("formaPagamento"));
                y.add(venda);

            }
        } finally {
            finishConnection();
        }
        return y;

    }

    public List<Venda> listarVendasPorData(String dataInicio, String dataFim) throws SQLException {
        List<Venda> y = new ArrayList<Venda>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT v.idVenda, v.dataVenda, v.formaPagamento, v.observacoes,v.acrescimos , v.totalCompra ,v.qtdVolumes, v.total, v.idVendedor, v.situacao, v.totalRestante, v.totalPago, cf.idCliente, cf.nomeCliente ,cf.cpf ,cf.rgInscricao, cf.email ,cf.cidade ,cf.estado ,cf.endereco ,cf.tCelular ,cf.tResidencial, vd.idVendedor, vd.nomeVendedor, vd.salario FROM venda v INNER JOIN cliente_fisico cf INNER JOIN vendedor vd ON (v.idCliente = cf.idCliente = vd.idVendedor)  WHERE dataVenda between ? and ? order by nomeCliente asc;");
            pstmt.setString(1, dataInicio);
            pstmt.setString(2, dataFim);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setIdCliente(resultSet.getInt("idCliente"));
                cf.setNome(resultSet.getString("nomeCliente"));
                cf.setCpf(resultSet.getString("cpf"));
                cf.setCidade(resultSet.getString("cidade"));
                cf.setEmail(resultSet.getString("email"));
                cf.setEndereco(resultSet.getString("endereco"));
                cf.setEstado(resultSet.getString("estado"));
                cf.setRginscricao(resultSet.getString("rgInscricao"));
                cf.setT_celular(resultSet.getString("tCelular"));
                cf.setT_residencial(resultSet.getString("tResidencial"));

                Vendedor v = new Vendedor();
                v.setIdVendedor(resultSet.getInt("idVendedor"));
                v.setNomeVendedor(resultSet.getString("nomeVendedor"));

                Venda venda = new Venda();
                venda.setClienteFisico(cf);
                venda.setVendedor(v);
                venda.setIdVenda(resultSet.getInt("idVenda"));
                venda.setDataVenda(resultSet.getString("dataVenda"));
                venda.setTotal(resultSet.getBigDecimal("total"));
                venda.setObservacoes(resultSet.getString("observacoes"));
                venda.setAcrescimos(resultSet.getBigDecimal("acrescimos"));
                venda.setQtdVolume(resultSet.getInt("qtdVolumes"));
                venda.setSituacao(resultSet.getString("situacao"));
                venda.setTotalCompra(resultSet.getBigDecimal("totalCompra"));
                venda.setTotalRestante(resultSet.getBigDecimal("totalRestante"));
                venda.setTotalPago(resultSet.getBigDecimal("totalPago"));
                venda.setFormaPagamento(resultSet.getString("formaPagamento"));
                y.add(venda);

            }
        } finally {
            finishConnection();
        }
        return y;

    }

    public List<Venda> buscarVendas(String pesquisa) throws SQLException {
        List<Venda> y = new ArrayList<Venda>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT v.idVenda, v.dataVenda, v.formaPagamento, v.observacoes, v.acrescimos, v.totalCompra ,v.qtdVolumes, v.total, v.idVendedor, v.situacao, v.totalRestante, v.totalPago, cf.idCliente, cf.nomeCliente ,cf.cpf ,cf.rgInscricao, cf.email ,cf.cidade ,cf.estado ,cf.endereco ,cf.tCelular ,cf.tResidencial, vd.idVendedor, vd.nomeVendedor, vd.salario FROM venda v INNER JOIN cliente_fisico cf INNER JOIN vendedor vd ON (v.idCliente = cf.idCliente = vd.idVendedor) WHERE nomeCliente LIKE ? ORDER BY idVenda ASC;");
            pstmt.setString(1, pesquisa);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setIdCliente(resultSet.getInt("idCliente"));
                cf.setNome(resultSet.getString("nomeCliente"));
                cf.setCpf(resultSet.getString("cpf"));
                cf.setCidade(resultSet.getString("cidade"));
                cf.setEmail(resultSet.getString("email"));
                cf.setEndereco(resultSet.getString("endereco"));
                cf.setEstado(resultSet.getString("estado"));
                cf.setRginscricao(resultSet.getString("rgInscricao"));
                cf.setT_celular(resultSet.getString("tCelular"));
                cf.setT_residencial(resultSet.getString("tResidencial"));

                Vendedor v = new Vendedor();
                v.setIdVendedor(resultSet.getInt("idVendedor"));
                v.setNomeVendedor(resultSet.getString("nomeVendedor"));

                Venda venda = new Venda();
                venda.setClienteFisico(cf);
                venda.setVendedor(v);
                venda.setIdVenda(resultSet.getInt("idVenda"));
                venda.setDataVenda(resultSet.getString("dataVenda"));
                venda.setTotal(resultSet.getBigDecimal("total"));
                venda.setObservacoes(resultSet.getString("observacoes"));
                venda.setAcrescimos(resultSet.getBigDecimal("acrescimos"));
                venda.setQtdVolume(resultSet.getInt("qtdVolumes"));
                venda.setSituacao(resultSet.getString("situacao"));
                venda.setTotalCompra(resultSet.getBigDecimal("totalCompra"));
                venda.setTotalRestante(resultSet.getBigDecimal("totalRestante"));
                venda.setTotalPago(resultSet.getBigDecimal("totalPago"));
                venda.setFormaPagamento(resultSet.getString("formaPagamento"));
                y.add(venda);

            }
        } finally {
            finishConnection();
        }
        return y;

    }

    public List<Venda> buscarVendasx(int pesquisa) throws SQLException {
        List<Venda> y = new ArrayList<Venda>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT v.idVenda, v.dataVenda, v.formaPagamento, v.observacoes,v.acrescimos, v.totalCompra ,v.qtdVolumes, v.total, v.idVendedor, v.situacao, v.totalRestante, v.totalPago, cf.idCliente, cf.nomeCliente ,cf.cpf ,cf.rgInscricao, cf.email ,cf.cidade ,cf.estado ,cf.endereco ,cf.tCelular ,cf.tResidencial, vd.idVendedor, vd.nomeVendedor, vd.salario FROM venda v INNER JOIN cliente_fisico cf INNER JOIN vendedor vd ON (v.idCliente = cf.idCliente = vd.idVendedor) WHERE cf.idCliente LIKE ? ORDER BY idVenda ASC;");
            pstmt.setInt(1, pesquisa);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setIdCliente(resultSet.getInt("idCliente"));
                cf.setNome(resultSet.getString("nomeCliente"));
                cf.setCpf(resultSet.getString("cpf"));
                cf.setCidade(resultSet.getString("cidade"));
                cf.setEmail(resultSet.getString("email"));
                cf.setEndereco(resultSet.getString("endereco"));
                cf.setEstado(resultSet.getString("estado"));
                cf.setRginscricao(resultSet.getString("rgInscricao"));
                cf.setT_celular(resultSet.getString("tCelular"));
                cf.setT_residencial(resultSet.getString("tResidencial"));

                Vendedor v = new Vendedor();
                v.setIdVendedor(resultSet.getInt("idVendedor"));
                v.setNomeVendedor(resultSet.getString("nomeVendedor"));

                Venda venda = new Venda();
                venda.setClienteFisico(cf);
                venda.setVendedor(v);
                venda.setIdVenda(resultSet.getInt("idVenda"));
                venda.setDataVenda(resultSet.getString("dataVenda"));
                venda.setTotal(resultSet.getBigDecimal("total"));
                venda.setObservacoes(resultSet.getString("observacoes"));
                venda.setAcrescimos(resultSet.getBigDecimal("acrescimos"));
                venda.setQtdVolume(resultSet.getInt("qtdVolumes"));
                venda.setSituacao(resultSet.getString("situacao"));
                venda.setTotalCompra(resultSet.getBigDecimal("totalCompra"));
                venda.setTotalRestante(resultSet.getBigDecimal("totalRestante"));
                venda.setTotalPago(resultSet.getBigDecimal("totalPago"));
                venda.setFormaPagamento(resultSet.getString("formaPagamento"));
                y.add(venda);

            }
        } finally {
            finishConnection();
        }
        return y;

    }

    public Venda buscarItensProdutosPorVenda(Venda venda) throws SQLException {
        try {
            getConnection();
            pstmt = connection.prepareStatement("select "
                    + "ip.idVenda as idVenda,"
                    + "ip.quantidade as quantidade,"
                    + "ip.valorRevenda as valorRevenda,"
                    + "p.idProduto as idProduto,"
                    + "p.nomeProduto as nomeProduto,"
                    + "p.unidade as Unidade,"
                    + "p.precoRevenda as precoRevenda,"
                    + "p.idTipoProduto as idTipoProduto"
                    + " from itemProduto ip"
                    + " inner join produtos p on (p.idProduto = ip.idProduto)"
                    + " where ip.idVenda = ?");
            pstmt.setInt(1, venda.getIdVenda());
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                TipoProduto tp = new TipoProduto();
                tp.setId(resultSet.getInt("idTipoProduto"));

                Produtos p = new Produtos();
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setNomeProduto(resultSet.getString("nomeProduto"));
                p.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                p.setUnidade(resultSet.getString("unidade"));
                p.setDescricao(tp);

                ItemProduto ip = new ItemProduto();
                ip.setProduto(p);
                ip.setVenda(venda);
                ip.setQuantidade(resultSet.getInt("quantidade"));
                ip.setValorRevenda(resultSet.getBigDecimal("valorRevenda"));
                venda.getItensProduto().add(ip);
            }
        } finally {
            finishConnection();
        }
        return venda;

    }

    public Venda pdfVenda(Integer idVenda) throws SQLException {
        Venda venda = new Venda();
        try {
            getConnection();
            pstmt = connection.prepareStatement(("SELECT v.idVenda, v.dataVenda, v.formaPagamento, v.totalCompra, v.observacoes, v.acrescimos, v.qtdVolumes, v.total, v.idVendedor, v.situacao, v.totalRestante, v.totalPago, cf.idCliente, cf.nomeCliente ,cf.cpf ,cf.rgInscricao, cf.email ,cf.cidade ,cf.estado ,cf.endereco ,cf.tCelular ,cf.tResidencial, vd.idVendedor, vd.nomeVendedor, vd.salario FROM venda v INNER JOIN cliente_fisico cf INNER JOIN vendedor vd ON (v.idCliente = cf.idCliente = vd.idVendedor) where idVenda = ?"));
            pstmt.setInt(1, idVenda);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Vendedor v = new Vendedor();
                v.setIdVendedor(resultSet.getInt("idVendedor"));
                v.setNomeVendedor(resultSet.getString("nomeVendedor"));
                v.setSalario(resultSet.getBigDecimal("salario"));

                ClienteFisico cf = new ClienteFisico();
                cf.setIdCliente(resultSet.getInt("idCliente"));
                cf.setNome(resultSet.getString("nomeCliente"));
                cf.setCpf(resultSet.getString("cpf"));
                cf.setCidade(resultSet.getString("cidade"));
                cf.setEmail(resultSet.getString("email"));
                cf.setEndereco(resultSet.getString("endereco"));
                cf.setEstado(resultSet.getString("estado"));
                cf.setRginscricao(resultSet.getString("rgInscricao"));
                cf.setT_celular(resultSet.getString("tCelular"));
                cf.setT_residencial(resultSet.getString("tResidencial"));

                venda.setClienteFisico(cf);
                venda.setVendedor(v);
                venda.setIdVenda(resultSet.getInt("idVenda"));
                venda.setDataVenda(resultSet.getString("dataVenda"));
                venda.setTotal(resultSet.getBigDecimal("total"));
                venda.setObservacoes(resultSet.getString("observacoes"));
                venda.setAcrescimos(resultSet.getBigDecimal("acrescimos"));
                venda.setSituacao(resultSet.getString("situacao"));
                venda.setQtdVolume(resultSet.getInt("qtdVolumes"));
                venda.setTotalCompra(resultSet.getBigDecimal("totalCompra"));
                venda.setTotalRestante(resultSet.getBigDecimal("totalRestante"));
                venda.setTotalPago(resultSet.getBigDecimal("totalPago"));
                venda.setFormaPagamento(resultSet.getString("formaPagamento"));
            }
        } finally {
            finishConnection();
        }
        return venda;

    }
}
