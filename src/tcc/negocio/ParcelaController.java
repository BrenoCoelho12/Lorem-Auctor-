/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import tcc.dao.ParcelaDao;
import tcc.dao.VendaDao;
import tcc.dominio.Parcelas;
import tcc.dominio.Venda;

/**
 *
 * @author Breno-
 */
public class ParcelaController {
    
     public int CadastrarParcelas(Parcelas parcela) throws SQLException {
        int resultado = 0;
        ParcelaDao parcelaDAO = new ParcelaDao();
        resultado = parcelaDAO.adicionarParcelas(parcela);
        return resultado;
    }
    
}
    