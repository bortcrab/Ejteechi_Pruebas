/*
 * TicketDAO.java
 */
package implementaciones;

import colecciones.Respuesta;
import colecciones.Ticket;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.or;
import com.mongodb.client.model.Updates;
import conexion.Conexion;
import conexion.IConexion;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase que implementa los métodos de la interfaz ITicketDAO para realizar
 * operaciones relacionadas con la entidad Ticket en la base de datos.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class TicketDAO implements ITicketDAO {

    private final IConexion conexion;
    private MongoCollection<Ticket> coleccion;
    private static final Logger logger = Logger.getLogger(TicketDAO.class.getName());

    /**
     * Constructor que inicializa el atributo de conexión de la clase.
     */
    public TicketDAO() {
        conexion = new Conexion();
    }

    /**
     * Método para agregar un ticket a la base de datos.
     *
     * @param ticket
     */
    @Override
    public void agregarTicket(Ticket ticket) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        // Mandamos a insertar el ticket.
        coleccion.insertOne(ticket);

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
    }

    /**
     * Método para obtener los tickets asociados a un cliente.
     *
     * @param idUsuario ID del cliente.
     * @return La lista de tickets encontrada.
     */
    @Override
    public List<Ticket> obtenerTickets(ObjectId idUsuario) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo correo sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("idUsuario", idUsuario);

        List<Ticket> listaTickets = new ArrayList<>();

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese correo. Lo
         * que obtengamos lo guardamos en una variable.
         */
        coleccion.find(filtro).into(listaTickets);

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        return listaTickets;
    }

    /**
     * Método para obtener un ticket dado un folio.
     *
     * @param folio Folio del ticket a buscar.
     * @return El ticket encontrado.
     */
    @Override
    public Ticket obtenerTicket(ObjectId folio) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo correo sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("_id", folio);

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese correo. Lo
         * que obtengamos lo guardamos en una variable.
         */
        Ticket ticket = coleccion.find(filtro).first();

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        return ticket;
    }

    /**
     * Método para agregar una respuesta a un ticket.
     *
     * @param folio Folio del ticket al que se le agregará la respuesta.
     * @param respuesta Respuesta a agregar.
     */
    @Override
    public void agregarRespuesta(ObjectId folio, Respuesta respuesta) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        Document filtro = new Document("_id", folio);

        // Mandamos a insertar el ticket.
        coleccion.updateOne(filtro, Updates.push("respuestas", respuesta));

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha actualizado un documento de la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
    }

    /**
     * Método para obtener todos los tickets atendidos por un trabajador en
     * específico o que no están siendo atendidos por nadie.
     *
     * @param idAtendiendo ID del trabajador que está atendiendo.
     * @return La lista de tickets encontrada.
     */
    @Override
    public List<Ticket> obtenerTodosTickets(ObjectId idAtendiendo) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        Bson filtro = or(
                eq("idAtendiendo", idAtendiendo),
                exists("idAtendiendo", false));

        List<Ticket> listaTickets = new ArrayList<>();

        coleccion.find(filtro).into(listaTickets);

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        return listaTickets;
    }

    /**
     * Método para actualizar un ticket.
     *
     * @param ticket Ticket a actualizar.
     */
    @Override
    public void actualizarTicket(Ticket ticket) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        Document filtro = new Document("_id", ticket.getId());

        // Mandamos a insertar el ticket.
        coleccion.replaceOne(filtro, ticket);

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
    }

}
