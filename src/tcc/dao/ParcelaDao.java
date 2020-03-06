/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import tcc.dominio.ClienteFisico;
import tcc.dominio.Parcelas;
import tcc.dominio.Venda;


/**
 *
 * @author Breno-
 */
public class ParcelaDao extends GenericDAO {
    
    public int adicionarParcelas(Parcelas parcela) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO parcela (quantidadeParcelas, valorDevido, descricao, dataVencimento, idCliente, idVenda, situacao, valorTotalCompra) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, parcela.getQuantidadeParcelas());
            pstmt.setBigDecimal(2, parcela.getValorDevido());
            pstmt.setString(3, parcela.getDescricao());
            pstmt.setString(4, parcela.getDataVencimento());
            pstmt.setInt(5, parcela.getCliente().getIdCliente());
            pstmt.setInt(6, parcela.getVenda().getIdVenda());
            pstmt.setString(7, parcela.getSituacaoParcela());
            pstmt.setBigDecimal(8, parcela.getValorTotalCompra());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
   
            public List<Parcelas> listarParcelas(int idVenda) throws SQLException {
        List<Parcelas> y = new ArrayList<Parcelas>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT p.idParcela, p.valorTotalCompra, p.situacao, p.idVenda, p.idCliente, p.dataVencimento, p.descricao, p.quantidadeParcelas, p.valorDevido, cf.idCliente, cf.nomeCliente, v.idVenda, v.totalCompra FROM parcela p INNER JOIN cliente_fisico cf INNER JOIN venda v ON(cf.idCliente = p.idCliente = v.idVenda) WHERE p.idVenda LIKE ? ORDER BY p.idParcela ASC");
            pstmt.setInt(1, idVenda);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {                
                    ClienteFisico cf = new ClienteFisico();
                    Venda venda = new Venda();
                    Parcelas p = new Parcelas();
                    
            cf.setIdCliente(resultSet.getInt("idCliente"));
            cf.setNome(resultSet.getString("nomeCliente"));
                
            venda.setIdVenda(resultSet.getInt("idVenda"));
            
            p.setCliente(cf);
            p.setVenda(venda);
            p.setValorTotalCompra(resultSet.getBigDecimal("valorTotalCompra"));
            p.setIdParcela(resultSet.getInt("idParcela"));
            p.setDataVencimento(resultSet.getString("dataVencimento"));
            p.setDescricao(resultSet.getString("descricao"));
            p.setQuantidadeParcelas(resultSet.getInt("quantidadeParcelas"));
            p.setValorDevido(resultSet.getBigDecimal("valorDevido"));
            p.setSituacaoParcela(resultSet.getString("situacao"));
                
            y.add(p);
                 
            }
        } finally {
            finishConnection();
        }
        return y;
    
           }   
   
}
