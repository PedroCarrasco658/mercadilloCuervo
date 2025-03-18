
package com.mycompany.mercadillo;

import com.raven.AppMain.MainApp;
import com.raven.component.PanelInicio;
import com.raven.connection.DatabaseConnection;
import com.raven.loginMain.MainLogin;
import java.sql.SQLException;
import javax.swing.JFrame;
//import com.raven.component.PanelInicio;

public class Mercadillo extends JFrame{

    public static void main(String[] args) {
        
        
        
        MainLogin login = new MainLogin();
       // MainApp mercadillo = new MainApp();
       // mercadillo.setVisible(true);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.repaint();
      //  mercadillo.setVisible(true); 
    }

    

}
