/*
 * CtrlMostrarMapa.java
 */
package mostrarMapa;

import excepciones.MostrarMapaException;
import dtos.DatosRutaDTO;
import utilidades.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;
import interfaces.IMapaBO;
import implementaciones.MapaBO;
import excepciones.ObjetosNegocioException;
import obtenerImagenesMapa.FacadeObtenerImagenesMapa;
import org.jxmapviewer.viewer.GeoPosition;
import obtenerImagenesMapa.IObtenerImagenesMapa;

/**
 * Clase control para mostrar el mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlMostrarMapa {

    private final IObtenerImagenesMapa obtenerImagenesMapa;
    private final IMapaBO mapaBO;

    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public CtrlMostrarMapa() {
        obtenerImagenesMapa = new FacadeObtenerImagenesMapa();
        mapaBO = new MapaBO();
    }

    /**
     * Método para cargar y devolver el mapa a mostrar.
     *
     * @param pnlMapa Panel donde se mostrará el mapa.
     * @return El mapa encontrado.
     * @throws MostrarMapaException si no se encontró ningún mapa.
     */
    public MapaDTO cargarMapa(JXMapViewerCustom pnlMapa) throws MostrarMapaException {
        try {
            // Mandamos a obtener el mapa.
            MapaDTO mapaDTO = mapaBO.obtenerMapa();
            // Mandamos a obtener las imágenes del mapa.
            obtenerImagenesMapa.obtenerImagenesMapa(pnlMapa, mapaDTO.getPosicionDefault());
            // Retornamos el mapa.
            return mapaDTO;
        } catch (ObjetosNegocioException one) {
            // Mandamos una excepción si no se encontró ningún mapa.
            throw new MostrarMapaException(one.getMessage());
        }
    }

    /**
     * Método para cargar los datos de la ruta a mostrar.
     *
     * @param ruta Ruta que se quiere mostrar.
     * @return Lista con los datos de la ruta.
     */
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta) {
        // Creamos una instancia de la clase para calcular rutas.
        CalcularDatosRuta calcularDatosRuta = new CalcularDatosRuta();

        // Obtenemos la lista de puntos por donde pasa la ruta.
        List<GeoPosition> puntos = ruta.getPuntos();

        // Obtenemos la lista de datos de la ruta.
        List<DatosRutaDTO> listaDatosRuta = ruta.getListaDatosRuta();

        // Iteramos sobre la lista de puntos.
        for (int i = 0; i < (puntos.size()); i++) {
            // Obtenemos la latitud y longitud de cada punto de inicio.
            double inicioLat = puntos.get(i).getLatitude();
            double inicioLon = puntos.get(i).getLongitude();
            // Si NO es el último punto de la lista.
            if (i < (puntos.size() - 1)) {
                // Obtenemos la latitud y longitud del punto siguiente de la ruta.
                double finLat = puntos.get(i + 1).getLatitude();
                double finLon = puntos.get(i + 1).getLongitude();
                /**
                 * Mandamos a calcular los datos de la ruta entre los dos puntos
                 * y los guardamos en la lista de datos de la ruta.
                 */
                listaDatosRuta = calcularDatosRuta.calcularDatosRuta(listaDatosRuta, inicioLat, inicioLon, finLat, finLon);
            } else {
                /**
                 * Si el punto a evaluar es el último de la ruta, indicamos que
                 * el siguiente punto es el primero de la ruta.
                 */
                listaDatosRuta = calcularDatosRuta.calcularDatosRuta(listaDatosRuta, inicioLat, inicioLon, puntos.get(0).getLatitude(), puntos.get(0).getLongitude());
            }
        }
        return listaDatosRuta;
    }
}
