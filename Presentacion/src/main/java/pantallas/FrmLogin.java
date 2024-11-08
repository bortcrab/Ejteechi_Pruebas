/*
 * FrmLogin.java
 */
package pantallas;

import dtos.UsuarioDTO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import iniciarSesion.FacadeIniciarSesion;
import iniciarSesion.IIniciarSesion;
import iniciarSesion.IniciarSesionException;
import java.awt.Color;
import utilidades.Validador;

/**
 * Clase que representa la pantalla para que el usuario pueda iniciar sesión.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FrmLogin extends javax.swing.JFrame {

    private final IIniciarSesion facadeIniciarSesion;

    /**
     * Constructor que inicializa los componentes de la clase.
     */
    public FrmLogin() {
        initComponents();

        this.facadeIniciarSesion = new FacadeIniciarSesion();
    }

    /**
     * Método iniciar sesión con el correo y contraseña introducidos.
     */
    private void iniciarSesion() {
        try {
            // Obtenemos el correo y las contraseñas sin espacios.
            String correo = txtCorreo.getText().trim();
            String contrasenia = new String(pwdContrasenia.getPassword()).trim();

            // Creamos una instancia del validador.
            Validador validador = new Validador();

            try {
                // Validamos cada dato.
                validador.validarVacio(correo);
                validador.validarVacio(contrasenia);
            } catch (PresentacionException ex) {
                throw new PresentacionException("Favor de llenar ambos campos.");
            }

            // Creamos un usuario DTO con los datos introducidos.
            UsuarioDTO usuario = new UsuarioDTO(correo, contrasenia, "");

            // Mandamos a iniciar sesión.
            usuario = facadeIniciarSesion.iniciarSesion(usuario);

            // Si el usuario NO es un cliente
            if (!usuario.getTipo().equals("cliente")) {
                // Redireccionamos al usuario al home para trabajadores.
                FrmHomeTrabajador frmHome = new FrmHomeTrabajador(usuario);
                frmHome.setVisible(true);
            } else { // Si el usuario SÍ es un cliente.
                // Redireccionamos al usuario al home para clientes.
                FrmHomeCliente frmHome = new FrmHomeCliente(usuario);
                frmHome.setVisible(true);
            }
            this.dispose();
        } catch (PresentacionException | IniciarSesionException ex) {
            // Mostramos mensajes de errores.
            JOptionPane.showMessageDialog(this, ex.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrate = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        pwdContrasenia = new javax.swing.JPasswordField();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrate.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrate.setText("Regístrate");
        btnRegistrate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseExited(evt);
            }
        });
        jPanel1.add(btnRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 120, 30));
        btnRegistrate.setBorder(BorderFactory.createMatteBorder(0,0,2,0, java.awt.Color.WHITE));

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 440, 60));

        btnIngresar.setBackground(new java.awt.Color(133, 175, 218));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(null);
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 440, 60));

        pwdContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pwdContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdContraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(pwdContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 440, 60));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Group 18 (2).png"))); // NOI18N
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que reacciona al evento de dar clic en el botón para iniciar
     * sesión.
     *
     * @param evt Evento al que se escucha.
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnIngresarActionPerformed

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * iniciar sesión y cambiar el color del texto.
     *
     * @param evt Evento al que se escucha
     */
    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
        btnIngresar.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnIngresarMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de iniciar sesión y cambiar el color del texto.
     *
     * @param evt Evento al que se escucha
     */
    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        // TODO add your handling code here:
        btnIngresar.setForeground(Color.white);
    }//GEN-LAST:event_btnIngresarMouseExited

    /**
     * Método que reacciona al evento de dar clic en el botón para crear una
     * cuenta nueva.
     *
     * @param evt Evento al que se escucha.
     */
    private void btnRegistrateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseClicked
        FrmRegistroCliente frmRegistrar = new FrmRegistroCliente();
        frmRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrateMouseClicked

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * crear una cuenta y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void btnRegistrateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseEntered
        // TODO add your handling code here:
        btnRegistrate.setForeground(Color.BLACK);
        btnRegistrate.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
    }//GEN-LAST:event_btnRegistrateMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de crear una cuenta y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void btnRegistrateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseExited
        // TODO add your handling code here:
        btnRegistrate.setForeground(Color.WHITE);
        btnRegistrate.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
    }//GEN-LAST:event_btnRegistrateMouseExited

    /**
     * Método para que cuando se presione enter se mande a iniciar sesión.
     *
     * @param evt Evento al que se escucha.
     */
    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_txtCorreoActionPerformed

    /**
     * Método para que cuando se presione enter se mande a iniciar sesión.
     *
     * @param evt Evento al que se escucha.
     */
    private void pwdContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdContraseniaActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_pwdContraseniaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel btnRegistrate;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pwdContrasenia;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

}
