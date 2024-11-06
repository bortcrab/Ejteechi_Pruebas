package programarMantenimiento;

/**
 * Excepción lanzada cuando ocurre un error al programar el mantenimiento.
 *
 * Esta excepción puede ser utilizada para manejar errores relacionados con la
 * programación de mantenimiento en un contexto específico del sistema.
 *
 * @author elimo
 */
public class ProgramarMantenimientoException extends Exception {

    /**
     * Crea una nueva excepción de programación de mantenimiento con el mensaje
     * especificado.
     *
     * @param message El mensaje que describe la excepción.
     */
    public ProgramarMantenimientoException(String message) {
        super(message);
    }

}
