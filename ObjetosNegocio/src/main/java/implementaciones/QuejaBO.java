package implementaciones;

import colecciones.Queja;
import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import excepciones.PersistenciaException;
import interfaces.IQuejaBO;
import interfaces.IQuejaDAO;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementación de la interfaz IQuejaBO que proporciona métodos para gestionar quejas.
 * Esta clase permite enviar quejas, obtener quejas por diversos criterios y confirmar la lectura de una queja.
 * 
 * @author elimo
 */
public class QuejaBO implements IQuejaBO {

    private IQuejaDAO quejaDAO;

    /**
 * Constructor de la clase QuejaBO.
 * Inicializa un nuevo objeto QuejaBO creando una instancia de QuejaDAO para su uso en la gestión de quejas.
 */
    public QuejaBO() {
        this.quejaDAO = new QuejaDAO();
    }

    /**
     * Envía una queja representada por un objeto de tipo QuejaDTO.
     *
     * @param quejaDTO El objeto QuejaDTO que contiene la información de la
     * queja a enviar.
     * @return Un objeto QuejaDTO que representa la queja enviada.
     * @throws ObjetosNegocioException Si ocurre un error al enviar la queja.
     */
    @Override
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException {

        try {
            quejaDAO.insertarQueja(convertirDTOToQueja(quejaDTO));
            return quejaDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }

    }

    /**
 * Convierte un objeto de la clase Queja a un objeto de la clase QuejaDTO.
 *
 * @param queja El objeto de la clase Queja que se va a convertir.
 * @return Un objeto de la clase QuejaDTO con los atributos de la queja.
 */
    public static QuejaDTO convertirQuejaToDTO(Queja queja) {
        QuejaDTO quejaDTO = new QuejaDTO();
        quejaDTO.setLeido(queja.isLeido());
        quejaDTO.setNoQueja(queja.getId());
        quejaDTO.setTipoQueja(queja.getTipo());
        quejaDTO.setFecha(queja.getFecha());
        quejaDTO.setDescripcion(queja.getComentario());
        quejaDTO.setAnonimo(queja.isAnonimo());
        quejaDTO.setIdCliente(queja.getIdCliente());
        return quejaDTO;
    }

    /**
     * 
     * @param quejaDTO
     * @return 
     */
    public static Queja convertirDTOToQueja(QuejaDTO quejaDTO) {
        Queja queja = new Queja();
        queja.setLeido(quejaDTO.isLeido());
        queja.setId(quejaDTO.getNoQueja());
        queja.setTipo(quejaDTO.getTipoQueja());
        queja.setFecha(quejaDTO.getFecha());
        queja.setComentario(quejaDTO.getDescripcion());
        queja.setAnonimo(quejaDTO.isAnonimo());
        queja.setIdCliente(quejaDTO.getIdCliente());
        return queja;
    }

     /**
     * Obtiene una lista de todas las quejas según la selección.
     *
     * @param seleccion La selección realizada.
     * @return Una lista de QuejaDTO que coinciden con la selección.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las
     * quejas.
     */
    @Override
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws ObjetosNegocioException {
        try {
            List<Queja> quejas = new ArrayList<>();
            if (seleccion.equals("<Elije uno>")) {
                quejas = quejaDAO.obtenerTodasLasQuejas();
            } else if (seleccion.equals("No leidos")) {
                quejas = quejaDAO.obtenerQuejasPorEstadoYAnonimato(false);
            } else if (seleccion.equals("Leidos")) {
                quejas = quejaDAO.obtenerQuejasPorEstadoYAnonimato(true);
            } else {
                quejas = quejaDAO.obtenerQuejasPorTipo(seleccion);
            }
            List<QuejaDTO> quejasDTO = new ArrayList<>();
            for (Queja queja : quejas) {
                quejasDTO.add(convertirQuejaToDTO(queja));
            }
            return quejasDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

    /**
     * Obtiene una lista de quejas filtradas por estado de lectura.
     *
     * @param queja Queja que contiene el estado de lectura de las quejas que se desea obtener
     * @return Una lista de objetos QuejaDTO que representan las quejas con el
     * estado de lectura especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las quejas
     * por estado de lectura.
     */
    @Override
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws ObjetosNegocioException {
        try {
            Queja quejas = quejaDAO.confirmarLectura(convertirDTOToQueja(queja));
            return convertirQuejaToDTO(quejas);
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

}
