package com.raven.component;

import com.raven.loginModel.ModelUser;
import com.raven.loginSwing.Button;
import com.raven.loginSwing.MyPasswordField;
import com.raven.loginSwing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author 1dam
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private MyTextField txtUser;
    private MyTextField txtEmail;
    private MyPasswordField txtPass;

    public PanelLoginAndRegister(ActionListener eventRegister) {
        initComponents();
        initRegister(eventRegister);
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]40[]10[]10[]30[]push"));
        JLabel label = new JLabel("Crear cuenta");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(32, 255, 184));
        register.add(label);

        txtUser = new MyTextField();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/com/raven/icon/user.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        txtUser.setPrefixIcon(new ImageIcon(scaledImage));
        txtUser.setBackgroundColor(new Color(220, 253, 245));
        txtUser.setHint("Nombre");
        register.add("width 60%", txtUser);

        txtEmail = new MyTextField();
        txtEmail.setBackgroundColor(new Color(220, 253, 245));
        ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/com/raven/icon/mail.png"));
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        txtEmail.setPrefixIcon(new ImageIcon(scaledImage2));
        txtEmail.setHint("Email");
        register.add("width 60%", txtEmail);

        txtPass = new MyPasswordField();
        txtPass.setBackgroundColor(new Color(220, 253, 245));
        ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/com/raven/icon/pass.png"));
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        txtPass.setPrefixIcon(new ImageIcon(scaledImage3));
        txtPass.setHint("Contraseña");
        register.add("width 60%", txtPass);

        Button cmd = new Button();
        cmd.setBackground(new Color(32, 255, 184));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("Registrarse");
        register.add(cmd, "w 40%, h 40");

        // Eliminar el ActionListener interno que actualiza user, ya que getUser() lo hará
    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]50[]10[]35[]14[]push"));
        JLabel label = new JLabel("Iniciar Sesión");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(32, 255, 184));
        login.add(label);

        MyTextField txtEmail = new MyTextField();
        txtEmail.setBackgroundColor(new Color(220, 253, 245));
        ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/com/raven/icon/mail.png"));
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        txtEmail.setPrefixIcon(new ImageIcon(scaledImage2));
        txtEmail.setHint("Email");
        login.add("width 60%", txtEmail);

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setBackgroundColor(new Color(220, 253, 245));
        ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/com/raven/icon/pass.png"));
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        txtPass.setPrefixIcon(new ImageIcon(scaledImage3));
        txtPass.setHint("Contraseña");
        login.add("width 60%", txtPass);

        JButton cmdForget = new JButton("¿Has olvidado tu contraseña?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("Sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        cmdForget.setBorderPainted(false);
        cmdForget.setFocusPainted(false);
        cmdForget.setOpaque(false);

        Button cmd = new Button();
        cmd.setBackground(new Color(32, 255, 184));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Inicia Sesión");
        login.add(cmd, "w 40%, h 40");
    }

    public ModelUser getUser() {
        String userName = txtUser.getText().trim();
        String email = txtEmail.getText().trim();
        String password = String.valueOf(txtPass.getPassword()).trim();
        return new ModelUser(0, userName, email, password); // Ajusta el constructor si es necesario
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
