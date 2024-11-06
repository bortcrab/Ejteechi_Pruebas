/*
 * CtrlObtenerTickets.java
 */
package atenderTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import implementaciones.TicketBO;
import interfaces.ITicketBO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase control para atender tickets por parte del trabajador.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlAtenderTickets {

    private final ITicketBO ticketBO;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public CtrlAtenderTickets() {
        this.ticketBO = new TicketBO();
    }

    /**
     * Método para obtener todos los tickets que el trabajador esté atendiendo o
     * que no estén siendo atendidos por nadie.
     *
     * @param idAtendiendo ID del trabajador.
     * @return Lista de tickets encontrados.
     */
    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo) {
        return ticketBO.obtenerTodosTickets(idAtendiendo);
    }

    /**
     * Método para enviar una respuesta de trabajador a un ticket.
     *
     * @param folio Folio del ticket al que se asociará la respuesta.
     * @param respuesta Respuesta a enviar.
     * @param idAtendiendo ID del trabajador que atenderá el ticket.
     * @return El ticket actualizado.
     */
    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuesta, ObjectId idAtendiendo)  {
        return ticketBO.enviarRespuestaTrabajador(folio, respuesta, idAtendiendo);
    }

    /**
     * Método que actualiza el estado de un ticket.
     *
     * @param ticket Ticket a actualizar.
     */
    public void cambiarEstado(TicketDTO ticket) {
        ticketBO.actualizarTicket(ticket);
    }
}
