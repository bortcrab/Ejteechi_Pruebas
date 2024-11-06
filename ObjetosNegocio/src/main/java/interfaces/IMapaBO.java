/*
 * IMapaBO.java
 */
package interfaces;

import dtos.MapaDTO;
import excepciones.ObjetosNegocioException;

/**
 * Interfaz que define los métodos para aplicar las reglas de negocio en lo
 * relacionado con el mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IMapaBO {

    /**
     * Método que devuelve el mapa a mostrar.
     * 
     * @return El mapa encontrado.
     * @throws ObjetosNegocioException si no se encontró ningún mapa.
     */
    public MapaDTO obtenerMapa() throws ObjetosNegocioException;
    
}
