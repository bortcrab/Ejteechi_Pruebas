/*
 * Ruta.java
 */
package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase para representar una entidad de Ruta.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Ruta {

    private ObjectId id;
    private List<List<Double>> puntos;

    /**
     * Constructor por ausencia.
     */
    public Ruta() {
    }

    /**
     * Constructor que inicializa el atributo puntos de la entidad.
     *
     * @param puntos Puntos por donde pasa la ruta.
     */
    public Ruta(List<List<Double>> puntos) {
        this.puntos = puntos;
    }

    /**
     * Método que devuelve el ID de una ruta.
     *
     * @return ID de una ruta.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método que asignar el ID a una ruta.
     *
     * @param id ID a asignar a una ruta.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método que devuelve los puntos por donde pasa una ruta.
     *
     * @return Puntos por donde pasa una ruta.
     */
    public List<List<Double>> getPuntos() {
        return puntos;
    }

    /**
     * Método que asigna los puntos por donde pasa una ruta.
     *
     * @param puntos Puntos a asignar.
     */
    public void setPuntos(List<List<Double>> puntos) {
        this.puntos = puntos;
    }

}
