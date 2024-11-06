package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase para representar una entidad de Linea.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Linea {

    private ObjectId id;
    private int numero;
    private List<List<Double>> paradas;
    private Ruta ruta;

    /**
     * Constructor por ausencia.
     */
    public Linea() {
    }

    /**
     * Constructor que inicializa todos los atributos menos el ID de la entidad.
     *
     * @param numero Número de la línea.
     * @param paradas Paradas de la línea.
     * @param ruta Ruta de la línea.
     */
    public Linea(int numero, List<List<Double>> paradas, Ruta ruta) {
        this.numero = numero;
        this.paradas = paradas;
        this.ruta = ruta;
    }

    /**
     * Método para devolver el ID de la línea.
     *
     * @return ID de la línea.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para asignar el ID a una línea.
     *
     * @param id ID a asignar a una línea.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para devolver el número de la línea.
     *
     * @return El número de la línea.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para asignarle un número a una línea.
     *
     * @param numero Número a asignar a una línea.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método para devolver las paradas de una línea.
     *
     * @return Paradas de una línea.
     */
    public List<List<Double>> getParadas() {
        return paradas;
    }

    /**
     * Método para asignar paradas a una línea.
     *
     * @param paradas Paradas a asignar a una línea.
     */
    public void setParadas(List<List<Double>> paradas) {
        this.paradas = paradas;
    }

    /**
     * Método para devolver la ruta de una línea.
     *
     * @return Ruta de una línea.
     */
    public Ruta getRuta() {
        return ruta;
    }

    /**
     * Método para asignar una ruta a una línea.
     *
     * @param ruta Ruta a asignar a una línea.
     */
    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

}
