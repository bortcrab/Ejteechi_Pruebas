package administrarQuejas;

import dtos.QuejaDTO;

/**
 * Facade para la administración de quejas. Esta clase proporciona una interfaz
 * simplificada para interactuar con la lógica de negocio relacionada con la
 * gestión de quejas.
 *
 * @author elimo
 */
public class FacadeAdministrarQuejas implements IAdministrarQuejas {

    private final CtrlAdministrarQuejas ctrlAdministrarQuejas;

    /**
     * Constructor de la clase FacadeAdministrarQuejas. Inicializa un nuevo
     * objeto FacadeAdministrarQuejas con una instancia predeterminada de
     * CtrlAdministrarQuejas.
     */
    public FacadeAdministrarQuejas() {
        this.ctrlAdministrarQuejas = new CtrlAdministrarQuejas();
    }

    /**
     * Envía una queja al sistema para su procesamiento.
     *
     * @param queja Objeto QuejaDTO que contiene los detalles de la queja a
     * enviar.
     * @throws AdministrarQuejaException Si ocurre un error al enviar la queja.
     */
    @Override
    public void enviarQueja(QuejaDTO queja) throws AdministrarQuejaException {
        try {
            ctrlAdministrarQuejas.enviarQueja(queja);
        } catch (AdministrarQuejaException cce) {
            throw cce;
        }
    }
}
