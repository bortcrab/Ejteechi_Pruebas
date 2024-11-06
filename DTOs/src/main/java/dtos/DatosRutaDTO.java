/*
 * DatosRutaDTO.java
 */
package dtos;

import com.graphhopper.util.PointList;

/**
 * Clase DTO con las características que conforman los datos de una ruta entre
 * dos puntos.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class DatosRutaDTO {

    private double distancia;
    private String descripcion;
    private PointList puntos;

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param distancia Distancia entre los puntos.
     * @param descripcion Descripción de las vueltas a dar en el recorrido.
     * @param puntos Puntos de inicio y destino.
     */
    public DatosRutaDTO(double distancia, String descripcion, PointList puntos) {
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.puntos = puntos;
    }

    /**
     * Método para devolver la distancia que hay entre dos puntos.
     *
     * @return Distancia que hay entre dos puntos.
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Método que asigna la distancia que hay entre dos puntos.
     *
     * @param distancia Distancia a asignar.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Método que devuelve la descripción de las vueltas a dar en el recorrido.
     *
     * @return Descripción de las vueltas del recorrido.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para asignar la descripción de las vueltas a dar en el recorrido.
     *
     * @param descripcion Descripción a asignar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método que devuelve los puntos de inicio y destino.
     *
     * @return Puntos de inicio y destino.
     */
    public PointList getPuntos() {
        return puntos;
    }

    /**
     * Método que asigna los puntos de inicio y destino.
     *
     * @param puntos Puntos de inicio y destino a asignar.
     */
    public void setPuntos(PointList puntos) {
        this.puntos = puntos;
    }

}
