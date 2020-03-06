/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dao.DetalhamentoContaDao;
import tcc.dao.ItemProdutoDao;
import tcc.dao.ParcelaDao;
import tcc.dao.VendaDao;
import tcc.dominio.DetalhamentoConta;
import tcc.dominio.ItemProduto;
import tcc.dominio.Parcelas;
import tcc.dominio.Venda;

/**
 *
 * @author Breno-
 */
public class VendaController {
    
     public int cadastrarVenda(Venda venda) throws SQLException {
        int idVendaGerado, resultado = 0;
        
        VendaDao vendaDAO = new VendaDao();
        ItemProdutoDao itemProdutoDao = new ItemProdutoDao();
        DetalhamentoContaDao detalhamentoDAO = new DetalhamentoContaDao();
        ParcelaDao parcelasDAO = new ParcelaDao();
        
        idVendaGerado = vendaDAO.CadastrarVenda(venda);
        
        for (ItemProduto ip : venda.getItensProduto()) {
            itemProdutoDao.inserirItemProduto(ip, idVendaGerado);
         }
         for (DetalhamentoConta dc : venda.getDetalhamentoConta()) {
            detalhamentoDAO.detalharConta(dc, idVendaGerado);
         }
         
        return resultado;
    }
     
        public List<Venda> listarVendas() throws SQLException {
        List<Venda> produto = new ArrayList<Venda>();
        VendaDao x = new VendaDao();
        produto = x.listarVendas();
        return produto;
    }
     
        public List<Venda> buscarVendas() throws SQLException {
        List<Venda> produto = new ArrayList<Venda>();
        VendaDao x = new VendaDao();
        produto = x.buscarVendas(null);
        return produto;
    }

        public int apgarVenda(Venda venda) throws SQLException {
        int resultado;
        VendaDao VendaDAO = new VendaDao();
        resultado = VendaDAO.apagarVenda(venda);
        return resultado;
    }

         
}
