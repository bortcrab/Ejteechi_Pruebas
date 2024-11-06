package programarMantenimiento;

import colecciones.Camion;
import dtos.CamionDTO;
import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;

/**
 * Implementación de la interfaz IProgramarMantenimiento que proporciona una
 * fachada para programar mantenimientos de camiones. Esta clase actúa como una
 * fachada para proporcionar métodos para programar y gestionar mantenimientos
 * de camiones en el sistema.
 *
 * @author elimo
 */
public class FacadeProgramarMantenimiento implements IProgramarMantenimiento {

    private final CtrlProgramarMantenimiento ctrlProgramarMantenimiento;

    /**
     * Constructor de la clase FacadeProgramarMantenimiento. Inicializa un nuevo
     * objeto FacadeProgramarMantenimiento con una instancia de
     * CtrlProgramarMantenimiento.
     */
    public FacadeProgramarMantenimiento() {
        this.ctrlProgramarMantenimiento = new CtrlProgramarMantenimiento();
    }

    /**
     * Obtiene un camión por su número de unidad.
     *
     * @param numeroUnidad El número de unidad del camión a obtener.
     * @return El objeto CamionDTO correspondiente al número de unidad
     * especificado.
     * @throws ProgramarMantenimientoException Si ocurre un error al obtener el
     * camión por su número de unidad.
     */
    @Override
    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ProgramarMantenimientoException {
        return ctrlProgramarMantenimiento.obtenerPorNumeroUnidad(numeroUnidad);
    }

    /**
     * Actualiza el estado de un camión.
     *
     * @param numeroUnidad El número de unidad del camión a actualizar.
     * @param estadoMotor El nuevo estado del motor del camión.
     * @param estadoLimpieza El nuevo estado de limpieza del camión.
     * @param estadoLlantas El nuevo estado de las llantas del camión.
     * @param estadoLuces El nuevo estado de las luces del camión.
     * @return El objeto Camion actualizado.
     * @throws ProgramarMantenimientoException Si ocurre un error al actualizar
     * el estado del camión.
     */
    @Override
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ProgramarMantenimientoException {
        return ctrlProgramarMantenimiento.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
    }

    /**
     * Actualiza la prioridad y la fecha de mantenimiento de un camión.
     *
     * @param numeroUnidad El número de unidad del camión a actualizar.
     * @param nuevaPrioridad La nueva prioridad del camión.
     * @param nuevaFechaMantenimiento La nueva fecha de mantenimiento del
     * camión.
     * @return El objeto CamionDTO actualizado.
     * @throws ProgramarMantenimientoException Si ocurre un error al actualizar
     * la prioridad y la fecha de mantenimiento del camión.
     */
    @Override
    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ProgramarMantenimientoException {
        return ctrlProgramarMantenimiento.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
    }

    /**
     * Actualiza una serie de etiquetas con sus respectivos estados y colores.
     *
     * @param label La primera etiqueta a actualizar.
     * @param estado El estado para la primera etiqueta.
     * @param label1 La segunda etiqueta a actualizar.
     * @param estado1 El estado para la segunda etiqueta.
     * @param label2 La tercera etiqueta a actualizar.
     * @param estado2 El estado para la tercera etiqueta.
     * @param label3 La cuarta etiqueta a actualizar.
     * @param estado3 El estado para la cuarta etiqueta.
     */
    public static void actualizarLabelConEstado(JLabel label, String estado, JLabel label1, String estado1, JLabel label2, String estado2, JLabel label3, String estado3) {
        label.setText(estado);
        label1.setText(estado1);
        label2.setText(estado2);
        label3.setText(estado3);
        switch (estado.toLowerCase()) {
            case "bueno":
                label.setForeground(Color.GREEN);
                break;
            case "medio":
                label.setForeground(Color.YELLOW);
                break;
            case "malo":
                label.setForeground(Color.RED);
                break;
            default:
                // Dejar el color por defecto
                label.setForeground(null);
        }
        switch (estado1.toLowerCase()) {
            case "bueno":
                label1.setForeground(Color.GREEN);
                break;
            case "medio":
                label1.setForeground(Color.YELLOW);
                break;
            case "malo":
                label1.setForeground(Color.RED);
                break;
            default:
                // Dejar el color por defecto
                label1.setForeground(null);
        }
        switch (estado.toLowerCase()) {
            case "bueno":
                label2.setForeground(Color.GREEN);
                break;
            case "medio":
                label2.setForeground(Color.YELLOW);
                break;
            case "malo":
                label2.setForeground(Color.RED);
                break;
            default:
                // Dejar el color por defecto
                label2.setForeground(null);
        }
        switch (estado.toLowerCase()) {
            case "bueno":
                label3.setForeground(Color.GREEN);
                break;
            case "medio":
                label3.setForeground(Color.YELLOW);
                break;
            case "malo":
                label3.setForeground(Color.RED);
                break;
            default:
                // Dejar el color por defecto
                label3.setForeground(null);
        }
    }

