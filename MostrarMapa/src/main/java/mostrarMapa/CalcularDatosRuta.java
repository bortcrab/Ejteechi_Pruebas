/*
 * CalcularRuta.java
 */
package mostrarMapa;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;
import com.graphhopper.util.Translation;
import dtos.DatosRutaDTO;
import java.util.List;
import java.util.Locale;

/**
 * Clase para calcular los datos de una ruta dada.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CalcularDatosRuta {

    private final GraphHopper hopper;

    /**
     * Constructor que inicializa el atributo GraphHopper de la clase.
     */
    public CalcularDatosRuta() {
        this.hopper = crearGraphHopper("osm/sonora.pbf");
    }

    /**
     * Método para crear una instancia de GraphHopper.
     *
     * @param ghLoc Ruta (directorio) donde se encuentra el archivo osm con los
     * datos geográficos.
     * @return Una instancia de GraphHopper.
     */
    private GraphHopper crearGraphHopper(String ghLoc) {
        // Se crea una instancia de GH.
        GraphHopper graphHopper = new GraphHopper();
        // Se asignamos la ruta del archivo osm.
        graphHopper.setOSMFile(ghLoc);

        // Especificamos la ruta donde se generará una carpeta con los datos geográficos.
        graphHopper.setGraphHopperLocation("target/routing-graph-cache");

        // Indicamos un perfil para generar las rutas.
        graphHopper.setProfiles(new Profile("car").setVehicle("car").setWeighting("custom").setTurnCosts(false));

        // Esto no sé qué hace, la verdad.
        graphHopper.getCHPreparationHandler().setCHProfiles(new CHProfile("car"));

        // Mandamos a importar los datos geográficos (generar la carpeta).
        graphHopper.importOrLoad();

        // Retornamos la instancia de GH.
        return graphHopper;
    }

    /**
     * Método para calcular los datos de una ruta entre dos puntos dadas su
     * latitud y longitud.
     *
     * @param listaDatosRuta Lista donde se guardarán los datos de la ruta calculada.
     * @param inicioLat Latitud del punto inicial.
     * @param inicioLon Longitud del punto inicial.
     * @param finLat Latitud del punto destino.
     * @param finLon Longitud del punto destino.
     * @return Una lista con los datos de la ruta calculada.
     */
    public List<DatosRutaDTO> calcularDatosRuta(List<DatosRutaDTO> listaDatosRuta, double inicioLat, double inicioLon, double finLat, double finLon) {
        // Indicamos los parámetros de configuración para generar la ruta.
        GHRequest req = new GHRequest(inicioLat, inicioLon, finLat, finLon).setProfile("car").setLocale(Locale.US);
        // Generamos una respuesta.
        GHResponse rsp = hopper.route(req);

        // Indicamos que queremos el camino más corto entre los puntos.
        ResponsePath path = rsp.getBest();

        // Indicamos el lenguaje de la descripción de las vueltas a realizar.
        Translation tr = hopper.getTranslationMap().getWithFallBack(Locale.ENGLISH);
        // Obtenemos una lista de instrucciones a seguir para el recorrido.
        InstructionList il = path.getInstructions();
        // Iteramos sobre la lista de instrucciones.
        for (Instruction instruction : il) {
            /**
             * Añadimos los datos generados a la lista de datos de la ruta:
             * - Distancia
             * - Descripción de las vueltas a dar en el recorrido
             * - Lista de puntos
             */
            listaDatosRuta.add(new DatosRutaDTO(instruction.getDistance(), instruction.getTurnDescription(tr), instruction.getPoints()));
        }
        // Retornamos la lista de datos.
        return listaDatosRuta;
    }
}
