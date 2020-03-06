/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dao.MovimentoDiarioDao;
import tcc.dominio.MovimentoDiario;

/**
 *
 * @author Breno-
 */
public class MovimentoDiarioController {
    
    public int CadastrarMovimentacao(MovimentoDiario movimento) throws SQLException {
        int resultado;
        MovimentoDiarioDao movimentoDao  = new MovimentoDiarioDao ();
        resultado = movimentoDao.cadastrarMovimento(movimento);
        return resultado;
    }

       public int ApagarMovimentacao(MovimentoDiario movimento) throws SQLException {
        int resultado;
        MovimentoDiarioDao Movimento_diarioDao  = new MovimentoDiarioDao ();
        resultado = Movimento_diarioDao.apagarMovimentacao1dia(movimento);
        return resultado;
    }
    
    public List<MovimentoDiario> listarMovimentacao() throws SQLException {
        List<MovimentoDiario> movimento = new ArrayList<MovimentoDiario>();
        MovimentoDiarioDao x = new MovimentoDiarioDao();
        movimento = x.listarMovimentacao();
        return movimento;
    }
}
