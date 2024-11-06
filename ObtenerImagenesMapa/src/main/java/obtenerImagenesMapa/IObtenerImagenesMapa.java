/*
 * IObtenerImagenesMapa.java
 */
package obtenerImagenesMapa;

import utilidades.JXMapViewerCustom;

/**
 * Interfaz que define los métodos del subsistema externo para obtener las
 * imágenes del mapa de internet.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IObtenerImagenesMapa {

    /**
     * Método para obtener las imágenes del mapa de internet.
     * 
     * @param pnlMapa Panel donde se dibujará el mapa.
     * @param posicionDefault Coordenadas donde se centrará el mapa.
     */
    public void obtenerImagenesMapa(JXMapViewerCustom pnlMapa, double[] posicionDefault);

}
