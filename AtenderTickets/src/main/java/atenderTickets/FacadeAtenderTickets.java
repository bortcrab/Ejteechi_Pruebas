/*
 * FacadeAtenderTickets.java
 */
package atenderTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase fachada que implementa los métodos de la interfaz IAtenderTickets para
 * facilitar el uso del subsistema al usuario.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeAtenderTickets implements IAtenderTickets {

    private final CtrlAtenderTickets ctrlAtenderTickets;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeAtenderTickets() {
        ctrlAtenderTickets = new CtrlAtenderTickets();
    }

    /**
     * Método para obtener todos los tickets que el trabajador esté atendiendo o
     * que no estén siendo atendidos por nadie.
     *
     * @param idAtendiendo ID del trabajador.
     * @return Lista de tickets encontrados.
     */
    @Override
    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo) {
        return ctrlAtenderTickets.obtenerTodosTickets(idAtendiendo);
    }

    /**
     * Método para enviar una respuesta de trabajador a un ticket.
     *
     * @param folio Folio del ticket al que se asociará la respuesta.
     * @param respuesta Respuesta a enviar.
     * @param idAtendiendo ID del trabajador que atenderá el ticket.
     * @return El ticket actualizado.
     */
    @Override
    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuesta, ObjectId idAtendiendo) {
        return ctrlAtenderTickets.enviarRespuestaTrabajador(folio, respuesta, idAtendiendo);
    }

    /**
     * Método que actualiza el estado de un ticket.
     *
     * @param ticket Ticket a actualizar.
     */
    @Override
    public void cambiarEstado(TicketDTO ticket) {
        ctrlAtenderTickets.cambiarEstado(ticket);
    }

}
