/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dao.VendedorDao;
import tcc.dominio.Vendedor;

/**
 *
 * @author Breno-
 */
public class VendedorController {
    
        public int CadastrarVendedor(Vendedor vendedor) throws SQLException {
        int resultado;
        VendedorDao VendedorDAO = new VendedorDao();
        resultado = VendedorDAO.adicionarVendedor(vendedor);
        return resultado;
    }
      
     public int AtualizarVendedor(Vendedor  vendedor) throws SQLException {
        int resultado;
        VendedorDao VendedorDAO = new VendedorDao();
        resultado = VendedorDAO.atualizarVendedor(vendedor);
        return resultado;
    }  
     
    public int ApagarVendedor(Vendedor vendedor) throws SQLException {
        int resultado;
        VendedorDao VendedorDAO = new VendedorDao();
        resultado = VendedorDAO.apagarVendedor(vendedor);
        return resultado;
    }
    
    public List<Vendedor> listarVendedores() throws SQLException {
        List<Vendedor> vendedor = new ArrayList<Vendedor >();
        VendedorDao x = new VendedorDao();
        vendedor = x.listarVendedores();
        return vendedor;
    }
      public List<Vendedor> listarnomeVendedores() throws SQLException {
        List<Vendedor> vendedor = new ArrayList<Vendedor >();
        VendedorDao x = new VendedorDao();
        vendedor = x.listarNomeVendedores();
        return vendedor;
    }
    
}
