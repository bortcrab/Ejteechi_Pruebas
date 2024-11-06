/*
 * IMapaDAO.java
 */
package interfaces;

import colecciones.Mapa;
import excepciones.PersistenciaException;

/**
 * Interfaz que define los métodos para acceder y manipular datos relacionados
 * con el mapa en la base de datos.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IMapaDAO {

    /**
     * Método para buscar en la base de datos el mapa a mostrar.
     *
     * @return El mapa si se encontró.
     * @throws PersistenciaException Si no se encontró ningún mapa.
     */
    public Mapa obtenerMapa() throws PersistenciaException;

}
