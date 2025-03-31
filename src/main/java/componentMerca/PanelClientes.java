
package componentMerca;

import java.awt.event.ActionListener;

public class PanelClientes extends javax.swing.JPanel {


    public PanelClientes(ActionListener eventAnterior, ActionListener eventCreateCliente, ActionListener eventModCliente) {
        initComponents();
        init(eventAnterior, eventCreateCliente, eventModCliente);
    }
    public void init(ActionListener eventAnterior, ActionListener eventCreateCliente, ActionListener eventModCliente){
        ButtonAnterior.addActionListener(eventAnterior);
        ButtonIntrCliente.addActionListener(eventCreateCliente);
        ButtonModCliente.addActionListener(eventModCliente);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonIntrCliente = new javax.swing.JButton();
        ButtonModCliente = new javax.swing.JButton();
        ButtonAnterior = new javax.swing.JButton();
        ButtonDeleteCliente = new javax.swing.JButton();

        ButtonIntrCliente.setText("Introducir Cliente");
        ButtonIntrCliente.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonIntrCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIntrClienteActionPerformed(evt);
            }
        });

        ButtonModCliente.setText("Modificar Cliente");
        ButtonModCliente.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonModCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModClienteActionPerformed(evt);
            }
        });

        ButtonAnterior.setText("Anterior");
        ButtonAnterior.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAnteriorActionPerformed(evt);
            }
        });

        ButtonDeleteCliente.setText("Eliminar Cliente");
        ButtonDeleteCliente.setPreferredSize(new java.awt.Dimension(185, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonDeleteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonModCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonIntrCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(ButtonIntrCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonModCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonDeleteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonIntrClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIntrClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonIntrClienteActionPerformed

    private void ButtonModClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonModClienteActionPerformed

    private void ButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAnterior;
    private javax.swing.JButton ButtonDeleteCliente;
    private javax.swing.JButton ButtonIntrCliente;
    private javax.swing.JButton ButtonModCliente;
    // End of variables declaration//GEN-END:variables
}
