/*
 * MapaDAO.java
 */
package implementaciones;

import conexion.Conexion;
import colecciones.Mapa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.IConexion;
import interfaces.IMapaDAO;
import excepciones.PersistenciaException;

/**
 * Clase que implementa los métodos de la interfaz IMapaDAO para realizar
 * operaciones relacionadas con la entidad Mapa en la base de datos.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class MapaDAO implements IMapaDAO {

    private final IConexion conexion;
    private MongoCollection<Mapa> coleccion;
    private static final Logger logger = Logger.getLogger(MapaDAO.class.getName());

    /**
     * Constructor que inicializa el atributo de conexión de la clase.
     */
    public MapaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Método para buscar en la base de datos el mapa a mostrar.
     *
     * @return El mapa si se encontró.
     * @throws PersistenciaException Si no se encontró ningún mapa.
     */
    @Override
    public Mapa obtenerMapa() throws PersistenciaException {
        // Creamos una conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de mapas.
        coleccion = db.getCollection("mapas", Mapa.class);

        // Buscamos el primer y único mapa que debe haber en la base de datos.
        Mapa mapa = coleccion.find().first();
        logger.log(Level.INFO, "Se ha consultado la colección 'mapas'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        // Si no se encontró ningún mapa, se lanza una excepción.
        if (mapa == null) {
            throw new PersistenciaException("No se encontró ningún mapa.");
        }

        // Retornamos el mapa encontrado.
        return mapa;
    }
}
