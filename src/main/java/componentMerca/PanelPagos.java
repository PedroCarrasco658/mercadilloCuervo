/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package componentMerca;

import java.awt.event.ActionListener;

/**
 *
 * @author pedro
 */
public class PanelPagos extends javax.swing.JPanel {

    
    public PanelPagos(ActionListener eventHacerPago, ActionListener eventEliminarPago, ActionListener eventAnterior) {
        initComponents();
        init(eventHacerPago, eventEliminarPago, eventAnterior);
    }
    private void init(ActionListener eventHacerPago, ActionListener eventEliminarPago, ActionListener eventAnterior){
        ButtonEliminarPago.addActionListener(eventEliminarPago);
        ButtonHacerPago.addActionListener(eventHacerPago);
        ButtonAnterior.addActionListener(eventAnterior);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonHacerPago = new javax.swing.JButton();
        ButtonEliminarPago = new javax.swing.JButton();
        ButtonAnterior = new javax.swing.JButton();

        ButtonHacerPago.setText("Hacer pago");
        ButtonHacerPago.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonHacerPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHacerPagoActionPerformed(evt);
            }
        });

        ButtonEliminarPago.setText("Eliminar Pago");
        ButtonEliminarPago.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEliminarPagoActionPerformed(evt);
            }
        });

        ButtonAnterior.setText("Anterior");
        ButtonAnterior.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonEliminarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonHacerPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(ButtonHacerPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonEliminarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonHacerPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHacerPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonHacerPagoActionPerformed

    private void ButtonEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEliminarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEliminarPagoActionPerformed

    private void ButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAnterior;
    private javax.swing.JButton ButtonEliminarPago;
    private javax.swing.JButton ButtonHacerPago;
    // End of variables declaration//GEN-END:variables
}
