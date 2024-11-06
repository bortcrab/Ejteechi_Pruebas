/*
 * PersistenciaException.java
 */
package excepciones;

/**
 * Clase para customizar las excepciones generadas en la capa de persistencia.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor que establece el mensaje de error que explica el origen del
     * error que ocurrió al ejecutar una operación.
     *
     * @param mensaje Mensaje de error.
     */
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }
    
}
