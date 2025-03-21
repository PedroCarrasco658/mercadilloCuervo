package com.raven.loginService;

import com.raven.connection.DatabaseConnection;
import com.raven.loginModel.ModelLogin;
import com.raven.loginModel.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;


public class ServiceUser {
    private final DatabaseConnection con;
    
    
    
    public ServiceUser(){
        con = new DatabaseConnection();
    }
    public ModelUser login(ModelLogin login)throws SQLException{
        ModelUser data=null;
        PreparedStatement p = con.getPreparedStatement("SELECT UserID, UserName, Email FROM `user` WHERE BINARY(Email) = ? and BINARY(Password) = ? and Status ='Verify' limit 1");
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());
        ResultSet r=p.executeQuery();
        if(r.first()){
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String email=r.getString(3);
            data = new ModelUser(userID, userName, email, "");
        }
        r.close();
        p.close();
        return data;
    }
    
    public void insertUser(ModelUser user) throws SQLException {
        String code = generateVerifyCode();
        String query = "INSERT INTO `user` (Username, Email, Password, VerifyCode) VALUES (?, ?, ?, ?);";
        System.out.println("Conexión en ServiceUser: " + con);
        try (PreparedStatement p = con.getPreparedStatementGeneratedKeys(query)) {
            p.setString(1, user.getUsername());
            p.setString(2, user.getEmail());
            p.setString(3, user.getPassword());
            p.setString(4, code);
            System.out.println("Insertando usuario: " + user.getUsername());
            System.out.println("Conexión en ServiceUser: " + con);
            // Ejecutar la inserción
            p.executeUpdate();

            try (ResultSet r = p.getGeneratedKeys()) {
                if (r.next()) {
                    int userID = r.getInt(1);
                    user.setUserID(userID);
                } else {
                    throw new SQLException("No generated keys found.");
                }
            }

            // Asignar el código de verificación generado
            user.setVerifyCode(code);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-lanzar la excepción para que pueda ser manejada fuera de este método
        }
    }
    
    public String generateVerifyCode()throws SQLException{
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));
        while(checkDuplicateCode(code)){
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }
    private boolean checkDuplicateCode(String code)throws SQLException{
        boolean duplicate = false;
        PreparedStatement p = con.getPreparedStatement("select UserID from `user` where VerifyCode = ? limit 1");
        p.setString(1,code);
        ResultSet r = p.executeQuery();
        if(r.first()){
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }
    public boolean checkDuplicateUser(String user) throws SQLException{
        boolean duplicate = false;
        PreparedStatement p=con.getPreparedStatement("select UserID from `user` where UserName = ? and `Status` = 'Verify' limit 1"); 
        p.setString(1,user);
        ResultSet r=p.executeQuery();
        if(r.first()){
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }
     public boolean checkDuplicateEmail(String user) throws SQLException{
        boolean duplicate = false;
        String query = "select UserID from `user` where Email = ? and `Status` = 'Verify' limit 1";

        try (PreparedStatement p = con.getPreparedStatement(query);) {
            p.setString(1, user);
            try (ResultSet r = p.executeQuery()) {
                duplicate = r.next(); // Esto es más simple que r.first()
            }
        }
        return duplicate;
    }
     public void doneVerify(int userId) throws SQLException{
         PreparedStatement p=con.getPreparedStatement("update `user` set VerifyCode= '',`Status`='Verify' where UserID=? limit 1");
         p.setInt(1, userId);
         p.execute();
         p.executeUpdate();
         p.close();
         
     }
     public boolean verifyCodeWithUser(int userID, String code) throws SQLException{
         boolean verify = false;
         PreparedStatement p=con.getPreparedStatement("select UserID from `user` where UserID = ? and VerifyCode=? limit 1");
         p.setInt(1, userID);
         p.setString(2,code);
         ResultSet r=p.executeQuery();
         if(r.first()){
             verify = true;
         }
         r.close();
         p.close();
         return verify;
     }
    public void actualizarContraseña(String nuevaContraseña, String Email) throws SQLException {
        String sql = "UPDATE `user` SET Password = ? WHERE Email = ?"; // Cambia esto según tu estructura
        try(PreparedStatement p = con.getPreparedStatement(sql);){
            p.setString(1, nuevaContraseña);
            p.setString(2, Email); // Debes asegurarte de tener el email guardado en `dataLogin`
            p.executeUpdate();
        }
    }
    public boolean existsEmail(String email) throws SQLException {
        String query = "SELECT 1 FROM `user` WHERE Email = ? LIMIT 1";

        try (PreparedStatement p = con.getPreparedStatement(query)) {
            p.setString(1, email);
            try (ResultSet r = p.executeQuery()) {
                return r.next(); // Devuelve true si el correo existe
            }
        }
    }
    public ModelUser getUserByEmail(String email) throws SQLException {
        ModelUser user = null;
        String query = "SELECT UserID, UserName, Email, Password, VerifyCode FROM `user` WHERE Email = ? LIMIT 1";

        try (PreparedStatement p = con.getPreparedStatement(query)) {
            p.setString(1, email);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    int userID = r.getInt("UserID");
                    String userName = r.getString("UserName");
                    String userEmail = r.getString("Email");
                    String Password = r.getString("VerifyCode");
                    String VerifyCode = r.getString("VerifyCode");
                    user = new ModelUser(userID, userName, userEmail, Password, VerifyCode); 
                }
            }
        }
        return user;
    }
}
