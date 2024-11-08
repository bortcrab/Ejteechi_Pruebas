/*
 * FrmTicketNuevo.java
 */
package pantallas;

import administrarTickets.IAdministrarTickets;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.awt.Color;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;
import utilidades.Validador;

/**
 * Clase que representa la pantalla donde el cliente puede redactar un ticket
 * nuevo.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FrmTicketNuevo extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final UsuarioDTO usuario;

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param usuario Usuario que está logueado en el sistema.
     * @param facadeAdministrarTickets Interfaz para administrar tickets.
     * @throws PresentacionException si ocurre un error a la hora de validar la
     * sesión.
     */
    public FrmTicketNuevo(UsuarioDTO usuario, IAdministrarTickets facadeAdministrarTickets) throws PresentacionException {
        initComponents();

        this.facadeAdministrarTickets = facadeAdministrarTickets;
        this.usuario = usuario;

        // Validamos la sesión.
        Validador.validarSesion(usuario, this);
    }

    /**
     * Método para enviar un ticket.
     */
    private void enviarTicket() {
        try {
            // Obtenemos los datos del ticket.
            String contenido = areaTicket.getText();
            String emisor = usuario.getNombres() + " " + usuario.getApellidoPaterno();
            ObjectId idUsuario = usuario.getId();

            // Validamos el contenido del ticket.
            Validador validador = new Validador();
            validador.validarTicket(contenido);

            // Creamos un ticket con los datos proporcionados.
            TicketDTO ticket = new TicketDTO(
                    contenido,
                    new Date(),
                    "Pendiente",
                    idUsuario,
                    emisor,
                    new ArrayList<>());

            // Enviamos el ticket.
            facadeAdministrarTickets.enviarTicket(ticket);

            // Redireccionamos a la pantalla de los tickets.
            FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
            frmAtnAlCliente.setVisible(true);
            this.dispose();

            // Mensajito de que se envió el ticket exitosamente.
            JOptionPane.showMessageDialog(this, "¡Ticket enviado!", "¡Yippee!", JOptionPane.INFORMATION_MESSAGE);
        } catch (PresentacionException pe) {
            // Mensaje de error.
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
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

        lblMapa = new javax.swing.JLabel();
        lblAtnAlCliente = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTicket = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        lblCerrarSesion = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1120, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMapa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMapa.setForeground(new java.awt.Color(0, 0, 0));
        lblMapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMapa.setText("Mapa");
        lblMapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMapaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMapaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMapaMouseExited(evt);
            }
        });
        getContentPane().add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 90, 80));

        lblAtnAlCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtnAlCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblAtnAlCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtnAlCliente.setText("Atención al cliente");
        lblAtnAlCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtnAlCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseExited(evt);
            }
        });
        getContentPane().add(lblAtnAlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 210, 80));

        lblQuejas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQuejas.setForeground(new java.awt.Color(0, 0, 0));
        lblQuejas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuejas.setText("Quejas");
        lblQuejas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuejas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuejasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuejasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuejasMouseExited(evt);
            }
        });
        getContentPane().add(lblQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 90, 80));

        areaTicket.setColumns(20);
        areaTicket.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        areaTicket.setForeground(new java.awt.Color(0, 0, 0));
        areaTicket.setLineWrap(true);
        areaTicket.setRows(5);
        areaTicket.setWrapStyleWord(true);
        jScrollPane2.setViewportView(areaTicket);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 940, 420));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 140, 50));

        btnEnviar.setBackground(new java.awt.Color(79, 89, 144));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEnviar.setFocusable(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 130, 50));

        lblCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblCerrarSesion.setText("       Cerrar sesión");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseExited(evt);
            }
        });
        getContentPane().add(lblCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 200, 90));

        lblHome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 100));

        fondo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fondo.setForeground(new java.awt.Color(0, 0, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticketNuevo.png"))); // NOI18N
        fondo.setText("jLabel3");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que reacciona al evento de dar clic en el botón para cerrar
     * sesión. Devuelve al usuario al login.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * cerrar sesión y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de cerrar sesión y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    /**
     * Método que reacciona al evento de dar clic en el botón para ir a la
     * pantalla principal.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        try {
            FrmHomeCliente frmHome = new FrmHomeCliente(usuario);
            frmHome.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    /**
     * Método que reacciona al evento de dar clic en el botón de enviar.
     *
     * @param evt Evento al que se escucha.
     */
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        enviarTicket();
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * Método que reacciona al evento de dar clic en el botón de cancelar.
     *
     * @param evt Evento al que se escucha.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método que reacciona al evento de dar clic en el botón para abrir el
     * mapa.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseClicked
        try {
            FrmMapa frmMapa = new FrmMapa(usuario);
            frmMapa.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblMapaMouseClicked

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón del
     * mapa y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblMapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseEntered
        lblMapa.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblMapaMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * del mapa y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblMapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseExited
        lblMapa.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMapaMouseExited

    /**
     * Método que reacciona al evento de dar clic en el botón para mandar
     * quejas.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblQuejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseClicked
        try {
            FrmQuejas frmQuejas = new FrmQuejas(usuario);
            frmQuejas.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblQuejasMouseClicked

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * quejas y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblQuejasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseEntered
        lblQuejas.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblQuejasMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de quejas y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblQuejasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseExited
        lblQuejas.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblQuejasMouseExited

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * atención al cliente y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblAtnAlClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseEntered
        lblAtnAlCliente.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblAtnAlClienteMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de atención al cliente y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblAtnAlClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseExited
        lblAtnAlCliente.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAtnAlClienteMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTicket;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblQuejas;
    // End of variables declaration//GEN-END:variables

}
