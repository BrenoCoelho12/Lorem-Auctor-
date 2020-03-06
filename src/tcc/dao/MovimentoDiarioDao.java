/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.MovimentoDiario;

/**
 *
 * @author Breno-
 */
public class MovimentoDiarioDao extends GenericDAO {
    
     public int cadastrarMovimento(MovimentoDiario movimento) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO movimentoDiario (precoTotal, dataCadastroVarejo) VALUES (?, ?)");
            pstmt.setBigDecimal(1, movimento.getPrecoTotal());
            pstmt.setString(2, movimento.getDataCadastroVarejo());
            
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }   
         
     public int apagarMovimentacao1dia(MovimentoDiario movimento_diario) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
                      pstmt = connection.prepareStatement("DELETE FROM movimentoDiario WHERE idMovimento = ?");
            pstmt.setInt(1, movimento_diario.getIdMovimento());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }

        public List<MovimentoDiario> listarMovimentacao() throws SQLException {
        List<MovimentoDiario> y = new ArrayList<MovimentoDiario>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM movimentoDiario");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                MovimentoDiario movimento = new MovimentoDiario();
                
                movimento.setIdMovimento(resultSet.getInt("idMovimento"));
                movimento.setPrecoTotal(resultSet.getBigDecimal("precoTotal"));
                movimento.setDataCadastroVarejo(resultSet.getString("dataCadastroVarejo"));
              
                
                y.add(movimento);
            }
        } finally {
            finishConnection();
        }
        return y;
    
           }
        
        public List<MovimentoDiario> listarMovimentacaoVarejoPorData(String dataInicio, String dataFim) throws SQLException {
        List<MovimentoDiario> y = new ArrayList<MovimentoDiario>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM movimentoDiario where dataCadastroVarejo between ? and ?;");
            pstmt.setString(1, dataInicio);
            pstmt.setString(2, dataFim);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                MovimentoDiario movimento = new MovimentoDiario();
                
                movimento.setIdMovimento(resultSet.getInt("idMovimento"));
                movimento.setPrecoTotal(resultSet.getBigDecimal("precoTotal"));
                movimento.setDataCadastroVarejo(resultSet.getString("dataCadastroVarejo"));
                
                y.add(movimento);
            }
        } finally {
            finishConnection();
        }
        return y;
    
           }
        
        public MovimentoDiario informacoesMovimentacaoDiaria(int idMovimentacao) throws SQLException {
        MovimentoDiario m = new MovimentoDiario();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM movimentoDiario WHERE idMovimento = ?");
            pstmt.setInt(1, idMovimentacao);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                
                m.setIdMovimento(resultSet.getInt("idMovimento"));
                m.setPrecoTotal(resultSet.getBigDecimal("precoTotal"));
                m.setDataCadastroVarejo(resultSet.getString("dataCadastroVarejo"));
                
            }
        } finally {
            finishConnection();
        }
        return m;
    }
}