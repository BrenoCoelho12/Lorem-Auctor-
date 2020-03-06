/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dao.ContasAPagarDao;
import tcc.dao.ProdutosDao;
import tcc.dominio.FormaPagamento;
import tcc.dominio.ContasAPagar;
import tcc.dominio.TipoProduto;

/**
 *
 * @author Breno-
 */
public class ContasAPagarController {
    
    public int CadastrarContas(ContasAPagar pagar_contas) throws SQLException {
        int resultado;
        ContasAPagarDao Pagar_contasDao  = new ContasAPagarDao ();
        resultado = Pagar_contasDao.adicionarContas(pagar_contas);
        return resultado;
    }
    
    public int ApagarContas(ContasAPagar pagar_contas) throws SQLException {
        int resultado;
        ContasAPagarDao Pagar_contasDao  = new ContasAPagarDao ();
        resultado = Pagar_contasDao.apagarConta(pagar_contas);
        return resultado;
    }
    
        public int AtualizarContas(ContasAPagar pagar_contas) throws SQLException {
        int resultado;
        ContasAPagarDao Pagar_contasDao  = new ContasAPagarDao ();
        resultado = Pagar_contasDao.atualizarConta(pagar_contas);
        return resultado;
    }

    public List<FormaPagamento> listarFormaspagamento() throws SQLException {
        List<FormaPagamento> fm = new ArrayList<FormaPagamento>();
        ContasAPagarDao x = new ContasAPagarDao();
        fm = x.listarFormaPagamento();
        return fm;
    }
    
            public List<ContasAPagar> listarContasapagar() throws SQLException {
        List<ContasAPagar> fm = new ArrayList<ContasAPagar>();
        ContasAPagarDao x = new ContasAPagarDao();
        fm = x.listarContasapagar();
        return fm;
    }

}
