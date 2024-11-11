/*
 * UsuarioDAO.java
 */
package implementaciones;

import colecciones.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.PersistenciaException;
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
    public Usuario agregarCliente(Usuario cliente) throws PersistenciaException {
        Usuario clienteExistente = obtenerUsuarioCorreo(cliente.getCorreo());

        // Checamos que no exista un cliente con ese correo.
        if (clienteExistente != null) {
            throw new PersistenciaException("Ya existe un usuario con ese correo.");
        }
        
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);
        
        
        // Mandamos a insertar el cliente.
        coleccion.insertOne(cliente);
        
        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
        
        // Actualizamos el cliente ahora sí con su ID.
        cliente = obtenerUsuarioCorreo(cliente.getCorreo());
        
        return cliente;
    }
    
    /**
     * Método para agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar.
     * @return El usuario con su ID de la base de datos.
     */
    @Override
    public Usuario agregarEmpleado(Usuario empleado) throws PersistenciaException {
        Usuario usuarioExistente = obtenerUsuarioCorreo(empleado.getCorreo());
        // Checamos que no exista un usuario con ese correo.
        if (usuarioExistente != null) {
            throw new PersistenciaException("Ya existe un usuario con ese correo.");
        }
        
        usuarioExistente = obtenerEmpleadoCurp(empleado.getCurp());
        // Checamos que no exista un empleado con ese correo.
        if (usuarioExistente != null) {
            throw new PersistenciaException("Ya existe un empleado con esa CURP.");
        }
        
        usuarioExistente = obtenerEmpleadoRfc(empleado.getRfc());
        // Checamos que no exista un cliente con ese correo.
        if (usuarioExistente != null) {
            throw new PersistenciaException("Ya existe un empleado con ese RFC.");
        }


        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        // Mandamos a insertar el usuario.
        coleccion.insertOne(empleado);
        
        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
        
        empleado = obtenerUsuarioCorreo(empleado.getCorreo());
        
        return empleado;
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
    public Usuario obtenerEmpleadoCurp(String curp) {
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
    public Usuario obtenerEmpleadoRfc(String rfc) {
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
    
    @Override
    public void borrarUsuarios() {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);
        
        Long eliminados = coleccion.deleteMany(new Document()).getDeletedCount();
        
        logger.log(Level.INFO, "Se han eliminado " + eliminados +" registros de la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
    }

}
