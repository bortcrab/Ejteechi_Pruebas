/*
 * FrmAtnVistaCliente.java
 */
package pantallas;

import administrarTickets.FacadeAdministrarTickets;
import administrarTickets.IAdministrarTickets;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.awt.Color;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilidades.JButtonCellEditor;
import utilidades.JButtonRenderer;
import utilidades.Validador;

/**
 * Clase que representa la pantalla donde aparecen los tickets del cliente.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FrmAtnVistaCliente extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final UsuarioDTO usuario;
    private List<TicketDTO> listaTickets;

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param usuario Usuario que está logueado en el sistema.
     * @throws PresentacionException si ocurre un error a la hora de validar la
     * sesión.
     */
    public FrmAtnVistaCliente(UsuarioDTO usuario) throws PresentacionException {
        initComponents();

        this.facadeAdministrarTickets = new FacadeAdministrarTickets();
        this.usuario = usuario;

        // Mandamos a validar la sesión.
        Validador.validarSesion(usuario, this);

        // Mandamos a formatear la tabla y a cargar los datos.
        formatearTabla();
        cargarTickets();
    }

    /**
     * Método para cargar los datos de los tickets.
     */
    private void cargarTickets() {
        // Obtenemos la lista de tickets.
        listaTickets = facadeAdministrarTickets.obtenerTickets(usuario);
        // Mandamos a llenar la tabla de tickets.
        llenarTabla(listaTickets);
    }

    /**
     * Método para llenar la tabla de tickets.
     *
     * @param listaTickets Lista de tickets con la que se llenará la tabla.
     */
    private void llenarTabla(List<TicketDTO> listaTickets) {
        // Obtenemos el modelo de la tabla.
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTickets.getModel();

        // Con esto removemos cualquier fila que haya en la tabla por defecto.
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        // Iteramos sobre la lista tickets.
        for (TicketDTO ticket : listaTickets) {
            // Creamos una arreglo con cuatro espacios.
            Object[] fila = new Object[4];
            // Metemos cada dato del ticket en la posición del arreglo donde debe ir.
            fila[0] = ticket.getId().toString();
            fila[1] = ticket.getContenido();
            // Para formatear las fechas.
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
            String fecha = formatter.format(ticket.getFecha().getTime());
            fila[2] = fecha;
            fila[3] = ticket.getEstado();

            // Añadimos la fila al modelo.
            modeloTabla.addRow(fila);
        }
    }

    /**
     * Método para darle formato a la tabla.
     */
    private void formatearTabla() {
        // Cambiamos el color del fondo.
        tblTickets.getTableHeader().setBackground(new Color(79, 89, 144));
        // Cambiamos la fuente y el tamaño.
        tblTickets.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 24));
        // Cambiamos el color de la letra.
        tblTickets.getTableHeader().setForeground(new Color(255, 255, 255));

        // Creamos el evento de cuando le pican al botón para seleccionar un ticket.
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para seleccionar un ticket.
                seleccionarTicket();
            }
        };
        int indiceColumnaSeleccionar = 4;
        TableColumnModel modeloColumnas = this.tblTickets.getColumnModel();
        // Añadimos un botón a una columna.
        modeloColumnas.getColumn(indiceColumnaSeleccionar).setCellRenderer(new JButtonRenderer("Seleccionar"));
        modeloColumnas.getColumn(indiceColumnaSeleccionar).setCellEditor(new JButtonCellEditor("Seleccionar", onEditarClickListener));
    }

    /**
     * Método para seleccionar un ticket.
     */
    private void seleccionarTicket() {
        try {
            // Obtenemos el ticket seleccionado.
            TicketDTO ticket = listaTickets.get(this.tblTickets.getSelectedRow());
            // Redireccionamos a la pantalla del chat.
            FrmChatVistaCliente frmChatTicket = new FrmChatVistaCliente(usuario, facadeAdministrarTickets, ticket);
            frmChatTicket.setVisible(true);
        } catch (PresentacionException pe) {
            // Si no se valida la sesión.
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        // Destruimos este frame.
        this.dispose();
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
        tblTickets = new javax.swing.JTable();
        lblMapa = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        lblAtnAlCliente = new javax.swing.JLabel();
        btnNuevoTicket = new javax.swing.JButton();
        lblCerrarSesion = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1120, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 80));

        tblTickets.setAutoCreateRowSorter(true);
        tblTickets.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Folio", "Contenido", "Fecha", "Estado", "Acción"
            }
        ));
        tblTickets.setGridColor(new java.awt.Color(79, 89, 144));
        tblTickets.setMaximumSize(new java.awt.Dimension(2147483647, 420));
        tblTickets.setShowGrid(true);
        tblTickets.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTickets);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 720, 420));

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

        btnNuevoTicket.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btnNuevoTicket.setBorder(null);
        btnNuevoTicket.setContentAreaFilled(false);
        btnNuevoTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTicketActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, 200, 230));

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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoTickets.png"))); // NOI18N
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
     * Método que reacciona al evento de dar clic en el botón de nuevo ticket.
     *
     * @param evt Evento al que se escucha.
     */
    private void btnNuevoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTicketActionPerformed
        try {
            FrmTicketNuevo frmTicketNuevo = new FrmTicketNuevo(usuario, facadeAdministrarTickets);
            frmTicketNuevo.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnNuevoTicketActionPerformed

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
    private javax.swing.JButton btnNuevoTicket;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JTable tblTickets;
    // End of variables declaration//GEN-END:variables

}
