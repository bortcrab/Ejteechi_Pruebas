/*
 * IMostrarMapa.java
 */
package mostrarMapa;

import excepciones.MostrarMapaException;
import dtos.DatosRutaDTO;
import utilidades.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;

/**
 * Interfaz que define los métodos que el subsistema puede realizar.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IMostrarMapa {

    /**
     * Método que carga y devuelve el mapa a mostrar.
     * 
     * @param pnlMapa Panel donde se mostrará el mapa.
     * @return El mapa encontrado.
     * @throws MostrarMapaException si no se encontró ningún mapa.
     */
    public MapaDTO cargarMapa(JXMapViewerCustom pnlMapa) throws MostrarMapaException;
    
    /**
     * Método que carga los datos de la ruta a mostrar.
     * 
     * @param ruta Ruta que se quiere mostrar.
     * @return Lista con los datos de la ruta.
     */
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta);
}
