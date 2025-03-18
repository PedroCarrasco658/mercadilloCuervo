package com.raven.AppMain;

import com.raven.component.PanelBuscarDatos;
import com.raven.component.PanelInicio;


public class MainApp extends javax.swing.JPanel {
    private PanelBuscarDatos pBuscarDatos;
    
    public MainApp() {
        initComponents();
        init();
    }
    
    public void init(){
        PanelInicio pInicio = new PanelInicio(pBuscarDatos);
        PanelBuscarDatos pBusarDatos = new PanelBuscarDatos();
        bg2.add(pInicio);
        bg2.add(pBusarDatos);
        
       // pInicio.setVisible(true);
        pBusarDatos.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg2 = new javax.swing.JLayeredPane();

        bg2.setForeground(new java.awt.Color(255, 255, 255));
        bg2.setOpaque(true);

        javax.swing.GroupLayout bg2Layout = new javax.swing.GroupLayout(bg2);
        bg2.setLayout(bg2Layout);
        bg2Layout.setHorizontalGroup(
            bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        bg2Layout.setVerticalGroup(
            bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg2)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg2;
    // End of variables declaration//GEN-END:variables
}
