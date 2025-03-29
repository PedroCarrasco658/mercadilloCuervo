
package componentMerca;

import com.raven.Service.ServiceMerca;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import java.sql.*;
import javax.swing.JOptionPane;

public class PanelVerDatos extends javax.swing.JPanel {
    private ServiceMerca serviceMerca;
    private DefaultTableModel tableModel;
    public PanelVerDatos(ActionListener eventAnterior) {
        initComponents();
        serviceMerca = new ServiceMerca();
        init(eventAnterior);
    }
    private void init(ActionListener eventAnterior) {
        ButtonAnterior.addActionListener(eventAnterior);
        // Escucha del campo de búsqueda
        buscador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = buscador.getText().trim();  // Eliminar espacios al principio y al final
                String selectedColumn = (String) valorBuscador.getSelectedItem();
                System.out.println("Texto de búsqueda: " + searchText);

                if (!searchText.isEmpty()) {
                    // Si el texto no está vacío, mostrar resultados de búsqueda
                    showSearchResults(selectedColumn, searchText);
                } else {
                    // Si el texto está vacío, mostrar todos los resultados
                    tableModel.setRowCount(0);  // Limpiar la tabla
                    showSearchAllResults(selectedColumn);
                }
            }
        });

        // Llamada inicial para mostrar todos los resultados si el campo de búsqueda está vacío
        String selectedColumn = (String) valorBuscador.getSelectedItem();
        showSearchAllResults(selectedColumn);  // Ejecutar la consulta con resultados completos al iniciar

        // Escucha de cambios en el JComboBox para detectar cambios en la selección
        valorBuscador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColumn = (String) valorBuscador.getSelectedItem();
                String searchText = buscador.getText().trim();

                // Verificar si el campo de búsqueda está vacío
                if (searchText.isEmpty()) {
                    // Si el campo está vacío, mostrar todos los resultados para la nueva columna seleccionada
                    tableModel.setRowCount(0);  // Limpiar la tabla
                    showSearchAllResults(selectedColumn);
                } else {
                    // Si el campo no está vacío, realizar la búsqueda con el texto proporcionado
                    showSearchResults(selectedColumn, searchText);
                }
            }
        });
        isPendPago.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedColumn = (String) valorBuscador.getSelectedItem();
                String searchText = buscador.getText().trim();

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Si "Pendiente de pago" está seleccionado, mostrar los resultados correspondientes
                    if (searchText.isEmpty()) {
                        // Si el campo de búsqueda está vacío, mostrar todos los resultados pendientes
                        tableModel.setRowCount(0);  // Limpiar la tabla
                        showSearchAllResults(selectedColumn);
                    } else {
                        // Si hay texto, filtrar por los resultados pendientes
                        showSearchResults(selectedColumn, searchText);
                    }
                } else {
                    // Si "Pendiente de pago" no está seleccionado, mostrar todos los resultados
                    if (searchText.isEmpty()) {
                        // Si el campo de búsqueda está vacío, mostrar todos los resultados
                        tableModel.setRowCount(0);  // Limpiar la tabla
                        showSearchAllResults(selectedColumn);
                    } else {
                        // Si hay texto, mostrar los resultados según el texto de búsqueda
                        showSearchResults(selectedColumn, searchText);
                    }
                }
            }
        });
        }
    private void showSearchResults(String column, String searchText) {
        tableModel = new DefaultTableModel();
        tabla.setModel(tableModel);
        ResultSet rs = obtenerResultados(column, searchText);
        if (rs == null) {
            System.out.println("No se pudo obtener datos.");
            return;
        }

        try {
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0); // Elimina columnas antes de añadir nuevas

            // Obtener metadatos para determinar columnas dinámicamente
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Agregar los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Agregar las filas con datos
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close(); // Cierra el ResultSet después de usarlo
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void showSearchAllResults(String column) {
        tableModel = new DefaultTableModel();
        tabla.setModel(tableModel);
        ResultSet rs = obtenerResultadosTodos(column);
        if (rs == null) {
            System.out.println("No se pudo obtener datos.");
            return;
        }

        try {
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0); // Elimina columnas antes de añadir nuevas

            // Obtener metadatos para determinar columnas dinámicamente
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Agregar los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Agregar las filas con datos
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close(); // Cierra el ResultSet después de usarlo
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private ResultSet obtenerResultados(String column, String searchText) {
        switch (column) {
            case "NOMBRE":
                if(isPendPago.isSelected()){
                    return serviceMerca.searchDataNombrePend(column, searchText);
                }else{
                    return serviceMerca.searchDataNombre(column, searchText);
                }
            case "EPÍGRAFE":
                    return serviceMerca.searchDataEpi(column,searchText);
                
            case "VENCIMIENTO":
                    return serviceMerca.searchDataVencimiento(column,searchText);
            
            case "PAGO":
                    return serviceMerca.searchDataPago(column,searchText);
            
            case "PUESTO":
                    return serviceMerca.searchDataPuesto(column,searchText);
            default:
                return null; // O manejar un caso de error
        }
    }
    private ResultSet obtenerResultadosTodos(String column) {
        switch (column) {
            case "NOMBRE":
                if(isPendPago.isSelected()){
                    return serviceMerca.searchDataNombrePendTodo(column);
                }else{
                    return serviceMerca.searchDataNombreTodo(column);
                }
                     
            case "EPÍGRAFE":
                    return serviceMerca.searchDataEpiTodo(column);
                
            case "VENCIMIENTO":
                    return serviceMerca.searchDataVencimientoTodo(column);
                    
            case "PAGO":
            return serviceMerca.searchDataPagoTodo(column);
            
            case "PUESTO":
            return serviceMerca.searchDataPuestoTodo(column);
            default:
                return null; // O manejar un caso de error
        }
    }
    

    
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valorBuscador = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        buscador = new javax.swing.JTextField();
        isPendPago = new javax.swing.JCheckBox();
        ButtonAnterior = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        valorBuscador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "EPÍGRAFE", "VENCIMIENTO", "PAGO", "PUESTO" }));
        valorBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorBuscadorActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        isPendPago.setText("Pendiente de pago");

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
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valorBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(isPendPago))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isPendPago))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(ButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void valorBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorBuscadorActionPerformed

    private void ButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAnterior;
    private javax.swing.JTextField buscador;
    private javax.swing.JCheckBox isPendPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> valorBuscador;
    // End of variables declaration//GEN-END:variables
}
