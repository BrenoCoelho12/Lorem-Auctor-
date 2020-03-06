/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import java.util.Date;
import tcc.dominio.Time;

/**
 *
 * @author Breno-
 */
public class TimeDao extends GenericDAO {
 
        public Time horaMysql() throws SQLException {
        Time t = new Time();
        try {
            getConnection();
            pstmt = connection.prepareStatement("select * from horaMysql;");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                
             t.setHoraMysql(resultSet.getDate("created_on"));
            }
        } finally {
            finishConnection();
        }
        return t;
    }
}
