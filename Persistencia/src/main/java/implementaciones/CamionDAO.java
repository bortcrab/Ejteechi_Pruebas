package implementaciones;

import colecciones.Camion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import conexion.Conexion;
import conexion.IConexion;
import interfaces.ICamionDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

/**
 * Implementación de la interfaz ICamionDAO que proporciona métodos para acceder a datos relacionados con camiones.
 * Esta clase permite realizar operaciones como obtener un camión por su número de unidad, actualizar su estado,
 * prioridad o fecha de mantenimiento, entre otras.
 * 
 * @author elimo
 */
public class CamionDAO implements ICamionDAO {

    private final IConexion conexion;
    private MongoCollection<Camion> coleccion;
    private static final Logger logger = Logger.getLogger(CamionDAO.class.getName());

    /**
     * Constructor que inicializa el atributo de conexión de la clase.
     */
    public CamionDAO() {
        conexion = new Conexion();
    }

    /**
 * Obtiene un objeto de tipo Camion basado en el número de unidad proporcionado.
 *
 * @param numeroUnidad El número de unidad del camión que se desea obtener.
 * @return Un objeto de tipo Camion que corresponde al número de unidad especificado, o null si no se encuentra.
 */
    @Override
    public Camion obtenerPorNumeroUnidad(String numeroUnidad) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("camiones", Camion.class);

        Camion cam = coleccion.find(Filters.eq("numeroUnidad", numeroUnidad)).first();

        if (cam == null) {
            logger.log(Level.WARNING, "No se encontró ningún camión con el número de unidad especificado: " + numeroUnidad);
            return null;
        }

        return cam;
    }

    /**
 * Actualiza el estado de un camión identificado por su número de unidad.
 *
 * @param numeroUnidad El número de unidad del camión que se va a actualizar.
 * @param estadoMotor El nuevo estado del motor del camión.
 * @param estadoLimpieza El nuevo estado de limpieza del camión.
 * @param estadoLlantas El nuevo estado de las llantas del camión.
 * @param estadoLuces El nuevo estado de las luces del camión.
 * @return El camión actualizado.
 */
    @Override
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("camiones", Camion.class);

        List<Bson> updates = new ArrayList<>();
        updates.add(Updates.set("estadoMotor", estadoMotor));
        updates.add(Updates.set("estadoLimpieza", estadoLimpieza));
        updates.add(Updates.set("estadoLlantas", estadoLlantas));
        updates.add(Updates.set("estadoLuces", estadoLuces));

        coleccion.updateOne(Filters.eq("numeroUnidad", numeroUnidad), Updates.combine(updates));

        return obtenerPorNumeroUnidad(numeroUnidad);
    }

    /**
 * Actualiza la prioridad y la fecha de mantenimiento de un camión identificado por su número de unidad.
 *
 * @param numeroUnidad El número de unidad del camión que se va a actualizar.
 * @param nuevaPrioridad La nueva prioridad que se asignará al camión.
 * @param nuevaFechaMantenimiento La nueva fecha de mantenimiento que se asignará al camión.
 * @return El camión actualizado.
 */
    @Override
    public Camion actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("camiones", Camion.class);
        coleccion.updateOne(Filters.eq("numeroUnidad", numeroUnidad), Updates.combine(
                Updates.set("nivelPrioridad", nuevaPrioridad),
                Updates.set("fechaUltimoMantenimiento", nuevaFechaMantenimiento)
        ));
        return obtenerPorNumeroUnidad(numeroUnidad);
    }

}
