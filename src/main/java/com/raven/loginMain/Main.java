
package com.raven.loginMain;

import com.raven.component.Message;
import com.raven.component.PanelCover;
import com.raven.component.PanelLoading;
import com.raven.component.PanelLoginAndRegister;
import com.raven.component.PanelVerifyCode;
import com.raven.loginModel.ModelUser;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.raven.database.ConexionDB;
public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize=60;
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
    
    private final DecimalFormat df = new DecimalFormat("##0.###", symbols);
    private PanelLoginAndRegister loginAndRegister;
    
    
    
    public Main() {
        initComponents();
        init();
    }
    
    public void init(){
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        ActionListener eventRegister = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                register();
            } 
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction){
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if(fraction <= 0.5f){
                    size+= fraction * addSize;
                }else{
                    size += addSize - fraction * addSize;
                    
                }
                if(isLogin){
                    fractionCover = 1f-fraction;
                    fractionLogin = fraction;
                    if(fraction>= 0.5f){
                        
                    }else{
                        
                    }
                }else{
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if(fraction <= 0.5f){
                     //   cover.registerLeft(fraction * 100);
                    }else{
                      //  cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if(fraction >= 0.5f){
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
                
            }
            @Override
            public void end(){
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800,target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(loading,"pos 0 0 100% 100%");
        bg.add(verifyCode,"pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        });
    }
        
    private void register() {
    ModelUser user = loginAndRegister.getUser();
    if (user == null) {
        showMessage(Message.MessageType.ERROR, "No se obtuvo información del usuario.");
        return;
    }

    // Obtener y limpiar los campos
    String nombre = user.getUserName() != null ? user.getUserName().trim() : "";
    String email = user.getEmail() != null ? user.getEmail().trim() : "";
    String password = user.getPassword() != null ? user.getPassword().trim() : "";

    // Validaciones
    if (nombre.isEmpty()) {
        showMessage(Message.MessageType.ERROR, "El nombre es obligatorio.");
        return;
    }

    if (email.isEmpty()) {
        showMessage(Message.MessageType.ERROR, "El email es obligatorio.");
        return;
    }

    // Validar formato del email solo si no está vacío
    if (!email.isEmpty() && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
        showMessage(Message.MessageType.ERROR, "El email no tiene un formato válido.");
        return;
    }

    if (password.isEmpty()) {
        showMessage(Message.MessageType.ERROR, "La contraseña es obligatoria.");
        return;
    }

    if (password.length() < 6) {
        showMessage(Message.MessageType.ERROR, "La contraseña debe tener al menos 6 caracteres.");
        return;
    }

    // Mostrar el panel de carga
    loading.setVisible(true);

    // Operación en un hilo separado para no bloquear la UI
    new Thread(() -> {
        String sql = "INSERT INTO Cliente (nombre, email, contrasena, dni) VALUES (?, ?, ?, ?)"; // Corrección de typo
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Mapear campos a Cliente, asegurando todos los parámetros
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.setString(3, password); // Siempre se establece, validado previamente
            pstmt.setNull(4, java.sql.Types.VARCHAR); // dni opcional, siempre NULL

            int rowsAffected = pstmt.executeUpdate();
            java.awt.EventQueue.invokeLater(() -> {
                loading.setVisible(false);
                if (rowsAffected > 0) {
                    showMessage(Message.MessageType.SUCCESS, "Cliente registrado exitosamente!");
                } else {
                    showMessage(Message.MessageType.ERROR, "Error al registrar el cliente (ninguna fila afectada).");
                }
            });
        } catch (SQLException e) {
            java.awt.EventQueue.invokeLater(() -> {
                loading.setVisible(false);
                showMessage(Message.MessageType.ERROR, "Error de base de datos: " + e.getMessage());
            });
            e.printStackTrace();
        }
    }).start();
}
    
    private void showMessage(Message.MessageType messageType, String message){
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
                if(!ms.isShow()){
                    bg.add(ms,"pos 1.5al -30", 0);
                    ms.setVisible(true);
                    ms.setLocation(150, 10);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if(ms.isShow()){
                    f=40 * (1f - fraction);
                }else{
                    f=40*fraction;
                }
                layout.setComponentConstraints(ms, "pos 1.5 "+(int)(f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if(ms.isShow()){
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
            
        };
        
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    animator.start();
                }catch (InterruptedException e){
                    System.err.println(e);
                } 
            }
           
        }).start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
    
    
}
