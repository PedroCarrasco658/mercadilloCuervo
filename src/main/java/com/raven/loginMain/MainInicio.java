
package com.raven.loginMain;

import com.raven.loginModel.ModelUser;
import componentMerca.PanelClientes;
import componentMerca.PanelEliminaPago;
import componentMerca.PanelHacerPago;
import componentMerca.PanelIntrCliente;
import componentMerca.PanelIntrPuesto;
import componentMerca.PanelMercadillo;
import componentMerca.PanelModCliente;
import componentMerca.PanelPagos;
import componentMerca.PanelPuestos;
import componentMerca.PanelVerDatos;
import componentMerca.PanelVerPuesto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;


public class MainInicio extends javax.swing.JFrame {
    private PanelMercadillo panelMercadillo;
    private PanelVerDatos VerDatos;
    private PanelClientes Clientes;
    private PanelPuestos Puestos;
    private PanelIntrPuesto createPuesto;
    private PanelVerPuesto verPuesto;
    private PanelIntrCliente createCliente;
    private PanelModCliente ModCliente;
    private PanelPagos pagos;
    private PanelHacerPago HacerPago;
    private PanelEliminaPago EliminarPago;
    
    
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
        ActionListener eventAnterior2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Anterior2();
            } 
        };
        ActionListener eventAnterior3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Anterior3();
            } 
        };
        ActionListener eventIntrPuestos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                IntrPuesto();
            } 
        };
        ActionListener eventVerPuestos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                VerPuesto();
            } 
        };
        ActionListener eventIntrCliente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                IntrCliente();
            } 
        };
        ActionListener eventModCliente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                ModCliente();
            } 
        };
        ActionListener eventPago = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pago();
            } 
        };
        ActionListener eventHacerPago = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                HacerPago();
            } 
        };
        ActionListener eventEliminarPago = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                EliminarPago();
            } 
        };
        
        panelMercadillo = new PanelMercadillo(eventVerDatos, eventClientes, eventPuestos, eventSalir, eventPago);
        VerDatos = new PanelVerDatos(eventAnterior);
        Clientes = new PanelClientes(eventAnterior, eventIntrCliente, eventModCliente);
        Puestos = new PanelPuestos(eventAnterior, eventIntrPuestos, eventVerPuestos);
        createPuesto = new PanelIntrPuesto(eventAnterior2);
        verPuesto = new PanelVerPuesto(eventAnterior2);
        createCliente = new PanelIntrCliente(eventAnterior3);
        ModCliente = new PanelModCliente(eventAnterior3);
        pagos = new PanelPagos(eventHacerPago, eventEliminarPago, eventAnterior);
        HacerPago = new PanelHacerPago();
        EliminarPago = new PanelEliminaPago();
        

        // Establecer el layout a null (no usar ningún layout manager)
        setLayout(null);
        
        centrarPanel(panelMercadillo);
        centrarPanel(VerDatos);
        centrarPanel(Clientes);
        centrarPanel(Puestos);
        centrarPanel(createPuesto);
        centrarPanel(verPuesto);
        centrarPanel(createCliente);
        centrarPanel(ModCliente);
        centrarPanel(pagos);
        centrarPanel(HacerPago);
        centrarPanel(EliminarPago);
        
       

        // Añadir los paneles al JFrame
        add(panelMercadillo);
        add(VerDatos);
        add(Clientes);
        add(Puestos);
        add(createPuesto);
        add(verPuesto);
        add(createCliente);
        add(ModCliente);
        add(pagos);
        add(HacerPago);
        add(EliminarPago);

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
    private void Anterior2() {
        mostrarPanel(Puestos);
    }
    private void Anterior3() {
        mostrarPanel(Clientes);
    }
    private void IntrPuesto() {
        mostrarPanel(createPuesto);
    }
    private void VerPuesto() {
        mostrarPanel(verPuesto);
    }
    private void IntrCliente() {
        mostrarPanel(createCliente);
    }
    private void ModCliente() {
        mostrarPanel(ModCliente);
    }
    private void Pago() {
        mostrarPanel(pagos);
    }
    private void HacerPago() {
        mostrarPanel(HacerPago);
    }
    private void EliminarPago() {
        mostrarPanel(EliminarPago);
    }
    private void mostrarPanel(javax.swing.JPanel panelMostrado) {
        panelMercadillo.setVisible(panelMostrado == panelMercadillo);
        VerDatos.setVisible(panelMostrado == VerDatos);
        Clientes.setVisible(panelMostrado == Clientes);
        Puestos.setVisible(panelMostrado == Puestos);
        createPuesto.setVisible(panelMostrado == createPuesto);
        verPuesto.setVisible(panelMostrado == verPuesto);
        createCliente.setVisible(panelMostrado == createCliente);
        ModCliente.setVisible(panelMostrado == ModCliente);
        pagos.setVisible(panelMostrado == pagos);
        HacerPago.setVisible(panelMostrado == HacerPago);
        EliminarPago.setVisible(panelMostrado == EliminarPago);
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
