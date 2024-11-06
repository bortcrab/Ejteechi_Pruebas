package colecciones;

import java.util.Date;

/**
 * Clase que representa un camión. Esta clase contiene los atributos y métodos
 * relacionados con un camión, como su número de unidad, estado del motor,
 * estado de limpieza, estado de las llantas, estado de las luces, prioridad y
 * fecha de último mantenimiento.
 *
 * @author elimo
 */
public class Camion {

    private String numeroUnidad;
    private String estadoMotor;
    private String estadoLimpieza;
    private String estadoLlantas;
    private String estadoLuces;
    private Date fechaUltimoMantenimiento;
    private String nivelPrioridad;

    /**
     * Constructor de la clase Camion. Crea una instancia de la clase Camion.
     */
    public Camion() {
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
     * Establece el número de unidad del camión.
     *
     * @param numeroUnidad El número de unidad que se va a establecer para el
     * camión.
     */
    public void setNumeroUnidad(String numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    /**
     * Obtiene el estado de motor del camión.
     *
     * @return El estado de motor del camión.
     */
    public String getEstadoMotor() {
        return estadoMotor;
    }

    /**
     * Establece el estado del motor del camión.
     *
     * @param estadoMotor El estado del motor que se va a establecer para el
     * camión.
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
     * @param estadoLimpieza El estado de limpieza que se va a establecer para
     * el camión.
     */
    public void setEstadoLimpieza(String estadoLimpieza) {
        this.estadoLimpieza = estadoLimpieza;
    }

    /**
     * Obtiene el estado de llantas del camión.
     *
     * @return El estado de llantas del camión.
     */
    public String getEstadoLlantas() {
        return estadoLlantas;
    }

    /**
     * Establece el estado de las llantas del camión.
     *
     * @param estadoLlantas El estado de las llantas que se va a establecer para
     * el camión.
     */
    public void setEstadoLlantas(String estadoLlantas) {
        this.estadoLlantas = estadoLlantas;
    }

    /**
     * Obtiene el estado de luces del camión.
     *
     * @return El estado de luces del camión.
     */
    public String getEstadoLuces() {
        return estadoLuces;
    }

    /**
     * Establece el estado de las luces del camión.
     *
     * @param estadoLuces El estado de las luces que se va a establecer para el
     * camión.
     */
    public void setEstadoLuces(String estadoLuces) {
        this.estadoLuces = estadoLuces;
    }

    /**
     * Obtiene la fecha de último mantenimiento del camión.
     *
     * @return La fecha de último mantenimiento camión.
     */
    public Date getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    /**
     * Establece la fecha del último mantenimiento del camión.
     *
     * @param fechaUltimoMantenimiento La fecha del último mantenimiento que se
     * va a establecer para el camión.
     */
    public void setFechaUltimoMantenimiento(Date fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    /**
     * Obtiene la prioridad de mantenimiento del camión.
     *
     * @return La prioridad de mantenimiento.
     */
    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    /**
     * Establece el nivel de prioridad del camión.
     *
     * @param nivelPrioridad El nivel de prioridad que se va a establecer para
     * el camión.
     */
    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
}
