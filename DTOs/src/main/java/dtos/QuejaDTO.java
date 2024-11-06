package dtos;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que representa los detalles de una queja. Esta clase contiene los
 * atributos necesarios para almacenar la información asociada con una queja en
 * el sistema.
 *
 * @author elimo
 */
public class QuejaDTO {

    private ObjectId noQueja;
    private String tipoQueja;
    private Date fecha;
    private String descripcion;
    private boolean anonimo;
    private boolean leido;
    private ObjectId idCliente;

    /**
     * Constructor de la clase QuejaDTO. Crea una nueva instancia de QuejaDTO.
     */
    public QuejaDTO() {
    }

    /**
     * Constructor de la clase QuejaDTO que inicializa los atributos con los
     * valores proporcionados.
     *
     * @param fecha La fecha de la queja.
     * @param descripcion La descripción de la queja.
     * @param anonimo Indica si la queja es anónima o no.
     * @param tipoQueja El tipo de la queja.
     */
    public QuejaDTO(Date fecha, String descripcion, boolean anonimo, String tipoQueja) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipoQueja = tipoQueja;
        this.anonimo = anonimo;
    }

    /**
     * Verifica si la queja ha sido marcada como leída.
     *
     * @return true si la queja ha sido marcada como leída, false de lo
     * contrario.
     */
    public boolean isLeido() {
        return leido;
    }

    /**
     * Establece el estado de lectura de la queja.
     *
     * @param leido true si se marca la queja como leída, false de lo contrario.
     */
    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    /**
     * Obtiene el tipo de la queja.
     *
     * @return El tipo de la queja.
     */
    public String getTipoQueja() {
        return tipoQueja;
    }

    /**
     * Establece el tipo de la queja.
     *
     * @param tipoQueja El tipo de la queja a establecer.
     */
    public void setTipoQueja(String tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    /**
     * Obtiene el número de la queja.
     *
     * @return El número de la queja.
     */
    public ObjectId getNoQueja() {
        return noQueja;
    }

    /**
     * Establece el número de la queja.
     *
     * @param noQueja El número de la queja a establecer.
     */
    public void setNoQueja(ObjectId noQueja) {
        this.noQueja = noQueja;
    }

    /**
     * Obtiene la fecha de la queja.
     *
     * @return La fecha de la queja.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la queja.
     *
     * @param fecha La fecha de la queja a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la descripción de la queja.
     *
     * @return La descripción de la queja.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la queja.
     *
     * @param descripcion La descripción de la queja a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Verifica si la queja es anónima.
     *
     * @return true si la queja es anónima, false de lo contrario.
     */
    public boolean isAnonimo() {
        return anonimo;
    }

    /**
     * Establece si la queja es anónima o no.
     *
     * @param anonimo true si se establece la queja como anónima, false de lo
     * contrario.
     */
    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    /**
     * Obtiene el identificador del cliente asociado con la queja.
     *
     * @return El identificador del cliente.
     */
    public ObjectId getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente asociado con la queja.
     *
     * @param idCliente El identificador del cliente a establecer.
     */
    public void setIdCliente(ObjectId idCliente) {
        this.idCliente = idCliente;
    }

}
