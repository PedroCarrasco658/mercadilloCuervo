
package com.mycompany.mercadillo;

import com.raven.connection.DatabaseConnection;
import com.raven.loginMain.Main;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Mercadillo extends JFrame{

    public static void main(String[] args) {
        Main mercadillo = new Main();
        mercadillo.setVisible(true);
        mercadillo.setLocationRelativeTo(null);
        mercadillo.repaint();
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    

}
