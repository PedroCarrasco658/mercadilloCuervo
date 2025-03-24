
package componentMerca;

import java.awt.event.ActionListener;


public class PanelMercadillo extends javax.swing.JPanel {


    public PanelMercadillo(ActionListener eventVerDatos, ActionListener eventClientes, ActionListener eventPuestos, ActionListener eventSalir) {
        initComponents();
        init(eventVerDatos, eventClientes, eventPuestos, eventSalir);
    }
    
    public void init(ActionListener eventVerDatos, ActionListener eventClientes, ActionListener eventPuestos, ActionListener eventSalir){
        ButtonVerDatos.addActionListener(eventVerDatos);
        ButtonCliente.addActionListener(eventClientes);
        ButtonPuestos.addActionListener(eventPuestos);
        ButtonSalir.addActionListener(eventSalir);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonVerDatos = new javax.swing.JButton();
        ButtonPuestos = new javax.swing.JButton();
        ButtonCliente = new javax.swing.JButton();
        ButtonSalir = new javax.swing.JButton();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(ButtonVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCliente;
    private javax.swing.JButton ButtonPuestos;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton ButtonVerDatos;
    // End of variables declaration//GEN-END:variables
}
