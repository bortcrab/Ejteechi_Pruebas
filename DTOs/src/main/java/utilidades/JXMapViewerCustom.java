/*
 * JXMapViewerCustom.java
 */
package utilidades;

import com.graphhopper.util.shapes.GHPoint3D;
import dtos.DatosRutaDTO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.function.Consumer;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;

/**
 * Clase que hereda de JXMapViewer y añade funcionalidades para dibujar paradas
 * y rutas.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class JXMapViewerCustom extends JXMapViewer {

    private List<DatosRutaDTO> listaDatosRuta;
    private boolean first = true;

    /**
     * Método que devuelve la lista de datos de una ruta.
     *
     * @return Lista de datos de una ruta.
     */
    public List<DatosRutaDTO> getListaDatosRuta() {
        return listaDatosRuta;
    }

    /**
     * Método que asigna la lista de datos de una ruta.
     *
     * @param listaDatosRuta Lista de datos de una ruta a asignar.
     */
    public void setListaDatosRuta(List<DatosRutaDTO> listaDatosRuta) {
        this.listaDatosRuta = listaDatosRuta;
        repaint();
    }

    /**
     * Método utilizado para dibujar una representación gráfica de una lista de
     * datos de una ruta en un panel.
     *
     * @param g Objeto Graphics proporcionado por el sistema de gráficos de
     * Java.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (listaDatosRuta != null && !listaDatosRuta.isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Path2D p2 = new Path2D.Double();
            first = true;
            for (DatosRutaDTO d : listaDatosRuta) {
                draw(p2, d);
            }
            g2.setColor(new Color(28, 23, 255));
            g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.draw(p2);
            g2.dispose();
        }
    }

    /**
     * Método utilizado para dibujar un conjunto de puntos en un objeto Path2D.
     *
     * @param p2 Objeto Path2D en el que se dibujarán los puntos.
     * @param d Objeto DatosRutaDTO que contiene los puntos a dibujar.
     */
    private void draw(Path2D p2, DatosRutaDTO d) {
        d.getPuntos().forEach(new Consumer<GHPoint3D>() {
            @Override
            public void accept(GHPoint3D t) {
                Point2D point = convertGeoPositionToPoint(new GeoPosition(t.getLat(), t.getLon()));
                if (first) {
                    first = false;
                    p2.moveTo(point.getX(), point.getY());
                } else {
                    p2.lineTo(point.getX(), point.getY());
                }
            }
        });
    }
}
