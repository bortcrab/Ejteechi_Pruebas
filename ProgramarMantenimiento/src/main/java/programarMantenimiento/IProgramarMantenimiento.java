/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package programarMantenimiento;

import colecciones.Camion;
import dtos.CamionDTO;
import java.util.Date;

/**
 * Esta interfaz define métodos para programar el mantenimiento de vehículos.
 * Los objetos que implementan esta interfaz son responsables de realizar la
 * programación de mantenimiento de vehículos como camiones, autos, etc.
 *
 * @author elimo
 */
public interface IProgramarMantenimiento {

    /**
     * Obtiene la información de un camión basándose en su número de unidad.
     *
     * @param numeroUnidad El número de unidad del camión a buscar.
     * @return El objeto CamionDTO que corresponde al número de unidad
     * especificado.
     * @throws ProgramarMantenimientoException Si ocurre un error al intentar
     * obtener la información del camión.
     */
    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ProgramarMantenimientoException;

    /**
     * Actualiza el estado de un camión con los valores proporcionados para sus
     * componentes.
     *
     * @param numeroUnidad El número de unidad del camión a actualizar.
     * @param estadoMotor El estado del motor del camión.
     * @param estadoLimpieza El estado de limpieza del camión.
     * @param estadoLlantas El estado de las llantas del camión.
     * @param estadoLuces El estado de las luces del camión.
     * @return El objeto Camion actualizado.
     * @throws ProgramarMantenimientoException Si ocurre un error al intentar
     * actualizar el estado del camión.
     */
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ProgramarMantenimientoException;

    /**
     * Actualiza la prioridad y la fecha de mantenimiento de un camión
     * identificado por su número de unidad.
     *
     * @param numeroUnidad El número de unidad del camión a actualizar.
     * @param nuevaPrioridad La nueva prioridad a asignar al camión.
     * @param nuevaFechaMantenimiento La nueva fecha de mantenimiento a asignar
     * al camión.
     * @return Un objeto CamionDTO que representa el camión actualizado.
     * @throws ProgramarMantenimientoException Si ocurre un error al programar
     * el mantenimiento del camión.
     */
    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ProgramarMantenimientoException;
}
