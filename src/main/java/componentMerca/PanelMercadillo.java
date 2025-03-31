
package componentMerca;

import java.awt.event.ActionListener;


public class PanelMercadillo extends javax.swing.JPanel {


    public PanelMercadillo(ActionListener eventVerDatos, ActionListener eventClientes, ActionListener eventPuestos, ActionListener eventSalir, ActionListener eventPago) {
        initComponents();
        init(eventVerDatos, eventClientes, eventPuestos, eventSalir, eventPago);
    }
    
    public void init(ActionListener eventVerDatos, ActionListener eventClientes, ActionListener eventPuestos, ActionListener eventSalir, ActionListener eventPago){
        ButtonVerDatos.addActionListener(eventVerDatos);
        ButtonCliente.addActionListener(eventClientes);
        ButtonPuestos.addActionListener(eventPuestos);
        ButtonSalir.addActionListener(eventSalir);
        ButtonPagos.addActionListener(eventPago);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonVerDatos = new javax.swing.JButton();
        ButtonPuestos = new javax.swing.JButton();
        ButtonCliente = new javax.swing.JButton();
        ButtonSalir = new javax.swing.JButton();
        ButtonPagos = new javax.swing.JButton();

        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButtonVerDatos.setText("Ver datos");
        ButtonVerDatos.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVerDatosActionPerformed(evt);
            }
        });

        ButtonPuestos.setText("Puestos");
        ButtonPuestos.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPuestosActionPerformed(evt);
            }
        });

        ButtonCliente.setText("Cliente");
        ButtonCliente.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteActionPerformed(evt);
            }
        });

        ButtonSalir.setText("Salir");
        ButtonSalir.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        ButtonPagos.setText("Pagos");
        ButtonPagos.setPreferredSize(new java.awt.Dimension(185, 40));
        ButtonPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ButtonVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVerDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonVerDatosActionPerformed

    private void ButtonPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPuestosActionPerformed

    private void ButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonClienteActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSalirActionPerformed

    private void ButtonPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPagosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCliente;
    private javax.swing.JButton ButtonPagos;
    private javax.swing.JButton ButtonPuestos;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton ButtonVerDatos;
    // End of variables declaration//GEN-END:variables
}
