/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.Vendedor;

/**
 *
 * @author Breno-
 */
public class VendedorDao extends GenericDAO {
    
    public int adicionarVendedor(Vendedor vendedor) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO vendedor (nomeVendedor, salario) VALUES (?, ?)");
            pstmt.setString(1, vendedor.getNomeVendedor());
            pstmt.setBigDecimal(2, vendedor.getSalario());
            
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     
    
      public int atualizarVendedor(Vendedor vendedor) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("UPDATE vendedor SET nomeVendedor = ?, salario = ? WHERE id_vendedor = ?");
            pstmt.setString(1, vendedor.getNomeVendedor());
            pstmt.setBigDecimal(2, vendedor.getSalario());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     public int apagarVendedor(Vendedor vendedor) throws SQLException {
        int resultado = 0;
        try {
                      pstmt = connection.prepareStatement("DELETE FROM vendedor WHERE id_vendedor = ?");
            pstmt.setInt(1, vendedor.getIdVendedor());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
    
     
     public List<Vendedor> listarVendedores() throws SQLException {
        List<Vendedor> y = new ArrayList<Vendedor>();
        try {
            pstmt = connection.prepareStatement("SELECT v. ORDER BY nomeVendedor ASC");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Vendedor vendedor = new Vendedor();
                
                vendedor.setIdVendedor(resultSet.getInt("id_vendedor"));
                vendedor.setSalario(resultSet.getBigDecimal("salario"));
                
                y.add(vendedor);
            }
        } finally {
            finishConnection();
        }
        return y;
    }

          public List<Vendedor> listarNomeVendedores() throws SQLException {
        List<Vendedor> y = new ArrayList<Vendedor>();
        try {
            getConnection();
                pstmt = connection.prepareStatement("SELECT * FROM vendedor");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Vendedor vendedor = new Vendedor();
                
                vendedor.setIdVendedor(resultSet.getInt("idVendedor"));
                vendedor.setNomeVendedor(resultSet.getString("nomeVendedor"));
                vendedor.setSalario(resultSet.getBigDecimal("salario"));
                
                y.add(vendedor);
            }
        } finally {
            finishConnection();
        }
        return y;
    }

}
