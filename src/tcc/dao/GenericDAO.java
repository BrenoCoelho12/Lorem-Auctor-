/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import tcc.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public abstract class GenericDAO {
    
    protected Connection connection = null;
    protected PreparedStatement pstmt = null;
    protected Statement stmt = null;
    protected ResultSet resultSet = null;
    
    protected void getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = ConnectionFactory.getInstance().getConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void finishConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    }

