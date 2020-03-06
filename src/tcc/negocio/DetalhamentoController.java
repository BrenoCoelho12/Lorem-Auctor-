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
import tcc.dominio.DetalhamentoConta;

/**
 *
 * @author Breno-
 */
public class DetalhamentoController {
    /*
    public int CadastrarDetalhamento(DetalhamentoConta detalhamento) throws SQLException {
        int resultado;
        DetalhamentoContaDao detalhamentoDao = new DetalhamentoContaDao();
        resultado = detalhamentoDao.detalharConta(detalhamento, 0);
        return resultado;
    }*/
      
      public int CDetalhamento(DetalhamentoConta detalhamento) throws SQLException {
        int resultado;
        DetalhamentoContaDao detalhamentoDao = new DetalhamentoContaDao();
        resultado = detalhamentoDao.CDetalhamento(detalhamento);
        return resultado;
    }
      
        public int AtualizarDetalhamentoNaLista(DetalhamentoConta detalhamento) throws SQLException {
        int resultado;
        DetalhamentoContaDao detalhamentoDao = new DetalhamentoContaDao();
        resultado = detalhamentoDao.atualizarDetalhamentoNaLista(detalhamento);
        return resultado;
    }

      public int ApagarDetalhamento(DetalhamentoConta detalhamento) throws SQLException {
        int resultado;
        DetalhamentoContaDao detalhamentoDao = new DetalhamentoContaDao();
        resultado = detalhamentoDao.apagarDetalhamento(detalhamento);
        return resultado;
    }
      
      /*   public List<DetalhamentoConta> listarClientes() throws SQLException {
        List<DetalhamentoConta> detalhamento = new ArrayList<DetalhamentoConta>();
        DetalhamentoContaDao x = new DetalhamentoContaDao();
        detalhamento = x.listarDetalhamentoDasContas();
        return detalhamento;
    }*/
      
}
