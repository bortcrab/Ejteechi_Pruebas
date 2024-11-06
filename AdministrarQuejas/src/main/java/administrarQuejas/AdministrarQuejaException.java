package administrarQuejas;

/**
 * Excepción lanzada para indicar errores relacionados con la administración de
 * quejas. Esta excepción se utiliza cuando ocurren problemas durante el proceso
 * de administración de quejas.
 *
 * @author elimo
 */
public class AdministrarQuejaException extends Exception {

    /**
     * Crea una nueva instancia de AdministrarQuejaException con el mensaje
     * especificado.
     *
     * @param message El mensaje que describe la excepción.
     */
    public AdministrarQuejaException(String message) {
        super(message);
    }

}