    /**
     * Actualiza una etiqueta de prioridad con el nivel de prioridad
     * proporcionado.
     *
     * @param nivelPrioridad El nivel de prioridad a mostrar en la etiqueta.
     * @param lblMantenimiento La etiqueta de prioridad a actualizar.
     */
    public static void updatePrioridadLabel(String nivelPrioridad, JLabel lblMantenimiento) {
        lblMantenimiento.setText(nivelPrioridad);
        switch (nivelPrioridad.toLowerCase()) {
            case "alto":
                lblMantenimiento.setForeground(Color.RED);
                break;
            case "medio":
                lblMantenimiento.setForeground(Color.YELLOW);
                break;
            case "bajo":
                lblMantenimiento.setForeground(Color.GREEN);
                break;
            default:
                // Dejar el color por defecto
                lblMantenimiento.setForeground(null);
        }
    }

    /**
     * Actualiza el estado de una etiqueta entre "BUENO", "MEDIO" y "MALO".
     *
     * @param label La etiqueta cuyo estado se actualizará.
     * @return El nuevo estado de la etiqueta ("bueno", "medio" o "malo").
     */
    public static String actualizarLabelEstado(JLabel label) {
        String textoActual = label.getText();

        switch (textoActual.toLowerCase()) {
            case "bueno":
                label.setText("MEDIO");
                label.setForeground(Color.YELLOW);
                return "medio";
            case "medio":
                label.setText("MALO");
                label.setForeground(Color.RED);
                return "malo";
            case "malo":
                label.setText("BUENO");
                label.setForeground(Color.GREEN);
                return "bueno";
            default:
                // No hacer nada si el texto no coincide con ninguno de los casos anteriores
                return null;
        }
    }

    /**
     * Calcula la prioridad de mantenimiento para un camión basándose en el
     * estado de sus componentes.
     *
     * @param camion El objeto CamionDTO para el cual se calculará la prioridad.
     * @return La prioridad de mantenimiento del camión ("ALTO", "MEDIO" o
     * "BAJO").
     */
    public static String calcularPrioridad(CamionDTO camion) {
        int contadorMalo = 0;
        int contadorMedio = -2;
        if (camion.getEstadoMotor().equals("MEDIO")) {
            contadorMedio++;
        }

        if (camion.getEstadoLuces().equals("MEDIO")) {
            contadorMedio++;
        }

        if (camion.getEstadoLlantas().equals("MEDIO")) {
            contadorMedio++;
        }

        if (camion.getEstadoLimpieza().equals("MEDIO")) {
            contadorMedio++;
        }
        if (camion.getEstadoMotor().equals("MALO")) {
            contadorMalo++;
        }

        if (camion.getEstadoLuces().equals("MALO")) {
            contadorMalo++;
        }

        if (camion.getEstadoLlantas().equals("MALO")) {
            contadorMalo++;
        }

        if (camion.getEstadoLimpieza().equals("MALO")) {
            contadorMalo++;
        }

        String nuevaPrioridad;
        if (contadorMalo > 2) {
            nuevaPrioridad = "ALTO";
        } else if (contadorMalo == 1 || contadorMalo == 2 || contadorMedio == 1 || contadorMedio == 2) {
            nuevaPrioridad = "MEDIO";
        } else {
            nuevaPrioridad = "BAJO";
        }

        return nuevaPrioridad;
    }

}
