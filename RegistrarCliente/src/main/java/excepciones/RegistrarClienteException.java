/*
 * RegistrarClienteException.java
 */
package excepciones;

/**
 * Clase para customizar las excepciones generadas en el subsistema RegistrarCliente.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class RegistrarClienteException extends Exception {

    /**
     * Constructor que establece el mensaje de error que explica el origen del
     * error que ocurrió al ejecutar una operación.
     *
     * @param mensaje Mensaje de error.
     */
    public RegistrarClienteException(String mensaje) {
        super(mensaje);
    }
}
