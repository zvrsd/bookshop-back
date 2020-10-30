package com.nope.bookshop.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection{

/**
 *
 * @author Cy
 */
public Connection conn;
public Statement stmt;
    public Connection dbConnectionOpen() throws SQLException { // return connection
                        
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("sa");
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setDatabaseName("BookShop");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Statement st = conn.createStatement();
            
            } catch (SQLServerException ex) {
            System.err.println("Oops:connexion:" + ex.getErrorCode()+ ex.getMessage());
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
        
     return conn;

    }        
//    Statement createStatement() throws SQLException {
//            Statement stmt = null;
//            stmt = dbConnectionOpen().createStatement();
//    return stmt;
//            
//    }
    /**Closing method 
     *
     */
    public void dbConnectionClose(){
    // Start DBConnection close
    
        try {
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Oops:close:"+ ex.getMessage());
        }
        System.out.println("Done!");
// END DBConnection close  
}        
    
}
