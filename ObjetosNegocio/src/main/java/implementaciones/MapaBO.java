/*
 * MapaBO.java
 */
package implementaciones;

import excepciones.ObjetosNegocioException;
import interfaces.IMapaBO;
import dtos.LineaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import interfaces.IMapaDAO;
import colecciones.Linea;
import colecciones.Mapa;
import excepciones.PersistenciaException;
import colecciones.Ruta;

/**
 * Interfaz que define los métodos para aplicar las reglas de negocio en lo
 * relacionado al mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class MapaBO implements IMapaBO {

    private final IMapaDAO mapaDAO;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public MapaBO() {
        this.mapaDAO = new MapaDAO();
    }

    /**
     * Método que devuelve el mapa a mostrar.
     *
     * @return El mapa encontrado.
     * @throws ObjetosNegocioException si no se encontró ningún mapa.
     */
    @Override
    public MapaDTO obtenerMapa() throws ObjetosNegocioException {
        try {
            // Mandamos a obtener el mapa de la base de datos.
            Mapa mapa = mapaDAO.obtenerMapa();
            // Lo convertimos a DTO.
            MapaDTO mapaDTO = convertirMapa(mapa);
            // Lo devolvemos.
            return mapaDTO;
        } catch (PersistenciaException pe) {
            // Mandamos una excepción si no se encontró ningún mapa.
            throw new ObjetosNegocioException(pe.getMessage());
        }
    }

    /**
     * Método que convierte una entidad de mapa a una instancia de MapaDTO.
     *
     * @param mapa Mapa entidad a convertir.
     * @return El mapa convertido a DTO.
     */
    private MapaDTO convertirMapa(Mapa mapa) {
        // Obtenemos la lista de líneas del mapa.
        List<Linea> lineas = mapa.getLineas();
        // Creamos una lista de líneas DTO.
        List<LineaDTO> lineasDTO = new ArrayList<>();

        for (Linea linea : lineas) {
            // Mandamos a convertir cada línea a DTO y la agregamos a su respectiva lista.
            lineasDTO.add(convertirLinea(linea));
        }

        // Para las coordenadas convertimos una lista de double a un arreglo de double.
        double[] posicionDefault = mapa.getPosicionDefault().stream().mapToDouble(Double::doubleValue).toArray();

        // Hacemos un mapa DTO y le asignamos las líneas y las coordenadas ya convertidas.
        MapaDTO mapaDTO = new MapaDTO(posicionDefault, lineasDTO);
        return mapaDTO; // Lo retornamos.
    }

    /**
     * Método que convierte una entidad de línea a una instancia de LineaDTO.
     *
     * @param linea Línea entidad a convertir.
     * @return La línea convertida a DTO.
     */
    private LineaDTO convertirLinea(Linea linea) {
        // Obtenemos la lista de paradas de la línea.
        List<List<Double>> paradas = linea.getParadas();
        // Creamos un set de Waypoints para almacenar las paradas.
        Set<Waypoint> paradasWaypoint = new HashSet<>();

        for (List<Double> parada : paradas) {
            // Convertimos cada lista de coordenadas de cada parada a un arreglo de coordenadas.
            double[] coordenadas = parada.stream().mapToDouble(Double::doubleValue).toArray();
            // Con cada arreglo creamos un DefaultWaypoint y lo agregamos al set de paradas.
            paradasWaypoint.add(new DefaultWaypoint(new GeoPosition(coordenadas)));
        }

        // Mandamos a convertir la ruta de la línea a DTO.
        RutaDTO rutaDTO = convertirRuta(linea.getRuta());

        int numLinea = linea.getNumero();

        // Hacemos una línea DTO y le asignamos las paradas y su ruta ya convertidas.
        LineaDTO lineaDTO = new LineaDTO(numLinea, paradasWaypoint, rutaDTO);
        return lineaDTO; // La retornamos.
    }

    /**
     * Método que convierte una entidad de ruta a una instancia de RutaDTO.
     *
     * @param ruta Ruta entidad a convertir.
     * @return La ruta convertida a DTO.
     */
    private RutaDTO convertirRuta(Ruta ruta) {
        // Obtenemos los puntos por donde pasa la ruta.
        List<List<Double>> puntos = ruta.getPuntos();
        // Creamos una lista de posiciones geográficas para guardar los puntos.
        List<GeoPosition> puntosGeoPosition = new ArrayList<>();

        for (List<Double> punto : puntos) {
            // Similar a lo de las paradas, convertimos cadar lista de puntos a un arreglo.
            double[] coordenadas = punto.stream().mapToDouble(Double::doubleValue).toArray();
            // Con cada arreglo creamos una nueva GeoPosition y la agregamos a la lista de puntos.
            puntosGeoPosition.add(new GeoPosition(coordenadas));
        }

        // Hacemos una ruta DTO con un arraylist vacío y los puntos ya convertidos.
        RutaDTO rutaDTO = new RutaDTO(new ArrayList<>(), puntosGeoPosition);
        return rutaDTO; // La retornamos.
    }
}
