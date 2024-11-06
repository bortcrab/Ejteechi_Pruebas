/*
 * FrmChatVistaCliente.java
 */
package pantallas;

import administrarTickets.IAdministrarTickets;
import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.awt.Color;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollBar;
import utilidades.Validador;

/**
 * Clase que representa la pantalla donde aparecen el chat del ticket
 * seleccionado.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FrmChatVistaCliente extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final UsuarioDTO usuario;
    private TicketDTO ticket;

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param usuario Usuario que está logueado en el sistema.
     * @param facadeAdministrarTickets Interfaz para administrar tickets.
     * @param ticket Ticket que fue seleccionado.
     * @throws PresentacionException si ocurre un error a la hora de validar la
     * sesión.
     */
    public FrmChatVistaCliente(UsuarioDTO usuario, IAdministrarTickets facadeAdministrarTickets, TicketDTO ticket) throws PresentacionException {
        initComponents();

        // Validamos la sesión.
        Validador.validarSesion(usuario, this);

        this.facadeAdministrarTickets = facadeAdministrarTickets;
        this.usuario = usuario;
        this.ticket = ticket;

        // Si el ticket ya está resuelto, deshabilitamos el botón de enviar y el campo de texto.
        if (ticket.getEstado().equals("Resuelto")) {
            txtMensaje.setEnabled(false);
            btnEnviar.setEnabled(false);
        }

        // Cargamos los datos del chat.
        cargarChat();
    }

    /**
     * Método para cargar el chat con los datos del ticket seleccionado.
     */
    private void cargarChat() {
        // Seteamos el texto del chat como nulo.
        jepChat.setText(null);

        // Obtenemos el mensaje inicial del ticket.
        String contenidoTicket = ticket.getContenido();
        // Para formatear las fechas.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
        // Obtenemos la fecha del ticket.
        String fechaTicket = formatter.format(ticket.getFecha().getTime());
        // Obtenemos las respuestas del ticket.
        List<RespuestaDTO> respuestas = ticket.getRespuestas();
        /**
         * Este string es lo que vamos a poner en el texto del chat. El chat es
         * un Java Text Editor, el cual acepta HTML. En nuestro caso, usamos
         * HTML para darle formato a las respuestas del chat.
         */
        String mensajesChat
                = """
                <html>
                    <style>
                        .cabecera-izquierda {
                            background-color: #4F5990;
                            color: white;
                            margin-right: 100px;
                            text-align: left;
                            padding: 5px;
                        }
                
                        .contenido-izquierda {
                            background-color: #C0C5D2;
                            color: black;
                            margin-right: 100px;
                            text-align: justified;
                            padding: 5px;
                        }
                
                        .cabecera-derecha {
                            background-color: #4F5990;
                            color: white;
                            margin-left: 100px;
                            text-align: right;
                            padding: 5px;
                        }

                        .contenido-derecha {
                            background-color: #C0C5D2;
                            color: black;
                            margin-left: 100px;
                            text-align: justified;
                            padding: 5px;
                        }
                    </style>
                    <body>
                        <div class="cabecera-izquierda">
                            <b>Yo <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-izquierda">
                            %s
                        </div>
                        <br>
                """
                        .formatted(fechaTicket, contenidoTicket);
        // En ese string, a lo último, ponemos los datos del ticket como si fuera una respuesta.

        // Luego iteramos sobre las respuestas.
        for (RespuestaDTO respuesta : respuestas) {
            // Obtenemos la fecha y el contenido de la respuesta.
            String fechaRespuesta = formatter.format(respuesta.getFecha().getTime());
            String contenidoRespuesta = respuesta.getContenido();

            // Si el emisor de la respuesta es el cliente.
            if (respuesta.getIdEmisor().equals(usuario.getId())) {
                // Ponemos su respuesta a la izquierda.
                mensajesChat
                        += """
                        <div class="cabecera-izquierda">
                            <b>Yo <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-izquierda">
                            %s
                        </div>
                        <br>
                        """
                                .formatted(fechaRespuesta, contenidoRespuesta);
            } else { // Si es el trabajador.
                // Lo ponemos a la derecha.
                String emisor = respuesta.getEmisor();
                mensajesChat
                        += """
                        <div class="cabecera-derecha">
                            <b>%s <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-derecha">
                            %s
                        </div>
                        <br>
                        """
                                .formatted(emisor, fechaRespuesta, contenidoRespuesta);
            }
        }
        
        // Con esto borramos el salto de línea del último mensaje.
        mensajesChat = mensajesChat.substring(0, mensajesChat.length() - 4);
        // Y con esto cerramos el HTML.
        mensajesChat += """
                    </body>
                </html>
                """;
        // Ponemos todo el texto en el chat.
        jepChat.setText(mensajesChat);
    }

    /**
     * Método para enviar una respuesta.
     */
    private void enviarRespuesta() {
        try {
            // Obtenemos el mensaje de la respuesta.
            String mensaje = txtMensaje.getText();

            // Mandamos a validar el mensaje de la respuesta.
            Validador validador = new Validador();
            validador.validarRespuesta(mensaje);

            // Creamos una respuesta con los datos necesarios.
            RespuestaDTO respuesta = new RespuestaDTO(
                    mensaje,
                    new Date(),
                    usuario.getNombres() + " " + usuario.getApellidoPaterno(),
                    usuario.getId());

            // Enviamos la respuesta y la obtenemos actualizada.
            ticket = facadeAdministrarTickets.enviarRespuesta(ticket.getId(), respuesta);

            // Limpiamos el campo de texto del mensaje.
            txtMensaje.setText("");

            // Actualizamos el chat.
            this.cargarChat();

            // Hacemos que la barrita del scroll se haga para abajo lo más que se pueda.
            JScrollBar scrollBar = jScrollPane1.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getMaximum());
        } catch (PresentacionException pe) {
            // Mensajito de error.
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jepChat = new javax.swing.JEditorPane("text/html", "");
        jPanel1 = new javax.swing.JPanel();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblCerrarSesion = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();
        lblAtnAlCliente = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1120, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jepChat.setEditable(false);
        jepChat.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jScrollPane1.setViewportView(jepChat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 940, 340));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 940, 40));

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
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, 120, 40));

        btnVolver.setBackground(new java.awt.Color(255, 102, 102));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver.setFocusable(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 110, 40));

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
        getContentPane().add(lblCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 200, 100));

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

        lblHome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 100));

        fondo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fondo.setForeground(new java.awt.Color(0, 0, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticketChat.png"))); // NOI18N
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
        enviarRespuesta();
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * Método que reacciona al evento de dar clic en el botón de volver.
     *
     * @param evt Evento al que se escucha.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            if (usuario.getTipo().equals("cliente")) {
                FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
                frmAtnAlCliente.setVisible(true);
            } else {
                FrmAtnVistaTrabajador frmAtnAlCliente = new FrmAtnVistaTrabajador(usuario);
                frmAtnAlCliente.setVisible(true);
            }
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Método para que cuando se presione enter se mande el mensaje.
     *
     * @param evt Evento al que se escucha.
     */
    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        enviarRespuesta();
    }//GEN-LAST:event_txtMensajeActionPerformed

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
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane jepChat;
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables

}
