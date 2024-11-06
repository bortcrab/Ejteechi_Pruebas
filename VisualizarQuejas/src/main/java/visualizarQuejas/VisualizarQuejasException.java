package visualizarQuejas;

/**
 * Excepción personalizada para errores relacionados con la visualización de
 * quejas. Esta excepción se utiliza para manejar errores específicos
 * relacionados con la visualización de quejas en el sistema.
 *
 * @author elimo
 */
public class VisualizarQuejasException extends Exception {

    /**
     * Constructor de la clase VisualizarQuejasException. Crea una nueva
     * instancia de VisualizarQuejasException con el mensaje de error
     * especificado.
     *
     * @param message El mensaje que describe el error.
     */
    public VisualizarQuejasException(String message) {
        super(message);
    }

}
