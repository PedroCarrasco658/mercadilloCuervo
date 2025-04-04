/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package componentMerca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class PanelPuestosIntroducir extends javax.swing.JFrame {

    /**
     * Creates new form PanelPuestosIntroducir
     */
    public PanelPuestosIntroducir() {
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana
        actualizarPuestosDisponibles(); // Cargar puestos disponibles al abrir el formulario

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNumPuesto = new javax.swing.JLabel();
        jComboBoxNumPuestos = new javax.swing.JComboBox<>();
        jLabelMetrosAnchos = new javax.swing.JLabel();
        jTextFieldMetroAnchos = new javax.swing.JTextField();
        jLabelMetrosLargos = new javax.swing.JLabel();
        jTextFieldMetrosLargos = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setText("Crear nuevo puesto en el mercadillo");

        jLabelNumPuesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNumPuesto.setText("Numero de puesto:");

        jComboBoxNumPuestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));

        jLabelMetrosAnchos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMetrosAnchos.setText("Metros anchos del puesto:");

        jTextFieldMetroAnchos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMetroAnchosActionPerformed(evt);
            }
        });

        jLabelMetrosLargos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMetrosLargos.setText("Metros largos del puesto:");

        jTextFieldMetrosLargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMetrosLargosActionPerformed(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(163, 163, 163))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConfirmar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNumPuesto)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxNumPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMetrosAnchos)
                            .addComponent(jLabelMetrosLargos))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMetroAnchos, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jTextFieldMetrosLargos))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitulo)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumPuesto)
                    .addComponent(jComboBoxNumPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMetrosAnchos)
                    .addComponent(jTextFieldMetroAnchos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMetrosLargos)
                    .addComponent(jTextFieldMetrosLargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButtonConfirmar)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMetroAnchosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMetroAnchosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMetroAnchosActionPerformed

    private void jTextFieldMetrosLargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMetrosLargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMetrosLargosActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
     if (jTextFieldMetroAnchos.getText().trim().isEmpty() || jTextFieldMetrosLargos.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Obtener valores del formulario
            int numeroPuesto = Integer.parseInt(jComboBoxNumPuestos.getSelectedItem().toString());
            double metrosAncho = Double.parseDouble(jTextFieldMetroAnchos.getText().trim());
            double metrosLargo = Double.parseDouble(jTextFieldMetrosLargos.getText().trim());

            // Validar dimensiones (según tus restricciones CHECK en la BD)
            if (metrosAncho <= 0 || metrosAncho > 17 || metrosLargo <= 0 || metrosLargo > 17) {
                JOptionPane.showMessageDialog(this, 
                    "Las dimensiones deben ser mayores que 0 y menores o iguales a 17 metros", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/mercadillo";
            String user = "root";
            String password = "";

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                // Verificar si el puesto ya existe
                String verificarSql = "SELECT n_puesto FROM PUESTO WHERE n_puesto = ?";
                try (PreparedStatement verificarStmt = conn.prepareStatement(verificarSql)) {
                    verificarStmt.setInt(1, numeroPuesto);
                    if (verificarStmt.executeQuery().next()) {
                        JOptionPane.showMessageDialog(this, 
                            "El puesto número " + numeroPuesto + " ya existe", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Insertar nuevo puesto
                String insertSql = "INSERT INTO PUESTO (n_puesto, metrosAncho, metrosLargo) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                    insertStmt.setInt(1, numeroPuesto);
                    insertStmt.setDouble(2, metrosAncho);
                    insertStmt.setDouble(3, metrosLargo);

                    int filasInsertadas = insertStmt.executeUpdate();
                    if (filasInsertadas > 0) {
                        JOptionPane.showMessageDialog(this, 
                            "Puesto creado exitosamente", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                        actualizarPuestosDisponibles(); // Actualizar comboBox después de insertar
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error al conectar con la base de datos: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Las dimensiones deben ser valores numéricos válidos", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void limpiarCampos() {
        jTextFieldMetroAnchos.setText("");
        jTextFieldMetrosLargos.setText("");
        actualizarPuestosDisponibles(); // Actualizar comboBox al limpiar
    }
     private void actualizarPuestosDisponibles() {
        String url = "jdbc:mysql://localhost:3306/mercadillo";
        String user = "root";
        String password = "";

        jComboBoxNumPuestos.removeAllItems(); // Limpiar comboBox actual

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Obtener todos los puestos existentes
            String puestosOcupadosSql = "SELECT n_puesto FROM PUESTO";
            try (PreparedStatement pstmt = conn.prepareStatement(puestosOcupadosSql)) {
                ResultSet rs = pstmt.executeQuery();
                
                // Crear array para puestos ocupados
                java.util.List<Integer> puestosOcupados = new java.util.ArrayList<>();
                while (rs.next()) {
                    puestosOcupados.add(rs.getInt("n_puesto"));
                }
                
                // Agregar solo puestos no ocupados (1-50)
                for (int i = 1; i <= 50; i++) {
                    if (!puestosOcupados.contains(i)) {
                        jComboBoxNumPuestos.addItem(String.valueOf(i));
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al obtener puestos ocupados: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            
            // Si hay error, cargar todos los puestos (1-50) como fallback
            for (int i = 1; i <= 50; i++) {
                jComboBoxNumPuestos.addItem(String.valueOf(i));
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelPuestosIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPuestosIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPuestosIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPuestosIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPuestosIntroducir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxNumPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMetrosAnchos;
    private javax.swing.JLabel jLabelMetrosLargos;
    private javax.swing.JLabel jLabelNumPuesto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldMetroAnchos;
    private javax.swing.JTextField jTextFieldMetrosLargos;
    // End of variables declaration//GEN-END:variables
}
