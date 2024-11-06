/*
 * FacadeAdministrarTickets.java
 */
package administrarTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase fachada que implementa los métodos de la interfaz IAdministrarTickets
 * para facilitar el uso del subsistema al usuario.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeAdministrarTickets implements IAdministrarTickets {

    private final CtrlAdministrarTickets ctrlContactarAtnAlCliente;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeAdministrarTickets() {
        ctrlContactarAtnAlCliente = new CtrlAdministrarTickets();
    }

    /**
     * Método para enviar un ticket.
     *
     * @param ticket Ticket a enviar.
     */
    @Override
    public void enviarTicket(TicketDTO ticket) {
        ctrlContactarAtnAlCliente.enviarTicket(ticket);
    }

    /**
     * Método para obtener los tickets de un cliente.
     *
     * @param usuario Cliente del cual se quieren obtener los tickets.
     * @return La lista de tickets obtenidos.
     */
    @Override
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ctrlContactarAtnAlCliente.obtenerTickets(usuario);
    }

    /**
     * Método para enviar una respuesta.
     *
     * @param folio Folio del ticket al cual se le asociará la respuesta.
     * @param respuesta Respuesta a enviar.
     * @return El ticket actualizado.
     */
    @Override
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta) {
        return ctrlContactarAtnAlCliente.enviarRespuesta(folio, respuesta);
    }

}
