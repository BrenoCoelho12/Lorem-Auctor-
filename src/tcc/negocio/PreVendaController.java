/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import tcc.dao.PreVendaDao;
import tcc.dao.ProdutosPreVendaDao;
import tcc.dominio.PreVenda;
import tcc.dominio.ProdutosPreVenda;

/**
 *
 * @author Breno-
 */
public class PreVendaController {
    
    public int salvarPreVenda(PreVenda preVenda) throws SQLException {
        int idVendaGerado, resultado = 0;
        
        PreVendaDao preVendaDAO = new PreVendaDao();
        ProdutosPreVendaDao ppdao = new ProdutosPreVendaDao();
        
        idVendaGerado = preVendaDAO.SalvarPreVenda(preVenda);
        
        for (ProdutosPreVenda ip : preVenda.getItensProduto()) {
            ppdao.inserirItemProduto(ip, idVendaGerado);
         }
         
        return resultado;
    }
    
}
