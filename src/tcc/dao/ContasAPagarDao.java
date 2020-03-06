/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.FormaPagamento;
import tcc.dominio.ContasAPagar;
import tcc.dominio.Produtos;


public class ContasAPagarDao extends GenericDAO{
    
    public int adicionarContas(ContasAPagar pagar_contas) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO pagarContas (empresa, valor, dataVencimento, idFormaPagamento, contaBancaria, situacaoConta) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, pagar_contas.getEmpresa());
            pstmt.setBigDecimal(2, pagar_contas.getValor());
            pstmt.setString(3, (pagar_contas.getDataVencimento()));
            pstmt.setInt(4, pagar_contas.getFormaPagamento().getIdFormaPagamento());
            pstmt.setString(5, (pagar_contas.getContaBancaria()));
            pstmt.setString(6, pagar_contas.getSituacaoConta());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     public int atualizarConta(ContasAPagar pc) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("UPDATE pagarContas SET empresa = ?, valor = ?, idFormaPagamento = ?, dataVencimento = ?, dataCheque = ?, contaBancaria = ?, situacaoConta = ? WHERE idConta = ?");
            pstmt.setString(1, pc.getEmpresa());
            pstmt.setBigDecimal(2, pc.getValor());
            pstmt.setInt(3, pc.getFormaPagamento().getIdFormaPagamento());
            pstmt.setString(4, pc.getDataVencimento());
            pstmt.setString(5, pc.getDataCheque());
            pstmt.setString(6,    pc.getContaBancaria());
            pstmt.setString(7,    pc.getSituacaoConta());
            pstmt.setInt(8, pc.getIdConta());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
    
         public int apagarConta(ContasAPagar pc) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("DELETE FROM pagarContas WHERE idConta = ?");
            pstmt.setInt(1, pc.getIdConta());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }

           public List<FormaPagamento> listarFormaPagamento() throws SQLException {
        List<FormaPagamento> y = new ArrayList<FormaPagamento>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM formaPagamento");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                FormaPagamento fp = new FormaPagamento();
                
                fp.setIdFormaPagamento(resultSet.getInt("idFormaPagamento"));
                fp.setFormaPagamento(resultSet.getString("formaPagamento"));
                
                y.add(fp);
            }
        } finally {
            finishConnection();
        }
        return y;
    
           }

           public List<ContasAPagar> listarContasapagar() throws SQLException {
        List<ContasAPagar> y = new ArrayList<ContasAPagar>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT pc.idConta, pc.empresa, pc.valor, pc.dataVencimento, pc.contaBancaria, pc.idFormaPagamento, pc.situacaoConta, fp.idFormaPagamento, fp.formaPagamento FROM pagarContas pc INNER JOIN formaPagamento fp on (pc.idFormaPagamento = fp.idFormaPagamento) ORDER BY empresa ASC");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
         
                FormaPagamento fp = new FormaPagamento();
                fp.setIdFormaPagamento(resultSet.getInt("idFormaPagamento"));
                fp.setFormaPagamento(resultSet.getString("formaPagamento"));
                
                ContasAPagar pc = new ContasAPagar();
                pc.setIdConta(resultSet.getInt("idConta"));
                pc.setEmpresa(resultSet.getString("empresa"));
                pc.setValor(resultSet.getBigDecimal("valor"));
                pc.setDataVencimento(resultSet.getString("dataVencimento"));
                pc.setContabancaria(resultSet.getString("contaBancaria"));
                pc.setSituacaoConta(resultSet.getString("situacaoConta"));
                pc.setFormaPagamento(fp);
            
                y.add(pc);
            }
        } finally {
            finishConnection();
        }
        return y;
    }
}