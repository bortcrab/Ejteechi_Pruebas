/*
 * FacadeMostrarMapa.java
 */
package mostrarMapa;

import excepciones.MostrarMapaException;
import dtos.DatosRutaDTO;
import utilidades.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;

/**
 * Clase fachada que implementa los métodos de la interfaz IMostrarMapa para
 * facilitar el uso del subsistema al usuario.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeMostrarMapa implements IMostrarMapa {

    private final CtrlMostrarMapa ctrlMostrarMapa;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeMostrarMapa() {
        ctrlMostrarMapa = new CtrlMostrarMapa();
    }

    /**
     * Método que carga y devuelve el mapa a mostrar.
     *
     * @param pnlMapa Panel donde se mostrará el mapa.
     * @return El mapa encontrado.
     * @throws MostrarMapaException si no se encontró ningún mapa.
     */
    @Override
    public MapaDTO cargarMapa(JXMapViewerCustom pnlMapa) throws MostrarMapaException {
        return ctrlMostrarMapa.cargarMapa(pnlMapa);
    }

    /**
     * Método que carga los datos de la ruta a mostrar.
     *
     * @param ruta Ruta que se quiere mostrar.
     * @return Lista con los datos de la ruta.
     */
    @Override
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta) {
        return ctrlMostrarMapa.cargarRuta(ruta);
    }
}
