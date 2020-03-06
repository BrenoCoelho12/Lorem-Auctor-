/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dao.ProdutosDao;
import tcc.dominio.Produtos;
import tcc.dominio.TipoProduto;


/**
 *
 * @author Breno-
 */
public class ProdutosController {
    
    
    
        public int Cadastrarpecas(Produtos produto) throws SQLException {
        int resultado;
        ProdutosDao ProdutosbikeDAO = new ProdutosDao();
        resultado = ProdutosbikeDAO.adicionarProduto(produto);
        return resultado;
    }
      
     public int Atualizarpecas(Produtos produto) throws SQLException {
        int resultado;
        ProdutosDao ProdutosDAO = new ProdutosDao();
        resultado = ProdutosDAO.atualizarProduto(produto);
        return resultado;
    }  
     
    public int Apagarpecas(Produtos produto) throws SQLException {
        int resultado;
        ProdutosDao ProdutosDAO = new ProdutosDao();
        resultado = ProdutosDAO.apagarProduto(produto);
        return resultado;
    }
    
    public List<Produtos> listarProdutosbike() throws SQLException {
        List<Produtos> produto = new ArrayList<Produtos>();
        ProdutosDao x = new ProdutosDao();
        produto = x.listarProdutosbike();
        return produto;
    }
    
    public List<Produtos> listarProdutosmoto() throws SQLException {
        List<Produtos> produto = new ArrayList<Produtos>();
        ProdutosDao x = new ProdutosDao();
        produto = x.listarProdutosmoto();
        return produto;
    }
    
    public List<TipoProduto> listarDescricao() throws SQLException {
        List<TipoProduto> tipoproduto = new ArrayList<TipoProduto>();
        ProdutosDao x = new ProdutosDao();
        tipoproduto = x.listarDescricao();
        return tipoproduto;
    }
    
    public List<Produtos> BuscarProdutosMoto() throws SQLException {
        List<Produtos> produto = new ArrayList<Produtos>();
        ProdutosDao x = new ProdutosDao();
        produto = x.PesquisarProdutosMoto(null);
        return produto;
    }
    
    public List<Produtos> BuscarProdutosBike() throws SQLException {
        List<Produtos> produto = new ArrayList<Produtos>();
        ProdutosDao x = new ProdutosDao();
        produto = x.PesquisarProdutosBike(null);
        return produto;
    }
}
