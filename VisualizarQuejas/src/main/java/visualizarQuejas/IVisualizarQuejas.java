/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

/**
 * Interfaz para visualizar quejas. Define métodos para obtener y manipular
 * quejas en el sistema.
 *
 * @author elimo
 */
public interface IVisualizarQuejas {
    
    /**
     * Obtiene una lista de todas las quejas según la selección.
     *
     * @param seleccion La selección realizada.
     * @return Una lista de QuejaDTO que coinciden con la selección.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws VisualizarQuejasException;
        
    /**
     * Confirma la lectura de una queja.
     *
     * @param queja La queja que se va a marcar como leída.
     * @return La queja actualizada con la confirmación de lectura.
     * @throws VisualizarQuejasException Si ocurre un error al confirmar la
     * lectura de la queja.
     */
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException;

}
