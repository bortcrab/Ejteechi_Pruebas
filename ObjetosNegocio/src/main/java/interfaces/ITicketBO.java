/*
 * ITicketBO.java
 */
package interfaces;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos para aplicar las reglas de negocio en lo
 * relacionado a los tickets.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface ITicketBO {

    /**
     * Método para agregar un ticket.
     *
     * @param ticketDTO Ticket que se agregará.
     */
    public void agregarTicket(TicketDTO ticketDTO);

    /**
     * Método para obtener todos los tickets asociados a un cliente.
     *
     * @param usuario Cliente al cual están asociados los tickets.
     * @return Lista de tickets encontrados.
     */
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);

    /**
     * Método para obtener un ticket con base al folio.
     *
     * @param folio Folio del ticket que se quiere obtener.
     * @return El ticket encontrado.
     */
    public TicketDTO obtenerTicket(ObjectId folio);

    /**
     * Método para enviar una respuesta de cliente a un ticket.
     *
     * @param folio Folio del ticket al que se asociará la respuesta.
     * @param respuestaDTO Respuesta a enviar.
     * @return El ticket actualizado.
     */
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuestaDTO);

    /**
     * Método para enviar una respuesta de trabajador a un ticket.
     *
     * @param folio Folio del ticket al que se asociará la respuesta.
     * @param respuestaDTO Respuesta a enviar.
     * @param idAtendiendo ID del trabajador que atenderá el ticket.
     * @return El ticket actualizado.
     */
    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuestaDTO, ObjectId idAtendiendo);

    /**
     * Método para obtener todos los tickets que el trabajador esté atendiendo o
     * que no estén siendo atendidos por nadie.
     *
     * @param idAtendiendo ID del trabajador.
     * @return Lista de tickets encontrados.
     */
    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo);

    /**
     * Método para actualizar un ticket.
     *
     * @param ticketDTO Ticket a actualizar.
     */
    public void actualizarTicket(TicketDTO ticketDTO);
}
