
package com.raven.loginMain;

import com.raven.loginModel.ModelUser;
import java.awt.Color;


public class MainSystem extends javax.swing.JFrame {

    private final ModelUser user;
    public MainSystem(ModelUser user) {
        this.user = user;
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        ibUser.setText(user.getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ibUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ibUser.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        ibUser.setForeground(new java.awt.Color(76, 76, 76));
        ibUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ibUser.setText("Nombre de Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(589, Short.MAX_VALUE)
                .addComponent(ibUser, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(491, 491, 491))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(ibUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(ModelUser user) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSystem(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ibUser;
    // End of variables declaration//GEN-END:variables
}
