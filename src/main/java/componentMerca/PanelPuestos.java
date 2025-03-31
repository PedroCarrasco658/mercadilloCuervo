
package componentMerca;

import java.awt.event.ActionListener;

public class PanelPuestos extends javax.swing.JPanel {

 
    public PanelPuestos(ActionListener eventAnterior, ActionListener eventVerPuestos, ActionListener eventIntrPuestos) {
        initComponents();
        init(eventAnterior, eventVerPuestos, eventIntrPuestos);
    }
    
    public void init(ActionListener eventAnterior, ActionListener eventIntrPuestos , ActionListener eventVerPuestos){
        ButtonAnterior.addActionListener(eventAnterior);
        ButtonIntrPuesto.addActionListener(eventIntrPuestos);
        ButtonModPuesto.addActionListener(eventVerPuestos);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonIntrPuesto = new javax.swing.JButton();
        ButtonModPuesto = new javax.swing.JButton();
        ButtonAnterior = new javax.swing.JButton();

        ButtonIntrPuesto.setText("Introducir puesto");
        ButtonIntrPuesto.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonIntrPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIntrPuestoActionPerformed(evt);
            }
        });

        ButtonModPuesto.setText("Modificar puesto");
        ButtonModPuesto.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonModPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModPuestoActionPerformed(evt);
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
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonModPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonIntrPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(ButtonIntrPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonModPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonIntrPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIntrPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonIntrPuestoActionPerformed

    private void ButtonModPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonModPuestoActionPerformed

    private void ButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAnterior;
    private javax.swing.JButton ButtonIntrPuesto;
    private javax.swing.JButton ButtonModPuesto;
    // End of variables declaration//GEN-END:variables
}
