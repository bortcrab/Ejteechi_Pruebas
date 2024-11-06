package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

/**
 * Implementación de la interfaz IVisualizarQuejas que proporciona una fachada
 * para visualizar quejas. Esta clase actúa como una fachada para proporcionar
 * métodos para visualizar y manipular quejas en el sistema.
 *
 * @author elimo
 */
public class FacadeVisualizarQuejas implements IVisualizarQuejas {

    private final CtrlVisualizarQuejas ctrlVisualizarQuejas;

    /**
     * Constructor de la clase FacadeVisualizarQuejas. Inicializa un nuevo
     * objeto FacadeVisualizarQuejas con una instancia de CtrlVisualizarQuejas.
     */
    public FacadeVisualizarQuejas() {
        this.ctrlVisualizarQuejas = new CtrlVisualizarQuejas();
    }
    
    /**
     * Obtiene una lista de todas las quejas según la selección.
     *
     * @param seleccion La selección realizada.
     * @return Una lista de QuejaDTO que coinciden con la selección.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    @Override
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.obtenerQuejas(seleccion);
    }

    /**
     * Confirma la lectura de una queja.
     *
     * @param queja La queja que se va a marcar como leída.
     * @return La queja actualizada con la confirmación de lectura.
     * @throws VisualizarQuejasException Si ocurre un error al confirmar la
     * lectura de la queja.
     */
    @Override
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.confirmarLectura(queja);
    }

}
