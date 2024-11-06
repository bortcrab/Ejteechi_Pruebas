/*
 * CtrlAdministrarTickets
 */
package administrarTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import implementaciones.TicketBO;
import interfaces.ITicketBO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase control para administrar tickets por parte del cliente.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlAdministrarTickets {

    private final ITicketBO ticketBO;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public CtrlAdministrarTickets() {
        this.ticketBO = new TicketBO();
    }

    /**
     * Método para enviar un ticket.
     *
     * @param ticket Ticket a enviar.
     */
    public void enviarTicket(TicketDTO ticket) {
        ticketBO.agregarTicket(ticket);
    }

    /**
     * Método para obtener los tickets de un cliente.
     *
     * @param usuario Cliente del cual se quieren obtener los tickets.
     * @return La lista de tickets obtenidos.
     */
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ticketBO.obtenerTickets(usuario);
    }

    /**
     * Método para enviar una respuesta.
     *
     * @param folio Folio del ticket al cual se le asociará la respuesta.
     * @param respuesta Respuesta a enviar.
     * @return El ticket actualizado.
     */
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta) {
        return ticketBO.enviarRespuesta(folio, respuesta);
    }
}
