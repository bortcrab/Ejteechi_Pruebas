/*
 * RutaDTO.java
 */
package dtos;

import java.util.List;
import org.jxmapviewer.viewer.GeoPosition;

/**
 * Clase DTO con las características que conforman una línea.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class RutaDTO {

    private List<DatosRutaDTO> listaDatosRuta;
    private List<GeoPosition> puntos;

    /**
     * Constructor por ausencia.
     */
    public RutaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param listaDatosRuta
     * @param puntos
     */
    public RutaDTO(List<DatosRutaDTO> listaDatosRuta, List<GeoPosition> puntos) {
        this.listaDatosRuta = listaDatosRuta;
        this.puntos = puntos;
    }

    /**
     * Método que devuelve la lista de datos de una ruta.
     *
     * @return Lista de datos de una ruta.
     */
    public List<DatosRutaDTO> getListaDatosRuta() {
        return listaDatosRuta;
    }

    /**
     * Método que asigna una lista de datos a una ruta.
     *
     * @param listaDatosRuta Lista de datos a asignar a una ruta.
     */
    public void setListaDatosRuta(List<DatosRutaDTO> listaDatosRuta) {
        this.listaDatosRuta = listaDatosRuta;
    }

    /**
     * Método que devuelve los puntos geográficos por donde pasa una ruta.
     *
     * @return Puntos geográficos por donde pasa una ruta.
     */
    public List<GeoPosition> getPuntos() {
        return puntos;
    }

    /**
     * Método para asignar los puntos geográficos por donde pasa una ruta.
     *
     * @param puntos Puntos geográficos por donde pasa una ruta.
     */
    public void setPuntos(List<GeoPosition> puntos) {
        this.puntos = puntos;
    }
}
