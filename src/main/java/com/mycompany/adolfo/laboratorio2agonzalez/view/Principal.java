
package com.mycompany.adolfo.laboratorio2agonzalez.view;

import com.mycompany.adolfo.controller.UserController;
import com.mycompany.adolfo.laboratorio2agonzalez.view.login;
import com.mycompany.adolfo.model.User;
import javax.swing.JOptionPane;
/**
 *
 * @author adolf
 */
public class Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());
    private UserController controller = UserController.getInstance();
    private String modoActual = "Agregar";
    /**
     * Creates new form Principal
     */
    public Principal(String rolRecibido) {
        initComponents();

        // Configuramos el estado inicial (Agregar por defecto)
        cambiarEstado("Agregar");
        modoActual = "Agregar";
        // Cambiamos el texto de la etiqueta
        jLabel5.setText("Nombre Completo");

        // LÓGICA DE ROLES: Solo el Admin ve la tabla
        if (rolRecibido == null || !rolRecibido.equalsIgnoreCase("Admin")) {

            
            // Botones
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            // Nota: jButton3 (Log Out) NO lo ocultamos para que puedan salir.

            // Etiquetas
            //jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);

            // Menús y Barras
            jMenu1.setVisible(false);
            jMenu2.setVisible(false);
            jMenu3.setVisible(false);
            jMenu4.setVisible(false);
            jMenuBar1.setVisible(false);
            jMenuBar2.setVisible(false);

            // Items de Menú
            jMenuItem1.setVisible(false);
            jMenuItem2.setVisible(false);
            jMenuItem3.setVisible(false);
            jMenuItem4.setVisible(false);
            jMenuItem5.setVisible(false);
            jMenuItem6.setVisible(false);

            // Contenedores y Tablas
            //jPanel1.setVisible(false);
            jPopupMenu1.setVisible(false);
            jScrollPane1.setVisible(false);
            jTable1.setVisible(false);

            // Campos de Texto
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            
            
        } else {
            
        
            // Si es Admin, cargamos los datos
            actualizarTabla();
    }
}
    
    public void actualizarTabla() {
        // 1. Definir las columnas exactamente como en tu diseño
        String[] columnas = {"Nombre", "Correo", "Estado", "Rol"};

        // 2. Crear el modelo de la tabla
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(columnas, 0);

        // 3. Recorrer la lista de usuarios del controlador
        for (User u : controller.getUsuarios()) {
            String estado = u.isActivo() ? "Activo" : "Inactivo";

            // AGREGAMOS u.getNombre() al inicio para que aparezca en la primera columna
            Object[] fila = {u.getNombre(), u.getEmail(), estado, u.getRole()};
            modelo.addRow(fila);
        }

        // 4. Asignar el modelo a la tabla
        jTable1.setModel(modelo);
    }
    
    private void cambiarEstado(String modo) {
        jLabel3.setText("Función: " + modo);

        // Por defecto, habilitamos los campos
        jTextField3.setEditable(true); // Correo
        jTextField4.setEditable(true); // Contraseña
        jTextField1.setEditable(true); // Confirmar
        jComboBox1.setEnabled(true);   // Roles

        switch (modo) {
            case "Agregar":
                jLabel4.setVisible(false);     // Ocultamos "Usuario a Actualizar"
                jTextField2.setVisible(false);
                jButton1.setText("Guardar Nuevo");
                limpiarCampos();
                break;

            case "Actualizar":
                jLabel4.setVisible(true);
                jTextField2.setVisible(true);
                jButton1.setText("Actualizar Datos");
                break;

            case "Eliminar":
                // Usamos el texto de jTextField2 que es donde buscamos al usuario
                String emailAEliminar = jTextField2.getText(); 

                if (emailAEliminar.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Busca un usuario primero.");
                    return;
                }

                int conf = JOptionPane.showConfirmDialog(this, "¿Inactivar a " + emailAEliminar + "?");
                if (conf == JOptionPane.YES_OPTION) {
                    controller.setEstadoUsuario(emailAEliminar, false); // Cambia a inactivo
                    JOptionPane.showMessageDialog(this, "Usuario Inactivado");
                    actualizarTabla(); // REFRESCAR LA TABLA
                    limpiarCampos();
                }
                break;
        }
    }

    private void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Weolcome, use our system!");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Función:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario a Actualizar");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("nombre");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admins", "Maestro", "User" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jButton1.setText("Agregar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña");

        jButton2.setText("Buscar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Correo", "Estado", "Rol"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Log Out");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2)))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jMenu3.setText("Mantenimiento de Usuarios");

        jMenuItem3.setText("Add");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Delete");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Ver Usuarios");
        jMenuItem6.addActionListener(this::jMenuItem6ActionPerformed);
        jMenu3.add(jMenuItem6);

        jMenuItem5.setText("Update");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        cambiarEstado("Eliminar");
        modoActual = "Eliminar";
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        cambiarEstado("Actualizar");
        modoActual = "Actualizar";
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        cambiarEstado("Agregar");
        modoActual = "Agregar";
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = jTextField1.getText(); 
        String emailForm = jTextField3.getText(); // Email en el campo de edición
        String pass = jTextField4.getText();
        String role = jComboBox1.getSelectedItem().toString();
        String emailOriginal = jTextField2.getText(); // El email usado en "Buscar"

        // Validaciones para Agregar y Actualizar
        if (modoActual.equals("Agregar") || modoActual.equals("Actualizar")) {
            if (nombre.isEmpty() || emailForm.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }
            if (!controller.esPasswordSegura(pass)) {
                JOptionPane.showMessageDialog(this, "La clave debe tener 13 caracteres, una mayúscula y un signo.");
                return;
            }
        }

        switch (modoActual) {
            case "Agregar":
                controller.agregarUsuario(nombre, emailForm, pass, role);
                JOptionPane.showMessageDialog(this, "¡Usuario " + nombre + " agregado!");
                break;

            case "Actualizar":
                if (emailOriginal.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Busca un usuario primero.");
                    return;
                }
                controller.modificarUsuario(nombre, emailOriginal, pass, role);
                JOptionPane.showMessageDialog(this, "Datos actualizados.");
                break;

            case "Eliminar":
                if (emailOriginal.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Busca un usuario primero.");
                    return;
                }
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Inactivar a " + emailOriginal + "?");
                if (respuesta == JOptionPane.YES_OPTION) {
                    controller.setEstadoUsuario(emailOriginal, false); // CAMBIO A INACTIVO
                    JOptionPane.showMessageDialog(this, "Usuario Inactivado.");
                }
                break;
        }

        actualizarTabla(); // REFRESCAR SIEMPRE LA TABLA
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        actualizarTabla();
        JOptionPane.showMessageDialog(this, "Lista de usuarios actualizada.");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String correoABuscar = jTextField2.getText();
    
        // Usamos el método buscarUsuario que creamos en el controlador
        User encontrado = controller.buscarUsuario(correoABuscar);

        if (encontrado != null) {
            jTextField1.setText(encontrado.getNombre());
            jTextField3.setText(encontrado.getEmail());
            jTextField4.setText(encontrado.getPassword());
            jComboBox1.setSelectedItem(encontrado.getRole());

            if (!encontrado.isActivo()) {
                JOptionPane.showMessageDialog(this, "Nota: El usuario seleccionado está INACTIVO.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado en el sistema.");
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // 1. Preguntar al usuario si está seguro (Opcional, pero muy profesional)
        int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de que deseas cerrar sesión?", 
                "Cerrar Sesión", 
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            // 2. Cerramos la ventana actual (Principal)
            this.dispose();

            // 3. Creamos y mostramos la ventana de Login
            login lg = new login();
            lg.setVisible(true);

            // Opcional: Centrar la ventana de login al abrirla
            lg.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal("Admin").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
