/*
 * LineaDTO.java
 */
package dtos;

import java.util.Set;
import org.jxmapviewer.viewer.Waypoint;

/**
 * Clase DTO con las características que conforman una línea.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class LineaDTO {

    private int numero;
    private Set<Waypoint> paradas;
    private RutaDTO ruta;

    /**
     * Constructor por ausencia.
     */
    public LineaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param numero
     * @param paradas Paradas de la línea.
     * @param ruta Ruta de la línea.
     */
    public LineaDTO(int numero, Set<Waypoint> paradas, RutaDTO ruta) {
        this.paradas = paradas;
        this.ruta = ruta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * Método que devuelve las paradas de una línea.
     *
     * @return Paradas de una línea.
     */
    public Set<Waypoint> getParadas() {
        return paradas;
    }

    /**
     * Método que asigna las paradas a una línea.
     *
     * @param paradas Paradas a asignar.
     */
    public void setParadas(Set<Waypoint> paradas) {
        this.paradas = paradas;
    }

    /**
     * Método que devuelve la ruta de una línea.
     *
     * @return Ruta de una línea.
     */
    public RutaDTO getRuta() {
        return ruta;
    }

    /**
     * Método que asigna una ruta a una línea.
     *
     * @param ruta
     */
    public void setRuta(RutaDTO ruta) {
        this.ruta = ruta;
    }

}
