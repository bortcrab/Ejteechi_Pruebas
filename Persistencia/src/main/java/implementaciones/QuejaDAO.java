package implementaciones;

import colecciones.Queja;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.PersistenciaException;
import interfaces.IQuejaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

public class QuejaDAO implements IQuejaDAO {

    private final IConexion conexion;
    private MongoCollection<Queja> coleccion;
    private static final Logger logger = Logger.getLogger(MapaDAO.class.getName());
    private MongoDatabase db;

    public QuejaDAO() {
        this.conexion = new Conexion();
        db = conexion.crearConexion();
        coleccion = db.getCollection("quejas", Queja.class);
    }

    @Override
    public void insertarQueja(Queja queja) throws PersistenciaException {
        if (queja.isAnonimo()) {
            queja.setIdCliente(null);
        }
        coleccion.insertOne(queja);
        logger.log(Level.INFO, "Se ha insertado la queja en la colección 'quejas'.");
        conexion.cerrarConexion();
    }

    @Override
    public List<Queja> obtenerQuejasPorTipo(String tipo) throws PersistenciaException {
        List<Queja> quejasPorTipo = new ArrayList<>();
        try {
            for (Queja queja : coleccion.find(eq("tipo", tipo))) {
                quejasPorTipo.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener quejas por tipo", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return quejasPorTipo;
    }

    @Override
    public List<Queja> obtenerTodasLasQuejas() throws PersistenciaException {
        List<Queja> todasLasQuejas = new ArrayList<>();
        try {
            for (Queja queja : coleccion.find()) {
                todasLasQuejas.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener todas las quejas", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return todasLasQuejas;
    }

    @Override
    public List<Queja> obtenerQuejasPorEstadoYAnonimato(boolean leido) throws PersistenciaException {
        List<Queja> quejasFiltradas = new ArrayList<>();
        try {
            Bson filtroLeido;
            if (leido) {
                filtroLeido = eq("leido", true);
            } else {
                filtroLeido = or(eq("leido", false), exists("leido", false)); // No leído o atributo "leido" no existe
            }

            for (Queja queja : coleccion.find(filtroLeido)) {
                quejasFiltradas.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener quejas ", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return quejasFiltradas;
    }

    @Override
    public Queja confirmarLectura(Queja queja) throws PersistenciaException {
        try {
            queja.setLeido(true);

            UpdateResult result = coleccion.updateOne(eq("_id", queja.getId()), set("leido", true));

            if (result.getModifiedCount() != 1) {
                logger.log(Level.WARNING, "No se pudo actualizar la queja en la base de datos");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al confirmar la lectura de la queja", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return queja;
    }

}
