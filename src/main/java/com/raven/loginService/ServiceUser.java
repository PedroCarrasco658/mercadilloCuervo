package com.raven.loginService;

import com.raven.connection.DatabaseConnection;
import com.raven.loginModel.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;


public class ServiceUser {
    private final Connection con;
    
    public ServiceUser(){
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    public void insertUser(ModelUser user) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into 'user' (UserName, Email, Password, VerifyCode) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();
        p.setString(1, user.getUserName());
        p.setString(2, user.getEmail());
        p.setString(3, user.getPassword());
        p.setString(4, code);
        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.first();
        int userID=r.getInt(1);
        r.close();
        p.close();
        user.setUserID(userID);
        user.setVerifyCode(code);
    }
    
    private String generateVerifyCode()throws SQLException{
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
        PreparedStatement p = con.prepareStatement("select UserID from 'user' where VerifyCode = ? limit 1");
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
        PreparedStatement p=con.prepareStatement("select UserID from 'user' where UserName? and 'Status'='Verified' limit 1"); 
        p.setString(1,user);
        ResultSet r=p.executeQuery();
        if(r.first()){
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }
     public boolean checkDuolicateEmail(String user) throws SQLException{
        boolean duplicate = false;
        PreparedStatement p=con.prepareStatement("select UserID from `user` where Email? and `Statu`='Verified' limit 1"); 
        p.setString(1,user);
        ResultSet r=p.executeQuery();
        if(r.first()){
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }
     public void doneVerify(int userId) throws SQLException{
         PreparedStatement p=con.prepareStatement("update `user` set VerifyCode='',`Status`='Verify' where UserID=? limit 1");
         p.setInt(1, userId);
         p.close();
         
     }
     public boolean verifyCodeWithUser(int userID, String code) throws SQLException{
         boolean verify = false;
         PreparedStatement p=con.prepareStatement("select UserID from `user` where UserID=? and VerifyCode=? limit 1");
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
}
