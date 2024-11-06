/*
 * TicketBO.java
 */
package implementaciones;

import colecciones.Respuesta;
import colecciones.Ticket;
import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import interfaces.ITicketBO;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que implementa los métodos de la interfaz ITicketBO para aplicar reglas
 * de negocio relacionadas con los tickets.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class TicketBO implements ITicketBO {

    private final ITicketDAO ticketDAO;

    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public TicketBO() {
        this.ticketDAO = new TicketDAO();
    }

    /**
     * Método para agregar un ticket.
     *
     * @param ticketDTO Ticket que se agregará.
     */
    @Override
    public void agregarTicket(TicketDTO ticketDTO) {
        // Convertirmos el ticket a entidad.
        Ticket ticketEnt = convertirTicket(ticketDTO);
        // Le asignamos el id del usuario.
        ticketEnt.setIdUsuario(ticketDTO.getIdUsuario());
        // Lo mandamos a agregar.
        ticketDAO.agregarTicket(ticketEnt);
    }

    /**
     * Método para obtener todos los tickets asociados a un cliente.
     *
     * @param usuario Cliente al cual están asociados los tickets.
     * @return Lista de tickets encontrados.
     */
    @Override
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        // Obtenemos la lista de tickets asociadas al cliente.
        List<Ticket> listaTicketsEnt = ticketDAO.obtenerTickets(usuario.getId());

        List<TicketDTO> listaTicketsDTO = new ArrayList<>();
        for (Ticket ticket : listaTicketsEnt) {
            // Guardamos cada ticket en una lista de DTOs.
            listaTicketsDTO.add(convertirTicket(ticket));
        }

        // Retornamos la lista.
        return listaTicketsDTO;
    }

    /**
     * Método para obtener un ticket con base al folio.
     *
     * @param folio Folio del ticket que se quiere obtener.
     * @return El ticket encontrado.
     */
    @Override
    public TicketDTO obtenerTicket(ObjectId folio) {
        // Obtenemos el ticket dado el folio.
        Ticket ticketEnt = ticketDAO.obtenerTicket(folio);

        // Lo convertimos a DTO.
        TicketDTO ticketDTO = convertirTicket(ticketEnt);

        // Lo retornamos.
        return ticketDTO;
    }

    /**
     * Método para enviar una respuesta de cliente a un ticket.
     *
     * @param folio Folio del ticket al que se asociará la respuesta.
     * @param respuestaDTO Respuesta a enviar.
     * @return El ticket actualizado.
     */
    @Override
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuestaDTO) {
        // Convertimos la respuesta a entidad.
        Respuesta respuestaEnt = convertirRespuesta(respuestaDTO);

        // Mandamos a agregar la respuesta.
        ticketDAO.agregarRespuesta(folio, respuestaEnt);

        // Retornamos el ticket actualizado.
        return this.obtenerTicket(folio);
    }

    /**
     * Método para enviar una respuesta de trabajador a un ticket.
     *
     * @param folio Folio del ticket al que se asociará la respuesta.
     * @param respuestaDTO Respuesta a enviar.
     * @param idAtendiendo ID del trabajador que atenderá el ticket.
     * @return El ticket actualizado.
     */
    @Override
    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuestaDTO, ObjectId idAtendiendo) {
        // Convertimos la respuesta a entidad y la agregamos.
        Respuesta respuestaEnt = convertirRespuesta(respuestaDTO);
        ticketDAO.agregarRespuesta(folio, respuestaEnt);

        // Obtenemos el ticket actualizado.
        Ticket ticketEnt = ticketDAO.obtenerTicket(folio);

        // Si no hay nadie atendiéndolo, se asignamos el idAtendiendo del parámetro.
        if (ticketEnt.getIdAtendiendo() == null) {
            ticketEnt.setIdAtendiendo(idAtendiendo);
            // Mandamos a actualizar el ticket.
            ticketDAO.actualizarTicket(ticketEnt);
        }

        // Retornamos el ticket actualizado.
        return this.obtenerTicket(folio);
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
        // Obtenemos todos los tickets asociados al trabajador y aquellos sin alguien atendiéndolos.
        List<Ticket> listaTicketsEnt = ticketDAO.obtenerTodosTickets(idAtendiendo);

        List<TicketDTO> listaTicketsDTO = new ArrayList<>();
        for (Ticket ticket : listaTicketsEnt) {
            // Convertimos cada ticket a DTO.
            listaTicketsDTO.add(convertirTicket(ticket));
        }

        // Retornamos la lista de tickets.
        return listaTicketsDTO;
    }

    /**
     * Método para actualizar un ticket.
     *
     * @param ticketDTO Ticket a actualizar.
     */
    @Override
    public void actualizarTicket(TicketDTO ticketDTO) {
        // Convertimos el ticket a entidad.
        Ticket ticketEnt = convertirTicket(ticketDTO);

        // Le asignamos el id del usuario.
        ticketEnt.setIdUsuario(ticketDTO.getIdUsuario());

        // Mandamos a actualizar el ticket.
        ticketDAO.actualizarTicket(ticketEnt);
    }

    /**
     * Método para convertir de TicketDTO a Ticket.
     *
     * @param ticketDTO TicketDTO a convertir.
     * @return El ticket convertido a entidad.
     */
    private Ticket convertirTicket(TicketDTO ticketDTO) {
        Ticket ticketEnt = new Ticket(
                ticketDTO.getContenido(),
                ticketDTO.getFecha(),
                ticketDTO.getEstado(),
                ticketDTO.getIdUsuario(),
                ticketDTO.getNombreUsuario(),
                ticketDTO.getIdAtendiendo(),
                convertirRespuestasDTO(ticketDTO.getRespuestas()));
        ticketEnt.setId(ticketDTO.getId());

        return ticketEnt;
    }

    /**
     * Método para convertir de Ticket a TicketDTO.
     *
     * @param ticketEnt Ticket entidad a convertir.
     * @return El ticket convertido a DTO.
     */
    private TicketDTO convertirTicket(Ticket ticketEnt) {
        TicketDTO ticketDTO = new TicketDTO(
                ticketEnt.getId(),
                ticketEnt.getContenido(),
                ticketEnt.getFecha(),
                ticketEnt.getEstado(),
                ticketEnt.getIdUsuario(),
                ticketEnt.getNombreUsuario(),
                ticketEnt.getIdAtendiendo(),
                convertirRespuestasEntidad(ticketEnt.getRespuestas()));

        return ticketDTO;
    }

    /**
     * Método para convertir de RespuestaDTO a Respuesta.
     *
     * @param respuestaDTO RespuestaDTO a convertir.
     * @return La respuesta convertida a entidad.
     */
    private Respuesta convertirRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuestaEnt = new Respuesta(
                respuestaDTO.getContenido(),
                respuestaDTO.getFecha(),
                respuestaDTO.getEmisor(),
                respuestaDTO.getIdEmisor());

        return respuestaEnt;
    }

    /**
     * Método para convertir de Respuesta a RespuestaDTO.
     *
     * @param respuestaEnt Respuesta entidad a convertir.
     * @return La respuesta convertida a DTO:
     */
    private RespuestaDTO convertirRespuesta(Respuesta respuestaEnt) {
        RespuestaDTO respuestaDTO = new RespuestaDTO(
                respuestaEnt.getContenido(),
                respuestaEnt.getFecha(),
                respuestaEnt.getEmisor(),
                respuestaEnt.getIdEmisor());

        return respuestaDTO;
    }

    /**
     * Método para convertir una lista de RespuestaDTO a una lista de Respuesta.
     *
     * @param listaRespuestasDTO Lista de RespuestaDTO a convertir.
     * @return Lista de respuestas ya convertidas a entidad.
     */
    private List<Respuesta> convertirRespuestasDTO(List<RespuestaDTO> listaRespuestasDTO) {
        List<Respuesta> listaRespuestasEnt = new ArrayList<>();
        for (RespuestaDTO respuestaDTO : listaRespuestasDTO) {
            listaRespuestasEnt.add(convertirRespuesta(respuestaDTO));
        }
        return listaRespuestasEnt;
    }

    /**
     * Método para convertir una lista de Respuesta a una lista de RespuestaDTO.
     *
     * @param listaRespuestasEnt Lista de Respuesta entidad a convertir.
     * @return Lista de respuestas ya convertidas a DTO.
     */
    private List<RespuestaDTO> convertirRespuestasEntidad(List<Respuesta> listaRespuestasEnt) {
        List<RespuestaDTO> listaRespuestasDTO = new ArrayList<>();
        for (Respuesta respuestaEnt : listaRespuestasEnt) {
            listaRespuestasDTO.add(convertirRespuesta(respuestaEnt));
        }
        return listaRespuestasDTO;
    }

}
