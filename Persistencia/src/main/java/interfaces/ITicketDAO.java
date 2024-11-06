package interfaces;

import colecciones.Respuesta;
import colecciones.Ticket;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos para acceder y manipular datos relacionados
 * con los tickets en la base de datos.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface ITicketDAO {

    /**
     * Método para agregar un ticket a la base de datos.
     *
     * @param ticket
     */
    public void agregarTicket(Ticket ticket);

    /**
     * Método para obtener los tickets asociados a un cliente.
     *
     * @param idUsuario ID del cliente.
     * @return La lista de tickets encontrada.
     */
    public List<Ticket> obtenerTickets(ObjectId idUsuario);

    /**
     * Método para obtener un ticket dado un folio.
     *
     * @param folio Folio del ticket a buscar.
     * @return El ticket encontrado.
     */
    public Ticket obtenerTicket(ObjectId folio);

    /**
     * Método para agregar una respuesta a un ticket.
     *
     * @param folio Folio del ticket al que se le agregará la respuesta.
     * @param respuesta Respuesta a agregar.
     */
    public void agregarRespuesta(ObjectId folio, Respuesta respuesta);

    /**
     * Método para obtener todos los tickets atendidos por un trabajador en
     * específico o que no están siendo atendidos por nadie.
     *
     * @param idAtendiendo ID del trabajador que está atendiendo.
     * @return La lista de tickets encontrada.
     */
    public List<Ticket> obtenerTodosTickets(ObjectId idAtendiendo);

    /**
     * Método para actualizar un ticket.
     *
     * @param ticket Ticket a actualizar.
     */
    public void actualizarTicket(Ticket ticket);

}
