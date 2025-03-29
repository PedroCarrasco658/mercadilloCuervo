
package com.raven.loginMain;

import com.raven.loginModel.ModelUser;
import componentMerca.PanelClientes;
import componentMerca.PanelMercadillo;
import componentMerca.PanelPuestos;
import componentMerca.PanelVerDatos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;


public class MainInicio extends javax.swing.JFrame {
    private PanelMercadillo panelMercadillo;
    private PanelVerDatos VerDatos;
    private PanelClientes Clientes;
    private PanelPuestos Puestos;
    public MainInicio() {
        initComponents();
        init();
    }
    
    public void init(){
        ActionListener eventVerDatos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                VerDatos();
            } 
        };
        ActionListener eventClientes = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Clientes();
            } 
        };
        ActionListener eventPuestos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Puestos();
            } 
        };
        ActionListener eventSalir = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Salir();
            } 
        };
        ActionListener eventAnterior = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Anterior();
            } 
        };
        
        panelMercadillo = new PanelMercadillo(eventVerDatos, eventClientes, eventPuestos, eventSalir);
        VerDatos = new PanelVerDatos(eventAnterior);
        Clientes = new PanelClientes(eventAnterior);
        Puestos = new PanelPuestos(eventAnterior);
        
        

        // Establecer el layout a null (no usar ningún layout manager)
        setLayout(null);
        
        centrarPanel(panelMercadillo);
        centrarPanel(VerDatos);
        centrarPanel(Clientes);
        centrarPanel(Puestos);
       

        // Añadir los paneles al JFrame
        add(panelMercadillo);
        add(VerDatos);
        add(Clientes);
        add(Puestos);

        mostrarPanel(panelMercadillo);
        
        
    }
    
    private void VerDatos() {
        mostrarPanel(VerDatos);
    }

    private void Clientes() {
        mostrarPanel(Clientes);
    }

    private void Puestos() {
        mostrarPanel(Puestos);
    }

    private void Salir() {
        this.dispose();
    }
    private void Anterior() {
        mostrarPanel(panelMercadillo);
    }
    private void mostrarPanel(javax.swing.JPanel panelMostrado) {
        panelMercadillo.setVisible(panelMostrado == panelMercadillo);
        VerDatos.setVisible(panelMostrado == VerDatos);
        Clientes.setVisible(panelMostrado == Clientes);
        Puestos.setVisible(panelMostrado == Puestos);
        pb.revalidate();
        pb.repaint();
    }
    private void centrarPanel(javax.swing.JPanel panel) {
        int width = getWidth();
        int height = getHeight();

        // Calcular la posición centrada para el panel
        int panelWidth = panel.getPreferredSize().width; // Usamos el tamaño preferido del panel
        int panelHeight = panel.getPreferredSize().height; // Usamos el tamaño preferido del panel
        int xPos = (width - panelWidth) / 2;
        int yPos = (height - panelHeight) / 2;

        // Establecer las coordenadas para centrar el panel
        panel.setBounds(xPos, yPos, panelWidth, panelHeight);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pb = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pb.setPreferredSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout pbLayout = new javax.swing.GroupLayout(pb);
        pb.setLayout(pbLayout);
        pbLayout.setHorizontalGroup(
            pbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        pbLayout.setVerticalGroup(
            pbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pb, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane pb;
    // End of variables declaration//GEN-END:variables
}
