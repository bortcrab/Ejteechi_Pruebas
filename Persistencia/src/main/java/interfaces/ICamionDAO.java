/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import colecciones.Camion;
import java.util.Date;

/**
 * Interfaz que define las operaciones de acceso a datos para la gestión de camiones.
 * Esta interfaz proporciona métodos para realizar operaciones como obtener un camión por su número de unidad,
 * actualizar el estado, la prioridad o la fecha de mantenimiento de un camión, entre otras.
 * 
 * @author elimo
 */
public interface ICamionDAO {

    /**
 * Obtiene un objeto de tipo Camion basado en el número de unidad proporcionado.
 *
 * @param numeroUnidad El número de unidad del camión que se desea obtener.
 * @return Un objeto de tipo Camion que corresponde al número de unidad especificado, o null si no se encuentra.
 */
    Camion obtenerPorNumeroUnidad(String numeroUnidad);

    /**
 * Actualiza el estado de un camión identificado por su número de unidad.
 *
 * @param numeroUnidad El número de unidad del camión que se va a actualizar.
 * @param estadoMotor El nuevo estado del motor del camión.
 * @param estadoLimpieza El nuevo estado de limpieza del camión.
 * @param estadoLlantas El nuevo estado de las llantas del camión.
 * @param estadoLuces El nuevo estado de las luces del camión.
 * @return El camión actualizado.
 */
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces);

    /**
 * Actualiza la prioridad y la fecha de mantenimiento de un camión identificado por su número de unidad.
 *
 * @param numeroUnidad El número de unidad del camión que se va a actualizar.
 * @param nuevaPrioridad La nueva prioridad que se asignará al camión.
 * @param nuevaFechaMantenimiento La nueva fecha de mantenimiento que se asignará al camión.
 * @return El camión actualizado.
 */
    Camion actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento);
}
