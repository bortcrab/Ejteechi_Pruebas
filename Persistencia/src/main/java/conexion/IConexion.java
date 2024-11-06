/*
 * IConexion.java
 */
package conexion;

import com.mongodb.client.MongoDatabase;

/**
 * Interfaz con los métodos necesarios para crear conexiones con la base de
 * datos.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IConexion {
    
    /**
     * Método para crear una conexión con la base de datos.
     *
     * @return Un objeto del tipo MongoDatabase.
     */
    public MongoDatabase crearConexion();
    
    /**
     * Método para cerrar una conexión con la base de datos.
     */
    public void cerrarConexion();
}
