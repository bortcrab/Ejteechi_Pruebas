package implementaciones;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import interfaces.ICamionBO;
import interfaces.ICamionDAO;
import java.util.Date;

/**
 * Esta clase representa la lógica de negocio para la gestión de camiones.
 * Proporciona métodos para realizar operaciones relacionadas con camiones
 *
 * @author elimo
 */
public class CamionBO implements ICamionBO {

    private final ICamionDAO camionDAO;

    /**
     * Constructor de la clase CamionBO. Inicializa un nuevo objeto CamionBO
     * creando una instancia de CamionDAO para su uso en la lógica de negocio
     * relacionada con camiones.
     */
    public CamionBO() {
        this.camionDAO = new CamionDAO();
    }

    /**
     * Convierte un objeto de la clase Camion a un objeto de la clase CamionDTO.
     *
     * @param camion El objeto de la clase Camion que se va a convertir.
     * @return Un objeto de la clase CamionDTO con los atributos del camión.
     */
    public static CamionDTO CamionADTO(Camion camion) {
        CamionDTO camionDTO = new CamionDTO();
        camionDTO.setNumeroUnidad(camion.getNumeroUnidad());
        camionDTO.setEstadoMotor(camion.getEstadoMotor());
        camionDTO.setEstadoLimpieza(camion.getEstadoLimpieza());
        camionDTO.setEstadoLlantas(camion.getEstadoLlantas());
        camionDTO.setEstadoLuces(camion.getEstadoLuces());
        camionDTO.setNivelPrioridad(camion.getNivelPrioridad());
        camionDTO.setFechaUltimoMantenimiento(camion.getFechaUltimoMantenimiento());
        return camionDTO;
    }

    /**
     * Obtiene un objeto de tipo CamionDTO basado en el número de unidad
     * proporcionado.
     *
     * @param numeroUnidad El número de unidad del camión que se desea obtener.
     * @return Un objeto de tipo CamionDTO que corresponde al número de unidad
     * especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener la unidad.
     */
    @Override
    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ObjetosNegocioException {
        camionDAO.obtenerPorNumeroUnidad(numeroUnidad);
        if (camionDAO.obtenerPorNumeroUnidad(numeroUnidad) == null) {
            throw new ObjetosNegocioException("Ocurrió un error al obtener la unidad.");
        }
        return CamionADTO(camionDAO.obtenerPorNumeroUnidad(numeroUnidad));
    }

    /**
     * Actualiza la prioridad y la fecha de mantenimiento de un camión
     * identificado por su número de unidad.
     *
     * @param numeroUnidad El número de unidad del camión que se va a
     * actualizar.
     * @param nuevaPrioridad La nueva prioridad que se asignará al camión.
     * @param nuevaFechaMantenimiento La nueva fecha de mantenimiento que se
     * asignará al camión.
     * @return Un objeto de tipo CamionDTO que representa el camión actualizado.
     * @throws ObjetosNegocioException Si ocurre un error al actualizar los
     * datos de la unidad.
     */
    @Override
    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ObjetosNegocioException {
        camionDAO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
        if (camionDAO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento) == null) {
            throw new ObjetosNegocioException("Ocurrio un error al actualizar los datos de la unidad");
        }
        return CamionADTO(camionDAO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento));
    }

    /**
     * Actualiza el estado del camión identificado por su número de unidad.
     *
     * @param numeroUnidad El número de unidad del camión que se va a
     * actualizar.
     * @param estadoMotor El nuevo estado del motor del camión.
     * @param estadoLimpieza El nuevo estado de limpieza del camión.
     * @param estadoLlantas El nuevo estado de las llantas del camión.
     * @param estadoLuces El nuevo estado de las luces del camión.
     * @return El camión actualizado.
     * @throws ObjetosNegocioException Si ocurre un error al actualizar el
     * estado del camión.
     */
    @Override
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ObjetosNegocioException {
        camionDAO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
        if (camionDAO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces) == null) {
            throw new ObjetosNegocioException("Ocurrio un error al actualizar la unidad");
        }
        return camionDAO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
    }

}
