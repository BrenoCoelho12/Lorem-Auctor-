/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tcc.dominio.Produtos;
import tcc.dominio.TipoProduto;

/**
 *
 * @author Breno-
 */
public class ProdutosDao extends GenericDAO {
    public int adicionarProduto(Produtos produto) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO produtos (nomeProduto, precoVarejo, precoRevenda, precoDeCompra, localizacao, idTipoProduto, marca, unidade, estoque) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, produto.getNomeProduto());
            pstmt.setBigDecimal(2, produto.getPrecoVarejo());
            pstmt.setBigDecimal(3, produto.getPrecoRevenda());
            pstmt.setBigDecimal(4, produto.getPrecoDeCompra());
            pstmt.setString(5, produto.getLocalizador());
            pstmt.setInt(6, produto.getDescricao().getId());
            pstmt.setString(7, produto.getMarca());
            pstmt.setString(8, produto.getUnidade());
            pstmt.setInt(9, produto.getQuantidadeEstoque());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     
      public int atualizarProduto(Produtos produto) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("UPDATE produtos SET nomeProduto = ?, precoVarejo = ?, precoRevenda = ?, localizacao = ?, precoDeCompra = ?, marca = ?, unidade = ?, estoque =? WHERE idProduto = ?");
            pstmt.setString(1, produto.getNomeProduto());
            pstmt.setBigDecimal(2, produto.getPrecoVarejo());
            pstmt.setBigDecimal(3, produto.getPrecoRevenda());
            pstmt.setString(4, produto.getLocalizador());
            pstmt.setBigDecimal(5, produto.getPrecoDeCompra());
            pstmt.setString(6, produto.getMarca());
            pstmt.setString(7, produto.getUnidade());
            pstmt.setInt(8, produto.getQuantidadeEstoque());
            pstmt.setInt(9, produto.getIdProduto());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
      public int atualizarEstoque(Produtos produto) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("UPDATE produtos SET estoque =? WHERE idProduto = ?");
            pstmt.setInt(1, produto.getQuantidadeEstoque());
            pstmt.setInt(2, produto.getIdProduto());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
      
     public int apagarProduto(Produtos produto) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
                      pstmt = connection.prepareStatement("DELETE FROM produtos WHERE idProduto = ?");
            pstmt.setInt(1, produto.getIdProduto());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     
     public List<Produtos> listarProdutosbike() throws SQLException {
        List<Produtos> y = new ArrayList<Produtos>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM produtos WHERE idTipoProduto = 3 ORDER BY nomeProduto ASC");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Produtos produto = new Produtos();
                
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setPrecoDeCompra(resultSet.getBigDecimal("precoDeCompra"));
                produto.setPrecoVarejo(resultSet.getBigDecimal("precoVarejo"));
                produto.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setLocalizador(resultSet.getString("localizacao"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setQuantidadeEstoque(resultSet.getInt("estoque"));
                y.add(produto);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
     
     public List<Produtos> PesquisarProdutosMoto(String pesquisa) throws SQLException {
        List<Produtos> y = new ArrayList<Produtos>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM produtos WHERE idTipoProduto = 2 and nomeProduto LIKE ? ORDER BY nomeProduto ASC");
            pstmt.setString(1, "%"+pesquisa+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Produtos produto = new Produtos();
                
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setPrecoDeCompra(resultSet.getBigDecimal("precoDeCompra"));
                produto.setPrecoVarejo(resultSet.getBigDecimal("precoVarejo"));
                produto.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setLocalizador(resultSet.getString("localizacao"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setQuantidadeEstoque(resultSet.getInt("estoque"));
                y.add(produto);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
     
   public List<Produtos> PesquisarProdutosBike(String pesquisa) throws SQLException {
        List<Produtos> y = new ArrayList<Produtos>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM produtos WHERE idTipoProduto = 3 and nomeProduto LIKE ? ORDER BY nomeProduto ASC");
            pstmt.setString(1, "%"+pesquisa+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Produtos produto = new Produtos();
                
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setPrecoDeCompra(resultSet.getBigDecimal("precoDeCompra"));
                produto.setPrecoVarejo(resultSet.getBigDecimal("precoVarejo"));
                produto.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setLocalizador(resultSet.getString("localizacao"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setQuantidadeEstoque(resultSet.getInt("estoque"));
                y.add(produto);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
     
     public Produtos InformacoesProduto(int idProduto) throws SQLException {
        Produtos y = new Produtos();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM produtos WHERE idProduto = ?");
            pstmt.setInt(1, idProduto);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                
                y.setIdProduto(resultSet.getInt("idProduto"));
                y.setNomeProduto(resultSet.getString("nomeProduto"));
                y.setPrecoDeCompra(resultSet.getBigDecimal("precoDeCompra"));
                y.setPrecoVarejo(resultSet.getBigDecimal("precoVarejo"));
                y.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                y.setUnidade(resultSet.getString("unidade"));
                y.setLocalizador(resultSet.getString("localizacao"));
                y.setMarca(resultSet.getString("marca"));
                y.setQuantidadeEstoque(resultSet.getInt("estoque"));
            }
        } finally {
            finishConnection();
        }
        return y;
    }
  
     
       public List<Produtos> listarProdutosmoto() throws SQLException {
        List<Produtos> y = new ArrayList<Produtos>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM produtos  WHERE idTipoProduto = 2 ORDER BY nomeProduto ASC");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Produtos produto = new Produtos();
                
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setPrecoDeCompra(resultSet.getBigDecimal("precoDeCompra"));
                produto.setPrecoVarejo(resultSet.getBigDecimal("precoVarejo"));
                produto.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                produto.setLocalizador(resultSet.getString("localizacao"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setQuantidadeEstoque(resultSet.getInt("estoque"));
                y.add(produto);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
       
           public List<TipoProduto> listarDescricao() throws SQLException {
        List<TipoProduto> y = new ArrayList<TipoProduto>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM tipoProduto");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                TipoProduto tipoproduto = new TipoProduto();
                
                tipoproduto.setId(resultSet.getInt("id"));
                tipoproduto.setDescricao(resultSet.getString("descricao"));
               
                
                y.add(tipoproduto);
            }
        } finally {
            finishConnection();
        }
        return y;
    
           }
           
       public Produtos receberQuantidadeEstoqueProduto(int idProduto) throws SQLException{
       
        Produtos p = new Produtos();
        try{
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM produtos WHERE idProduto = ?");
            pstmt.setInt(1, idProduto);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                p.setIdProduto(resultSet.getInt("idProduto"));
                p.setNomeProduto(resultSet.getString("nomeProduto"));
                p.setPrecoDeCompra(resultSet.getBigDecimal("precoDeCompra"));
                p.setPrecoVarejo(resultSet.getBigDecimal("precoVarejo"));
                p.setPrecoRevenda(resultSet.getBigDecimal("precoRevenda"));
                p.setLocalizador(resultSet.getString("localizacao"));
                p.setUnidade(resultSet.getString("unidade"));
                p.setMarca(resultSet.getString("marca"));
                p.setQuantidadeEstoque(resultSet.getInt("estoque"));
                
            }
        } finally{
            finishConnection();
        }
        return p;
       }
       
}
