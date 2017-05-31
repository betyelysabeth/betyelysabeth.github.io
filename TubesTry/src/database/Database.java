/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author satrio
 */
public class Database {
    private Connection con;
    private Statement st;
    
    public void connect() throws SQLException {
        try {
            con = (Connection) DriverManager.getConnection("");
            st = (Statement) con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect() throws SQLException {
        try {
            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean manipulasiData(String query)throws SQLException{
        try {
            if (st.executeUpdate(query) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet getData(String query)
    {
        try {
            return st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
