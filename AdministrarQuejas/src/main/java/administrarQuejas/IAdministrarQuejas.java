/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administrarQuejas;

import dtos.QuejaDTO;

/**
 * Interfaz para la administración de quejas. Esta interfaz define los métodos
 * necesarios para administrar quejas en el sistema.
 *
 * @author elimo
 */
public interface IAdministrarQuejas {

    /**
     * Envía una queja al sistema para su procesamiento.
     *
     * @param queja Objeto QuejaDTO que contiene los detalles de la queja a
     * enviar.
     * @throws AdministrarQuejaException Si ocurre un error al enviar la queja.
     */
    public void enviarQueja(QuejaDTO queja) throws AdministrarQuejaException;

}
