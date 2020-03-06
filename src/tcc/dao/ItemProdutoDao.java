/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import tcc.dominio.ItemProduto;

/**
 *
 * @author Breno-
 */
public class ItemProdutoDao extends GenericDAO {
    
    public int inserirItemProduto(ItemProduto ip, int idVenda) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO itemProduto (idProduto, idVenda, valorrevenda, quantidade) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, ip.getProduto().getIdProduto());
            pstmt.setInt(2, idVenda);
            pstmt.setBigDecimal(3, ip.getValorRevenda());
            pstmt.setInt(4, ip.getQuantidade());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
}