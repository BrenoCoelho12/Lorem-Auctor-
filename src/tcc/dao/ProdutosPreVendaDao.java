/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Produtos;
import tcc.dominio.ProdutosPreVenda;
import tcc.dominio.TipoProduto;

/**
 *
 * @author Breno-
 */
public class ProdutosPreVendaDao extends GenericDAO {
    
    public int inserirItemProduto(ProdutosPreVenda ip, int preVenda) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO produtosPreVenda (idProduto, idPreVenda, valorRevenda, quantidade) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, ip.getProduto().getIdProduto());
            pstmt.setInt(2, preVenda);
            pstmt.setBigDecimal(3, ip.getValorRevenda());
            pstmt.setInt(4, ip.getQuantidade());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     public List<ProdutosPreVenda> ItensPreVenda(int idPreVenda) throws SQLException {
        List<ProdutosPreVenda> y = new ArrayList<ProdutosPreVenda>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("select ppv.idPreVenda, ppv.quantidade, ppv.valorRevenda, p.idProduto, p.nomeProduto, p.unidade, p.precoRevenda, p.idTipoProduto from ProdutosPreVenda ppv inner join produtos p on (p.idProduto = ppv.idProduto) where ppv.idPreVenda = ?;");
            pstmt.setInt(1, idPreVenda);
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

                ProdutosPreVenda ppv = new ProdutosPreVenda();
                ppv.setProduto(p);
                ppv.setQuantidade(resultSet.getInt("quantidade"));
                ppv.setValorRevenda(resultSet.getBigDecimal("valorRevenda"));
                
                y.add(ppv);

            }
        } finally {
            finishConnection();
        }
        return y;

    }
     
     public int apagarProdutosPreVenda(int ppv) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("DELETE FROM produtosPreVenda WHERE idPreVenda = ?");
            pstmt.setInt(1, ppv);
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
 
}
