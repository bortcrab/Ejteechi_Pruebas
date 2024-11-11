///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package implementaciones;
//
//import colecciones.Linea;
//import colecciones.Mapa;
//import colecciones.Ruta;
//import dtos.LineaDTO;
//import dtos.MapaDTO;
//import dtos.RutaDTO;
//import interfaces.IMapaDAO;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
//import org.mockito.MockitoAnnotations;
//
///**
// *
// * @author Diego Valenzuela Parra
// */
//public class MapaBOTest {
//
//    @Mock
//    private IMapaDAO mapaDAO;
//
//    @InjectMocks
//    private MapaBO mapaBO;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void obtenerMapa_MapaExistente_ReturnSuccess() throws Exception {
//        // ARRANGE
//        // Línea 1
//        List<List<Double>> paradasLinea1 = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48633, -109.96896)
//        );
//
//        List<List<Double>> puntosRutaLinea1 = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48627, -109.96098)
//        );
//
//        Ruta ruta1 = new Ruta(puntosRutaLinea1);
//        Linea linea1 = new Linea(1, paradasLinea1, ruta1);
//
//        // Línea 2
//        List<List<Double>> paradasLinea2 = Arrays.asList(
//                Arrays.asList(27.48265, -109.94684),
//                Arrays.asList(27.48278, -109.94365)
//        );
//
//        List<List<Double>> puntosRutaLinea2 = Arrays.asList(
//                Arrays.asList(27.48265, -109.94684),
//                Arrays.asList(27.48278, -109.94365)
//        );
//
//        Ruta ruta2 = new Ruta(puntosRutaLinea2);
//        Linea linea2 = new Linea(2, paradasLinea2, ruta2);
//
//        // Crear el mapa
//        List<Linea> lineas = Arrays.asList(linea1, linea2);
//
//        List<Double> posicion = new ArrayList<>(Arrays.asList(27.4845523, -109.9237108));
//        Mapa esperado = new Mapa(posicion, lineas);
//
//        when(mapaDAO.obtenerMapa()).thenReturn(esperado);
//        MapaDTO resultado;
//
//        // ACT
//        resultado = mapaBO.obtenerMapa();
//
//        // ASSERT
//        assertNotNull(resultado);
//        assertEquals(esperado.getPosicionDefault().getFirst(), resultado.getPosicionDefault()[0]);
//        assertEquals(esperado.getLineas().size(), resultado.getLineas().size());
//    }
//
//    @Test
//    public void obtenerMapa_MapaInexistente_ReturnFail() throws Exception {
//        // ARRANGE
//        when(mapaDAO.obtenerMapa()).thenReturn(null);
//        MapaDTO resultado;
//
//        // ACT
//        resultado = mapaBO.obtenerMapa();
//
//        // ASSERT
//        assertNotNull(resultado);
//    }
//
//    @Test
//    public void convertirMapa_MapaValido_ReturnSuccess() {
//        // ARRANGE
//        // Línea 1
//        List<List<Double>> paradasLinea1 = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48633, -109.96896)
//        );
//
//        List<List<Double>> puntosRutaLinea1 = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48627, -109.96098)
//        );
//
//        Ruta ruta1 = new Ruta(puntosRutaLinea1);
//        Linea linea1 = new Linea(1, paradasLinea1, ruta1);
//
//        // Línea 2
//        List<List<Double>> paradasLinea2 = Arrays.asList(
//                Arrays.asList(27.48265, -109.94684),
//                Arrays.asList(27.48278, -109.94365)
//        );
//
//        List<List<Double>> puntosRutaLinea2 = Arrays.asList(
//                Arrays.asList(27.48265, -109.94684),
//                Arrays.asList(27.48278, -109.94365)
//        );
//
//        Ruta ruta2 = new Ruta(puntosRutaLinea2);
//        Linea linea2 = new Linea(2, paradasLinea2, ruta2);
//
//        // Crear el mapa
//        List<Linea> lineas = Arrays.asList(linea1, linea2);
//
//        List<Double> posicion = new ArrayList<>(Arrays.asList(27.4845523, -109.9237108));
//        Mapa mapa = new Mapa(posicion, lineas);
//
//        MapaDTO resultado;
//
//        // ACT
//        resultado = mapaBO.convertirMapa(mapa);
//
//        // ASSERT
//        assertNotNull(resultado);
//        assertEquals(mapa.getLineas().size(), resultado.getLineas().size());
//    }
//
//    @Test
//    public void convertirLinea_MapaValido_ReturnSuccess() {
//        // ARRANGE
//        // Línea 1
//        List<List<Double>> paradasLinea = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48633, -109.96896)
//        );
//
//        List<List<Double>> puntosRutaLinea = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48627, -109.96098)
//        );
//
//        Ruta ruta = new Ruta(puntosRutaLinea);
//        Linea linea = new Linea(1, paradasLinea, ruta);
//        LineaDTO resultado;
//
//        // ACT
//        resultado = mapaBO.convertirLinea(linea);
//
//        // ASSERT
//        assertNotNull(resultado);
//        assertEquals(linea.getNumero(), resultado.getNumero());
//        assertEquals(linea.getParadas().size(), resultado.getParadas().size());
//    }
//
//    @Test
//    public void convertirRuta_MapaValido_ReturnSuccess() {
//        // ARRANGE
//        List<List<Double>> puntosRutaLinea = Arrays.asList(
//                Arrays.asList(27.48270, -109.95938),
//                Arrays.asList(27.48627, -109.96098)
//        );
//
//        Ruta ruta = new Ruta(puntosRutaLinea);
//        RutaDTO resultado;
//
//        // ACT
//        resultado = mapaBO.convertirRuta(ruta);
//
//        // ASSERT
//        assertNotNull(resultado);
//        assertEquals(ruta.getPuntos().size(), resultado.getPuntos().size());
//    }
//
//}
