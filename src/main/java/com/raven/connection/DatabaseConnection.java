
package com.raven.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection; 
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    private DatabaseConnection(){
        
    }
    
    /*public void connectToDatabase() throws SQLException{
      String server = "db.fxqnjyvpvcxthoboxozu.supabase.co"; 
      String port = "5432"; 
      String database = "postgres"; // Nombre de la base de datos
      String userName = "postgres"; // Usuario por defecto en Supabase
      String password = "eta%2A2x7qF6Z%26RGP"; 
        connection = java.sql.DriverManager.getConnection("jdbc:postgresql://" + server + ":" + port + "/" + database, userName, password);

        
    }*/
    public void connectToDatabase() throws SQLException {
    String url = "jdbc:postgresql://aws-0-eu-west-3.pooler.supabase.com:6543/postgres";
    String userName = "postgres.fxqnjyvpvcxthoboxozu";
    String password = "eta*2x7qF6Z&RGP"; // Tu contraseña real

    connection = java.sql.DriverManager.getConnection(url, userName, password);
}

    public Connection getConnection(){
        return connection;
        
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}