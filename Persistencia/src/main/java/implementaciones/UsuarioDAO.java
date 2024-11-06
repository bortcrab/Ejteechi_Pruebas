/*
 * UsuarioDAO.java
 */
package implementaciones;

import colecciones.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.Conexion;
import conexion.IConexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import interfaces.IUsuarioDAO;

/**
 * Clase que implementa los métodos de la interfaz IUsuarioDAO para realizar
 * operaciones relacionadas con la entidad Usuario en la base de datos.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final IConexion conexion;
    private MongoCollection<Usuario> coleccion;
    private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());

    /**
     * Constructor que inicializa el atributo de conexión de la clase.
     */
    public UsuarioDAO() {
        conexion = new Conexion();
    }

    /**
     * Método para agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar.
     * @return El usuario con su ID de la base de datos.
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        // Mandamos a insertar el usuario.
        coleccion.insertOne(usuario);
        
        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
        
        usuario = obtenerUsuarioCorreo(usuario.getCorreo());
        
        return usuario;
    }

    /**
     * Método para obtener un usuario de la base de datos dado su correo.
     *
     * @param correo Correo del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    @Override
    public Usuario obtenerUsuarioCorreo(String correo) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo correo sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("correo", correo);

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese correo. Lo
         * que obtengamos lo guardamos en una variable.
         */
        Usuario usuario = coleccion.find(filtro).first();
        // Mensajito indicando lo que se hizo.
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        // Retornamos el usuario encontrado.
        return usuario;
    }
    
    /**
     * Método para obtener un usuario de la base de datos dada su CURP.
     *
     * @param curp CURP del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    @Override
    public Usuario obtenerUsuarioCurp(String curp) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuya CURP sea la
         * misma que la proporcionada.
         */
        Document filtro = new Document("curp", curp);

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con esa CURP. Lo
         * que obtengamos lo guardamos en una variable.
         */
        Usuario usuario = coleccion.find(filtro).first();
        // Mensajito indicando lo que se hizo.
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        // Retornamos el usuario encontrado.
        return usuario;
    }
    
    /**
     * Método para obtener un usuario de la base de datos dado su RFC.
     *
     * @param rfc RFC del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    @Override
    public Usuario obtenerUsuarioRfc(String rfc) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo RFC sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("rfc", rfc);

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese RFC. Lo
         * que obtengamos lo guardamos en una variable.
         */
        Usuario usuario = coleccion.find(filtro).first();
        // Mensajito indicando lo que se hizo.
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        // Retornamos el usuario encontrado.
        return usuario;
    }
    
    /**
     * Método para obtener un usuario de la base de datos dados su correo y
     * contraseña.
     *
     * @param correo Correo del usuario a buscar.
     * @param contrasenia Contraseña del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    @Override
    public Usuario obtenerUsuarioCorreoContra(String correo, String contrasenia) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyos correo y
         * contraseña sean los mismos que los proporcionado.
         */
        Document filtro = new Document("correo", correo).append("contrasenia", contrasenia);

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con el correo
         * proporcionado. Lo que obtengamos lo guardamos en una variable.
         */
        Usuario usuario = coleccion.find(filtro).first();
        // Mensajito indicando lo que se hizo.
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        // Retornamos el usuario encontrado.
        return usuario;
    }

}
