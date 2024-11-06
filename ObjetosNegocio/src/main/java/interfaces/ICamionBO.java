/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import java.util.Date;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de camiones.
 * Esta interfaz proporciona métodos para realizar operaciones como obtener
 * información de un camión, actualizar su estado, prioridad o fecha de
 * mantenimiento, entre otras.
 *
 * @author elimo
 */
public interface ICamionBO {

    /**
     * Obtiene un objeto de tipo CamionDTO basado en el número de unidad
     * proporcionado.
     *
     * @param numeroUnidad El número de unidad del camión que se desea obtener.
     * @return Un objeto de tipo CamionDTO que corresponde al número de unidad
     * especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener la unidad.
     */
    CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ObjetosNegocioException;

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
    Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ObjetosNegocioException;

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
    CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ObjetosNegocioException;

}
