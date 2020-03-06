/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package tcc.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;




public class ConnectionFactory {

    private static String url = "jdbc:mysql://localhost:3306/bancoljm";
    private static String usuario = "root";
    private static String senha = "root";
    
    private static ConnectionFactory fabrica = null;
    
    private ConnectionFactory(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
            catch (ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM O BANCO DE DADOS. ENTRE EM CONTATO COM O DESENVOLVEDOR! ");
                JOptionPane.showMessageDialog(null, ex);
                        ex.printStackTrace();
                    }
       
    }
    
    public static ConnectionFactory getInstance(){
        if(fabrica == null){
            fabrica = new ConnectionFactory();
        }
        return fabrica;
    }
    
    public Connection getConnection() throws SQLException{
        
        Connection con = DriverManager.getConnection(url, usuario, senha);
        return con;
    }
    
}
