package dtos;

import java.util.Date;

/**
 * Clase que representa los detalles de un camión. Esta clase contiene los
 * atributos necesarios para almacenar la información asociada con un camión en
 * el sistema.
 *
 * @author elimo
 */
public class CamionDTO {

    private String numeroUnidad;
    private String estadoMotor;
    private String estadoLimpieza;
    private String estadoLlantas;
    private String estadoLuces;
    private Date fechaUltimoMantenimiento;
    private String nivelPrioridad;

    /**
     * Constructor de la clase CamionDTO. Crea una nueva instancia de CamionDTO.
     */
    public CamionDTO() {
    }

    /**
     * Constructor de la clase CamionDTO que inicializa los atributos con los
     * valores proporcionados.
     *
     * @param numeroUnidad El número de unidad del camión.
     * @param estadoMotor El estado del motor del camión.
     * @param estadoLimpieza El estado de limpieza del camión.
     * @param estadoLlantas El estado de las llantas del camión.
     * @param estadoLuces El estado de las luces del camión.
     * @param nivelPrioridad El nivel de prioridad del camión.
     * @param fechaUltimoMantenimiento La fecha del último mantenimiento del
     * camión.
     */
    public CamionDTO(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces, String nivelPrioridad, Date fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.numeroUnidad = numeroUnidad;
        this.estadoMotor = estadoMotor;
        this.estadoLimpieza = estadoLimpieza;
        this.estadoLlantas = estadoLlantas;
        this.estadoLuces = estadoLuces;
        this.nivelPrioridad = nivelPrioridad;
    }

    /**
     * Obtiene el número de unidad del camión.
     *
     * @return El número de unidad del camión.
     */
    public String getNumeroUnidad() {
        return numeroUnidad;
    }

    /**
     * Obtiene la fecha del último mantenimiento del camión.
     *
     * @return La fecha del último mantenimiento del camión.
     */
    public Date getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    /**
     * Establece la fecha del último mantenimiento del camión.
     *
     * @param fechaUltimoMantenimiento La fecha del último mantenimiento del
     * camión a establecer.
     */
    public void setFechaUltimoMantenimiento(Date fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    /**
     * Establece el número de unidad del camión.
     *
     * @param numeroUnidad El número de unidad del camión a establecer.
     */
    public void setNumeroUnidad(String numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    /**
     * Obtiene el estado del motor del camión.
     *
     * @return El estado del motor del camión.
     */
    public String getEstadoMotor() {
        return estadoMotor;
    }

    /**
     * Establece el estado del motor del camión.
     *
     * @param estadoMotor El estado del motor del camión a establecer.
     */
    public void setEstadoMotor(String estadoMotor) {
        this.estadoMotor = estadoMotor;
    }

    /**
     * Obtiene el estado de limpieza del camión.
     *
     * @return El estado de limpieza del camión.
     */
    public String getEstadoLimpieza() {
        return estadoLimpieza;
    }

    /**
     * Establece el estado de limpieza del camión.
     *
     * @param estadoLimpieza El estado de limpieza del camión a establecer.
     */
    public void setEstadoLimpieza(String estadoLimpieza) {
        this.estadoLimpieza = estadoLimpieza;
    }

    /**
     * Obtiene el estado de las llantas del camión.
     *
     * @return El estado de las llantas del camión.
     */
    public String getEstadoLlantas() {
        return estadoLlantas;
    }

    /**
     * Establece el estado de las llantas del camión.
     *
     * @param estadoLlantas El estado de las llantas del camión a establecer.
     */
    public void setEstadoLlantas(String estadoLlantas) {
        this.estadoLlantas = estadoLlantas;
    }

    /**
     * Obtiene el estado de las luces del camión.
     *
     * @return El estado de las luces del camión.
     */
    public String getEstadoLuces() {
        return estadoLuces;
    }

    /**
     * Establece el estado de las luces del camión.
     *
     * @param estadoLuces El estado de las luces del camión a establecer.
     */
    public void setEstadoLuces(String estadoLuces) {
        this.estadoLuces = estadoLuces;
    }

    /**
     * Obtiene el nivel de prioridad del camión.
     *
     * @return El nivel de prioridad del camión.
     */
    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    /**
     * Establece el nivel de prioridad del camión.
     *
     * @param nivelPrioridad El nivel de prioridad del camión a establecer.
     */
    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
}
