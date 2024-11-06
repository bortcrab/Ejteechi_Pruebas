/*
 * IQuejaBO.java
 */
package interfaces;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de quejas.
 * Esta interfaz proporciona métodos para enviar quejas, obtener quejas por diversos criterios
 * como tipo o estado, y confirmar la lectura de una queja.
 * 
 * @author elimo
 */
public interface IQuejaBO {

    /**
     * Envía una queja representada por un objeto de tipo QuejaDTO.
     *
     * @param quejaDTO El objeto QuejaDTO que contiene la información de la
     * queja a enviar.
     * @return Un objeto QuejaDTO que representa la queja enviada.
     * @throws ObjetosNegocioException Si ocurre un error al enviar la queja.
     */
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException;
    
    /**
     * Devuelve todas las quejas según la selección que se haya hecho.
     *
     * @param seleccion Filtro para obtener las quejas.
     * @return Una lista con todas las quejas encontradas.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las quejas.
     */
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws ObjetosNegocioException;
    
    /**
     * Obtiene una lista de quejas filtradas por estado de lectura.
     *
     * @param queja Queja que contiene el estado de lectura de las quejas que se desea obtener
     * @return Una lista de objetos QuejaDTO que representan las quejas con el
     * estado de lectura especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las quejas
     * por estado de lectura.
     */
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws ObjetosNegocioException;

}
