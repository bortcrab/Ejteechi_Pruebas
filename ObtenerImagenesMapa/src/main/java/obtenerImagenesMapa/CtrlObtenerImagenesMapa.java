/*
 * CtrlObtenerImagenesMapa.java
 */
package obtenerImagenesMapa;

import utilidades.JXMapViewerCustom;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 * Clase control para obtener las imágenes del mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlObtenerImagenesMapa {
    
    /**
     * Método para obtener las imágenes del mapa de internet.
     *
     * @param pnlMapa Panel donde se dibujará el mapa.
     * @param posicionDefault Coordenadas donde se centrará el mapa.
     */
    public void obtenerImagenesMapa(JXMapViewerCustom pnlMapa, double[] posicionDefault) {
        // Creamos un objeto TileFactoryInfo.
        TileFactoryInfo info = new OSMTileFactoryInfo();
        // Creamos un objeto TileFactory.
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        
        // Al panel del parámetro le asignamos la el TileFactory.
        pnlMapa.setTileFactory(tileFactory);
        
        // Asignamos las coordenadas del mapa.
        GeoPosition geo = new GeoPosition(posicionDefault);
        pnlMapa.setAddressLocation(geo);
        // Asignamos un zoom inicial.
        pnlMapa.setZoom(6);
        
        // Creamos eventos para moverse por el mapa y para hacer zoom.
        MouseInputListener mil = new PanMouseInputListener(pnlMapa);
        pnlMapa.addMouseListener(mil);
        pnlMapa.addMouseMotionListener(mil);
        pnlMapa.addMouseWheelListener(new ZoomMouseWheelListenerCursor(pnlMapa));
    }
}
