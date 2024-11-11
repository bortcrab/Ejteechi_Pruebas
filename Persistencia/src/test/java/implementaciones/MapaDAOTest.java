/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Mapa;
import excepciones.PersistenciaException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class MapaDAOTest {

    private static MapaDAO mapaDAO;

    @BeforeAll
    public static void setUpClass() {
        mapaDAO = new MapaDAO();
    }

    @Test
    public void obtenerMapa_MapaExistente_ReturnSuscess() throws Exception {
        // ARRANGE
        Mapa resultado;

        // ACT
        resultado = mapaDAO.obtenerMapa();

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerMapa_MapaInexistente_ReturnSuccess() throws Exception {
        // ARRANGE
        boolean excepcion = false;

        // ACT
        try {
            mapaDAO.obtenerMapa();
        } catch (PersistenciaException pe) {
            excepcion = true;
        }

        // ASSERT
        assertTrue(excepcion);
    }

}
