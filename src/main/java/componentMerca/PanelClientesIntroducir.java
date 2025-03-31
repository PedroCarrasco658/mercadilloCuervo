
package componentMerca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class PanelClientesIntroducir extends javax.swing.JFrame {

    
    public PanelClientesIntroducir() {
        initComponents();
    }
    private void cargarDatosIniciales(){
        cargarPuestosDisponibles();
        cargarFormasPago();
    }
    
    private void cargarPuestosDisponibles() {
    String url = "jdbc:mysql://localhost:3306/mercadillo";
    String user = "root";
    String password = "1234";
    
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        // Consulta mejorada para obtener puestos disponibles
        String sql = "SELECT p.n_puesto FROM PUESTO p " +
                     "WHERE p.n_puesto NOT IN (" +
                     "    SELECT a.n_puesto FROM ALQUILER a " +
                     "    WHERE a.ffin IS NULL OR a.ffin >= CURDATE()" +
                     ") " +
                     "UNION " +
                     "SELECT p.n_puesto FROM PUESTO p " +
                     "WHERE p.n_puesto NOT IN (SELECT n_puesto FROM ALQUILER) " +
                     "ORDER BY n_puesto";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("-- Seleccione puesto --"); // Opción por defecto
        
        boolean tienePuestos = false;
        while (rs.next()) {
            model.addElement(String.valueOf(rs.getInt("n_puesto")));
            tienePuestos = true;
        }
        
        jComboBox1.setModel(model);
        
        if (!tienePuestos) {
            JOptionPane.showMessageDialog(this, 
                "No hay puestos disponibles para asignar.\n" +
                "Todos los puestos están actualmente alquilados.", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar puestos: " + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
    
    private void cargarFormasPago() {
    String url = "jdbc:mysql://localhost:3306/mercadillo";
    String user = "root";
    String password = "1234";
    
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        String sql = "SELECT nombre_tipo FROM FORMA_PAGO ORDER BY cod_fp";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        
        while (rs.next()) {
            model.addElement(rs.getString("nombre_tipo"));
        }
        
        
        if (model.getSize() == 0) {
            JOptionPane.showMessageDialog(this, 
                "No se encontraron formas de pago en la base de datos", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar formas de pago: " + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNomCli = new javax.swing.JLabel();
        jTextFieldNomCli = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelNumPues = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelTipoPago1 = new javax.swing.JLabel();
        txtEpigrafe = new javax.swing.JTextField();
        jLabelTipoPago2 = new javax.swing.JLabel();
        txtImportePorMes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setText("Crear nuevo cliente");

        jLabelNomCli.setText("Nombre del cliente:");

        jLabelDni.setText("DNI:");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelNumPues.setText("Numero de puesto que irá asignado");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelTipoPago1.setText("Epigrafe");

        jLabelTipoPago2.setText("Importe por mes");

        txtImportePorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImportePorMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabelTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonConfirmar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNumPues)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTipoPago1)
                                .addGap(18, 18, 18)
                                .addComponent(txtEpigrafe, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNomCli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTipoPago2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtImportePorMes, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDni)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomCli)
                    .addComponent(jTextFieldNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDni)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumPues)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoPago2)
                    .addComponent(txtImportePorMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoPago1)
                    .addComponent(txtEpigrafe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        String nombre = jTextFieldNomCli.getText().trim();
        String dni = jTextFieldDni.getText().trim();
        double importeMes = 0.0;
        try {
            importeMes = Double.parseDouble(txtImportePorMes.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String numPuestoStr = (String) jComboBox1.getSelectedItem();
        
        if (nombre.isEmpty() || dni.isEmpty() || numPuestoStr == null || 
            numPuestoStr.equals("-- Seleccione puesto --")) {
            JOptionPane.showMessageDialog(this, 
                "Todos los campos son obligatorios", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!validarDNI(dni)) {
            JOptionPane.showMessageDialog(this, 
                "El DNI no tiene un formato válido (8 números + letra)", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int numPuesto = Integer.parseInt(numPuestoStr);
            
            // Configuración de la conexión
            String url = "jdbc:mysql://localhost:3306/mercadillo";
            String user = "root";
            String password = "1234";
            
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                conn.setAutoCommit(false); // Iniciar transacción
                
                try {
                    // 1. Insertar cliente
                    String sqlCliente = "INSERT INTO CLIENTE (nombre, dni, importe_mes) VALUES (?, ?, ?)";
                    PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente, PreparedStatement.RETURN_GENERATED_KEYS);
                    stmtCliente.setString(1, nombre);
                    stmtCliente.setString(2, dni);
                    stmtCliente.setDouble(3, importeMes);
                    
                    int filasAfectadas = stmtCliente.executeUpdate();
                    
                    if (filasAfectadas == 0) {
                        throw new SQLException("No se pudo crear el cliente");
                    }
                    
                    // Obtener el ID del cliente insertado
                    int codCliente = -1;
                    try (ResultSet rs = stmtCliente.getGeneratedKeys()) {
                        if (rs.next()) {
                            codCliente = rs.getInt(1);
                        }
                    }
                    
                    
                    
                    
                    
                    // 3. Insertar alquiler
                    String sqlAlquiler = "INSERT INTO ALQUILER (n_puesto, cod_cl, finicio) " +
                                       "VALUES (?, ?, ?, CURDATE())";
                    try (PreparedStatement stmtAlquiler = conn.prepareStatement(sqlAlquiler)) {
                        stmtAlquiler.setInt(1, numPuesto);
                        stmtAlquiler.setInt(2, codCliente);
                        
                        filasAfectadas = stmtAlquiler.executeUpdate();
                        
                        if (filasAfectadas == 0) {
                            throw new SQLException("No se pudo asignar el puesto");
                        }
                    }
                    
                    conn.commit(); // Confirmar transacción
                    
                    JOptionPane.showMessageDialog(this, 
                        "Cliente creado y puesto asignado correctamente", 
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    cargarPuestosDisponibles(); // Actualizar lista de puestos
                    
                } catch (SQLException ex) {
                    conn.rollback(); // Revertir en caso de error
                    throw ex;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Número de puesto inválido", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error de base de datos: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void txtImportePorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImportePorMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImportePorMesActionPerformed
    private double calcularImportePuesto(int numPuesto, Connection conn) throws SQLException {
        // Puedes implementar lógica para calcular el importe basado en las dimensiones del puesto
        // Por ahora usaremos un valor fijo por simplicidad
        return 1800.00; // Valor por defecto
    }
    private boolean validarDNI(String dni) {
        // Validación básica de DNI (8 números + letra)
        return dni.matches("^[0-9]{8}[A-Za-z]$");
    }
    
    private void limpiarCampos() {
        jTextFieldNomCli.setText("");
        jTextFieldDni.setText("");
        jComboBox1.setSelectedIndex(0);
    }
   
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
            java.util.logging.Logger.getLogger(PanelClientesIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelClientesIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelClientesIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelClientesIntroducir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelClientesIntroducir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelNomCli;
    private javax.swing.JLabel jLabelNumPues;
    private javax.swing.JLabel jLabelTipoPago1;
    private javax.swing.JLabel jLabelTipoPago2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNomCli;
    private javax.swing.JTextField txtEpigrafe;
    private javax.swing.JTextField txtImportePorMes;
    // End of variables declaration//GEN-END:variables
}
class Cliente {
    private String nombre;
    private String dni;
    private int numeroPuesto;
    private String tipoPago;

    public Cliente(String nombre, String dni, int numeroPuesto, String tipoPago) {
        this.nombre = nombre;
        this.dni = dni;
        this.numeroPuesto = numeroPuesto;
        this.tipoPago = tipoPago;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }
}