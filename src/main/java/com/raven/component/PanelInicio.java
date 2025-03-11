
package com.raven.component;

import com.raven.loginSwing.Button;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;


public class PanelInicio extends javax.swing.JPanel {

    private final PanelBuscarDatos PBuscarDatos;

   
    public PanelInicio(PanelBuscarDatos PBuscarDatos) {
        initComponents();
        this.PBuscarDatos = PBuscarDatos;
        initPInicio();
        pInicio.setVisible(true);
    }
    
    public void initPInicio(){
        pInicio.setLayout(new MigLayout("wrap", "push[center]push", "push[]10[]10[]10[]push"));
        pInicio.setBounds(0, 0, 500, 500);
        
        cargarDatos.setBackground(Color.yellow);
        cargarDatos.setText("Cargar Datos");
        
        cerrarSesion.setBackground(Color.yellow);
        cerrarSesion.setText("Cerrar Sesión");
        
        verDatos.setBackground(Color.yellow);
        verDatos.setText("Ver Datos");
        
        salir.setBackground(Color.yellow);
        salir.setText("Salir");
        
        pInicio.add(cargarDatos, "w 200, h 40");
        pInicio.add(cerrarSesion, "w 200, h 40");
        pInicio.add(verDatos, "w 200, h 40");
        pInicio.add(salir, "w 200, h 40");
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pInicio = new javax.swing.JPanel();
        cargarDatos = new javax.swing.JButton();
        verDatos = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        pInicio.setBackground(new java.awt.Color(102, 204, 255));
        pInicio.setPreferredSize(new java.awt.Dimension(400, 400));

        cargarDatos.setText("Cargar Datos");
        cargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosActionPerformed(evt);
            }
        });

        verDatos.setText("jButton1");

        cerrarSesion.setText("jButton2");

        salir.setText("jButton3");

        javax.swing.GroupLayout pInicioLayout = new javax.swing.GroupLayout(pInicio);
        pInicio.setLayout(pInicioLayout);
        pInicioLayout.setHorizontalGroup(
            pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInicioLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(verDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        pInicioLayout.setVerticalGroup(
            pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInicioLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(cargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void buscarDatosActionPerformed(java.awt.event.ActionEvent evt) {
    pInicio.setVisible(false);
    PBuscarDatos.setVisible(true);
    } 
    private void cargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cargarDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarDatos;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JPanel pInicio;
    private javax.swing.JButton salir;
    private javax.swing.JButton verDatos;
    // End of variables declaration//GEN-END:variables
}
