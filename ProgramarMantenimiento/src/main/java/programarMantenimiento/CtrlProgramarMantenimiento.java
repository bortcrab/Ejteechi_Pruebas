package programarMantenimiento;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import implementaciones.CamionBO;
import interfaces.ICamionBO;
import java.util.Date;

/**
 * Controlador para programar mantenimientos de camiones. Esta clase proporciona
 * funcionalidades para programar y gestionar el mantenimiento de camiones en el
 * sistema.
 *
 * @author elimo
 */
public class CtrlProgramarMantenimiento {

    private final ICamionBO camionBO;

    /**
     * Constructor de la clase CtrlProgramarMantenimiento. Inicializa un nuevo
     * objeto CtrlProgramarMantenimiento con una instancia de CamionBO.
     */
    public CtrlProgramarMantenimiento() {
        this.camionBO = new CamionBO();
    }

    /**
     * Obtiene un camión por su número de unidad.
     *
     * @param numeroUnidad El número de unidad del camión a obtener.
     * @return El objeto CamionDTO correspondiente al número de unidad
     * especificado.
     * @throws ProgramarMantenimientoException Si ocurre un error al obtener el
     * camión por su número de unidad.
     */
    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ProgramarMantenimientoException {
        try {
            camionBO.obtenerPorNumeroUnidad(numeroUnidad);
            return camionBO.obtenerPorNumeroUnidad(numeroUnidad);
        } catch (ObjetosNegocioException one) {
            throw new ProgramarMantenimientoException(one.getMessage());
        }
    }

    /**
     * Actualiza el estado de un camión.
     *
     * @param numeroUnidad El número de unidad del camión a actualizar.
     * @param estadoMotor El nuevo estado del motor del camión.
     * @param estadoLimpieza El nuevo estado de limpieza del camión.
     * @param estadoLlantas El nuevo estado de las llantas del camión.
     * @param estadoLuces El nuevo estado de las luces del camión.
     * @return El objeto Camion actualizado.
     * @throws ProgramarMantenimientoException Si ocurre un error al actualizar
     * el estado del camión.
     */
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ProgramarMantenimientoException {
        try {
            camionBO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
            return camionBO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
        } catch (ObjetosNegocioException one) {
            throw new ProgramarMantenimientoException(one.getMessage());
        }
    }

    /**
     * Actualiza la prioridad y la fecha de mantenimiento de un camión.
     *
     * @param numeroUnidad El número de unidad del camión a actualizar.
     * @param nuevaPrioridad La nueva prioridad del camión.
     * @param nuevaFechaMantenimiento La nueva fecha de mantenimiento del
     * camión.
     * @return El objeto CamionDTO actualizado.
     * @throws ProgramarMantenimientoException Si ocurre un error al actualizar
     * la prioridad y la fecha de mantenimiento del camión.
     */
    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ProgramarMantenimientoException {
        try {
            camionBO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
            return camionBO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
        } catch (ObjetosNegocioException one) {
            throw new ProgramarMantenimientoException(one.getMessage());
        }
    }

}
