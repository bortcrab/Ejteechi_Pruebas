/*
 * IAdministrarTickets.java
 */
package administrarTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos que el subsistema puede realizar.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IAdministrarTickets {

    /**
     * Método para enviar un ticket.
     *
     * @param ticket Ticket a enviar.
     */
    public void enviarTicket(TicketDTO ticket);

    /**
     * Método para obtener los tickets de un cliente.
     *
     * @param usuario Cliente del cual se quieren obtener los tickets.
     * @return La lista de tickets obtenidos.
     */
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);

    /**
     * Método para enviar una respuesta.
     *
     * @param folio Folio del ticket al cual se le asociará la respuesta.
     * @param respuesta Respuesta a enviar.
     * @return El ticket actualizado.
     */
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta);
}
