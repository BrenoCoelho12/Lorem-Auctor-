/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dao.ClienteFisicoDao;
import tcc.dominio.ClienteFisico;


/**
 *
 * @author Breno-
 */
public class ClienteFisicoController {
    
      public int CadastrarCliente(ClienteFisico cliente) throws SQLException {
        int resultado;
        ClienteFisicoDao Cliente_fisicoDao  = new ClienteFisicoDao ();
        resultado = Cliente_fisicoDao.adicionarCliente(cliente);
        return resultado;
    }
      
      public List<ClienteFisico> listarClientes() throws SQLException {
        List<ClienteFisico> cliente = new ArrayList<ClienteFisico>();
        ClienteFisicoDao x = new ClienteFisicoDao();
        cliente = x.listarClientes();
        return cliente;
    }

     public int ApagarCliente(ClienteFisico cliente) throws SQLException {
        int resultado;
        ClienteFisicoDao Cliente_fisicoDao  = new ClienteFisicoDao ();
        resultado = Cliente_fisicoDao.apagarCliente(cliente);
        return resultado;
    }
}
