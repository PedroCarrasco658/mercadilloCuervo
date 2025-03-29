
package com.raven.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseConnectionMercadillo {
    
    
    private static Connection connection; 
    public DatabaseConnectionMercadillo(){
        getConnection();
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql, 
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY);
    }

    public PreparedStatement getPreparedStatementGeneratedKeys(String sql) throws SQLException {
        return connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
    }
    //patron singleton
    private Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/mercadillo";
        String userName = "root";
        String password = "1234";
        if(connection == null){
            try{
                connection = java.sql.DriverManager.getConnection(url, userName, password);
                
            }catch(SQLException e){
                
            }
        }
        return connection;
    }
    
    

    
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
