/*
 * Respuesta.java
 */
package colecciones;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase para representar una entidad de Respuesta.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Respuesta {

    private ObjectId id;
    private String contenido;
    private Date fecha;
    private String emisor;
    private ObjectId idEmisor;

    /**
     * Constructor por ausencia.
     */
    public Respuesta() {
    }

    /**
     * Constructor que inicializa todos los atributos menos el ID de un ticket.
     *
     * @param contenido Contenido de la respuesta.
     * @param fecha Fecha en que se envió la respuesta.
     * @param emisor Nombre del emisor de la respuesta.
     * @param idEmisor ID del emisor de la respuesta.
     */
    public Respuesta(String contenido, Date fecha, String emisor, ObjectId idEmisor) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.emisor = emisor;
        this.idEmisor = idEmisor;
    }

    /**
     * Método que devuelve el ID de una respuesta.
     *
     * @return ID de una respuesta.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método que asigna el ID a una respuesta.
     *
     * @param id ID a asignar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método que devuelve el contenido de una respuesta.
     *
     * @return Contenido una respuesta.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Método que asigna el contenido a una respuesta.
     *
     * @param contenido Contenido a asignar.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Método que devuelve la fecha a una respuesta.
     *
     * @return Fecha de una respuesta.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método que asigna la fecha a una respuesta.
     *
     * @param fecha Fecha a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método que devuelve el nombre del emisor de la respuesta.
     *
     * @return Nombre del emisor de la respuesta.
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * Método que asigna el nombre del emisor de una respuesta.
     *
     * @param emisor Nombre del emisor de una respuesta.
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * Método que devuelve el ID del emisor de una respuesta.
     *
     * @return ID del emisor de una respuesta.
     */
    public ObjectId getIdEmisor() {
        return idEmisor;
    }

    /**
     * Método que asigna el ID del emisor de una respuesta.
     *
     * @param idEmisor ID a asignar.
     */
    public void setIdEmisor(ObjectId idEmisor) {
        this.idEmisor = idEmisor;
    }

}
