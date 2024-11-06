/*
 * MapaDTO.java
 */
package dtos;

import java.util.List;

/**
 * Clase DTO con las características que conforman un mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class MapaDTO {

    private double[] posicionDefault;
    private List<LineaDTO> lineas;

    /**
     * Constructor por ausencia.
     */
    public MapaDTO() {
    }

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param posicionDefault Coordenadas default del mapa.
     * @param lineas Lista de líneas que conforman al mapa.
     */
    public MapaDTO(double[] posicionDefault, List<LineaDTO> lineas) {
        this.posicionDefault = posicionDefault;
        this.lineas = lineas;
    }

    /**
     * Método que devuelve las líneas del mapa.
     *
     * @return Líneas del mapa.
     */
    public List<LineaDTO> getLineas() {
        return lineas;
    }

    /**
     * Método que asigna las líneas al mapa.
     *
     * @param lineas Líneas a asignar al mapa.
     */
    public void setLineas(List<LineaDTO> lineas) {
        this.lineas = lineas;
    }

    /**
     * Método para devolver las coordenadas del mapa.
     *
     * @return Coordenadas default del mapa.
     */
    public double[] getPosicionDefault() {
        return posicionDefault;
    }

    /**
     * Método para asignar unas coordenadas al mapa.
     *
     * @param posicionDefault Coordenadas default a asiganar.
     */
    public void setPosicionDefault(double[] posicionDefault) {
        this.posicionDefault = posicionDefault;
    }

}
