/*
 * Ticket.java
 */
package colecciones;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase para representar una entidad de Ticket.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Ticket {

    private ObjectId id;
    private String contenido;
    private Date fecha;
    private String estado;
    private ObjectId idUsuario;
    private String nombreUsuario;
    private ObjectId idAtendiendo;
    private List<Respuesta> respuestas;

    /**
     * Constructor por ausencia.
     */
    public Ticket() {
    }

    /**
     * Constructor que inicializa todos los atributos menos el ID de un ticket.
     *
     * @param contenido Contenido del ticket.
     * @param fecha Fecha en que se envió el ticket.
     * @param estado Estado del ticket.
     * @param idUsuario ID del cliente que envió el ticket.
     * @param nombreUsuario Nombre del cliente que envió el ticket.
     * @param idAtendiendo ID del trabajador que está atendiendo el ticket.
     * @param respuestas Respuestas del ticket.
     */
    public Ticket(String contenido, Date fecha, String estado, ObjectId idUsuario, String nombreUsuario, ObjectId idAtendiendo, List<Respuesta> respuestas) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idAtendiendo = idAtendiendo;
        this.respuestas = respuestas;
    }

    /**
     * Método que devuelve el ID de un ticket.
     *
     * @return ID de un ticket.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método que asigna el ID a un ticket.
     *
     * @param id ID a asignar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método que devuelve el contenido de un ticket.
     *
     * @return Contenido del ticket.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Método que asigna el contenido a un ticket.
     *
     * @param contenido Contenido a asignar.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Método que devuelve la fecha a un ticket.
     *
     * @return Fecha de un ticket.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método que asigna la fecha a un ticket.
     *
     * @param fecha Fecha a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método que devuelve el estado de un ticket.
     *
     * @return Estado de un ticket.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que asigna el estado a un ticket.
     *
     * @param estado Estado a asignar.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que devuelve el ID del cliente que envió un ticket.
     *
     * @return ID del cliente que envió el ticket.
     */
    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    /**
     * Método que asigna el ID del cliente que envió un ticket.
     *
     * @param idUsuario ID a asignar.
     */
    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Método que devuelve el nombre del cliente que envió un ticket.
     *
     * @return Nombre del cliente que envió un ticket.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método que asigna el nombre del cliente que envió un ticket.
     *
     * @param nombreUsuario Nombre a asignar.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método que devuelve el ID del trabajador que está atendiendo un ticket.
     *
     * @return ID del trabajador que está atendiendo un ticket.
     */
    public ObjectId getIdAtendiendo() {
        return idAtendiendo;
    }

    /**
     * Método que asigna el ID del trabajador que está atendiendo un ticket.
     *
     * @param idAtendiendo ID a asignar.
     */
    public void setIdAtendiendo(ObjectId idAtendiendo) {
        this.idAtendiendo = idAtendiendo;
    }

    /**
     * Método que devuelve las respuestas asociadas a un ticket.
     *
     * @return Respuestas asociadas a un ticket.
     */
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**
     * Método que asigna las respuestas a un ticket.
     *
     * @param respuestas Respuestas a asignar.
     */
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

}