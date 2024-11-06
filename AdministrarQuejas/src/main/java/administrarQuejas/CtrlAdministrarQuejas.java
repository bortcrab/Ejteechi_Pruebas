package administrarQuejas;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import implementaciones.QuejaBO;
import interfaces.IQuejaBO;

/**
 * Controlador para la administración de quejas. Este controlador facilita la
 * interacción entre la interfaz de usuario y la lógica de negocio relacionada
 * con la gestión de quejas.
 *
 * @author elimo
 */
public class CtrlAdministrarQuejas {

    private final IQuejaBO quejaBO;

    /**
     * Constructor de la clase CtrlAdministrarQuejas. Inicializa un nuevo objeto
     * CtrlAdministrarQuejas con una instancia predeterminada de QuejaBO.
     */
    public CtrlAdministrarQuejas() {
        this.quejaBO = new QuejaBO();
    }

    /**
     * Envía una queja al sistema para su procesamiento.
     *
     * @param queja Objeto QuejaDTO que contiene los detalles de la queja a
     * enviar.
     * @throws AdministrarQuejaException Si ocurre un error al enviar la queja.
     */
    public void enviarQueja(QuejaDTO queja) throws AdministrarQuejaException {
        try {
            quejaBO.enviarQueja(queja);
        } catch (ObjetosNegocioException one) {
            throw new AdministrarQuejaException(one.getMessage());
        }
    }

}
