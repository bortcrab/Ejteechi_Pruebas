/*
 * Conexion.java
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Clase con la implementación de la interfaz IConexion para crear una conexión
 * con la base de datos de MongoDB.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Conexion implements IConexion {
    
//    private final ConnectionString cadenaConexion = new ConnectionString("mongodb://diegovalenzuela247700:wYZZNu9bnHOtHsQN@ac-rvttj18-shard-00-00.kjczdex.mongodb.net:27017,ac-rvttj18-shard-00-01.kjczdex.mongodb.net:27017,ac-rvttj18-shard-00-02.kjczdex.mongodb.net:27017/?ssl=true&replicaSet=atlas-xfbyw1-shard-0&authSource=admin&retryWrites=true&w=majority&appName=ejteechi");
    private final ConnectionString cadenaConexion = new ConnectionString("mongodb://localhost:27017");
    private final String nombreBaseDatos = "ejteechidb";
    private static final Logger logger = Logger.getLogger(Conexion.class.getName());
    private MongoClient servidor;
    
    /**
     * Método para crear una conexión con la base de datos.
     *
     * @return Un objeto del tipo MongoDatabase.
     */
    @Override
    public MongoDatabase crearConexion() {
        // Configura el proveedor de códecs para trabajar con objetos Java y MongoDB.
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        // Combina el proveedor de códecs POJO con el registro de códecs predeterminado de MongoDB.
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        // Configura los ajustes del cliente MongoDB, incluyendo la cadena de conexión y el registro de códecs.
        MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();

        // Crea un cliente MongoDB utilizando los ajustes configurados.
        servidor = MongoClients.create(clientsSettings);
        
        // Indicamos que la conexión fue exitosa.
        logger.log(Level.INFO, "Se ha establecido la conexión con el servidor.");
        
        // Retornamos la base de datos con el nombre especificado.
        return servidor.getDatabase(nombreBaseDatos);
    }
    
    /**
     * Método para cerrar una conexión con la base de datos.
     */
    @Override
    public void cerrarConexion() {
        // Mandamos a cerrar la conexión con el servidor.
        servidor.close();
        
        // Indicamos que la conexión fue cerrada.
        logger.log(Level.INFO, "Se ha cerrado la conexión con el servidor.");
    }
}
