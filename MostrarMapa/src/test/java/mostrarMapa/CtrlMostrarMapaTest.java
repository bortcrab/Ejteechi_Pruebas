/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mostrarMapa;

import dtos.MapaDTO;
import dtos.RutaDTO;
import implementaciones.MapaBO;
import implementaciones.MapaDAO;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilidades.JXMapViewerCustom;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class CtrlMostrarMapaTest {

    private CtrlMostrarMapa ctrl = new CtrlMostrarMapa(new MapaBO(new MapaDAO()));

    @AfterEach
    public void tearDown() throws Exception {
        String rutaCarpeta = "C:\\Users\\Familia\\Documents\\GitHub\\Ejteechi_Pruebas\\MostrarMapa\\target\\routing-graph-cache";
        FileUtils.deleteDirectory(new File(rutaCarpeta));
    }
    
    @Test
    public void cargarMapa_ObtenerMapa_ReturnSuccess() throws Exception {
        // ARRANGE
        MapaDTO resultado;

        // ACT
        resultado = ctrl.cargarMapa(new JXMapViewerCustom());

        // ASSERT
        assertNotNull(resultado);
    }

    /**
     * Test of cargarRuta method, of class CtrlMostrarMapa.
     */
    @Test
    public void cargarRuta_RutaNoEnCache_ReturnFail() throws Exception {
        // ARRANGE
        MapaDTO mapa = ctrl.cargarMapa(new JXMapViewerCustom());
        RutaDTO ruta = mapa.getLineas().getFirst().getRuta();
        Long inicio;
        Long fin;
        Long tiempoTotal;
        Double tiempoEnSegundos;

        // ACT
        inicio = System.nanoTime();
        ctrl.cargarRuta(ruta);
        fin = System.nanoTime();

        tiempoTotal = Math.abs(inicio - fin);
        tiempoEnSegundos = tiempoTotal / 1_000_000_000.0;
        System.out.println("Tiempo en segundos: " + tiempoEnSegundos);

        // ASSERT
        assertTrue(tiempoEnSegundos < 5L);
    }

    @Test
    public void cargarRuta_RutaEnCache_ReturnSuccess() throws Exception {
        // ARRANGE
        MapaDTO mapa = ctrl.cargarMapa(new JXMapViewerCustom());
        RutaDTO ruta = mapa.getLineas().getFirst().getRuta();
        ctrl.cargarRuta(ruta);
        Long inicio;
        Long fin;
        Long tiempoTotal;
        Double tiempoEnSegundos;

        // ACT
        inicio = System.nanoTime();
        ctrl.cargarRuta(ruta);
        fin = System.nanoTime();

        tiempoTotal = Math.abs(inicio - fin);
        tiempoEnSegundos = tiempoTotal / 1_000_000_000.0;
        System.out.println("Tiempo en segundos: " + tiempoEnSegundos);

        // ASSERT
        assertTrue(tiempoEnSegundos < 5);
    }

}
