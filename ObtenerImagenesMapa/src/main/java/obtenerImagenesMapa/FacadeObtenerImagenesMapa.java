/**
 * FacadeObtenerImagenesMapa.java
 */
package obtenerImagenesMapa;

import utilidades.JXMapViewerCustom;

/**
 * Clase fachada que implementa los métodos de la interfaz IObtenerImagenesMapa
 * para facilitar el uso del subsistema externo.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeObtenerImagenesMapa implements IObtenerImagenesMapa {

    private final CtrlObtenerImagenesMapa ctrlObtenerImagenesMapa;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeObtenerImagenesMapa() {
        this.ctrlObtenerImagenesMapa = new CtrlObtenerImagenesMapa();
    }

    /**
     * Método para obtener las imágenes del mapa de internet.
     *
     * @param pnlMapa Panel donde se dibujará el mapa.
     * @param posicionDefault Coordenadas donde se centrará el mapa.
     */
    @Override
    public void obtenerImagenesMapa(JXMapViewerCustom pnlMapa, double[] posicionDefault) {
        // Mandamos a obtener las imágenes del mapa.
        ctrlObtenerImagenesMapa.obtenerImagenesMapa(pnlMapa, posicionDefault);
    }

}
