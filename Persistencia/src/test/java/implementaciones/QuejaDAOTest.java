/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Queja;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author karim
 */
public class QuejaDAOTest {
    private static QuejaDAO quejaDAO;
    public QuejaDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        quejaDAO = new QuejaDAO();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        quejaDAO.borrarQuejas();
    }

    /**
     * Test of insertarQueja method, of class QuejaDAO.
     */
    @Test
    public void testInsertarQuejaNormal() throws Exception {
        Queja queja = quejaDAO.buscarQuejaPorId(new Queja(new ObjectId("672c1501e23c507d2981e304")));
        
        System.out.println(queja);
    }

    /**
     * Test of obtenerQuejasPorTipo method, of class QuejaDAO.
     */
    @Test
    public void testObtenerQuejasPorTipo() throws Exception {
        System.out.println("obtenerQuejasPorTipo");
        String tipo = "";
        QuejaDAO instance = new QuejaDAO();
        List<Queja> expResult = null;
        List<Queja> result = instance.obtenerQuejasPorTipo(tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasLasQuejas method, of class QuejaDAO.
     */
    @Test
    public void testObtenerTodasLasQuejas() throws Exception {
        System.out.println("obtenerTodasLasQuejas");
        QuejaDAO instance = new QuejaDAO();
        List<Queja> expResult = null;
        List<Queja> result = instance.obtenerTodasLasQuejas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerQuejasPorEstadoYAnonimato method, of class QuejaDAO.
     */
    @Test
    public void testObtenerQuejasPorEstadoYAnonimato() throws Exception {
        System.out.println("obtenerQuejasPorEstadoYAnonimato");
        boolean leido = false;
        QuejaDAO instance = new QuejaDAO();
        List<Queja> expResult = null;
        List<Queja> result = instance.obtenerQuejasPorEstadoYAnonimato(leido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmarLectura method, of class QuejaDAO.
     */
    @Test
    public void testConfirmarLectura() throws Exception {
        System.out.println("confirmarLectura");
        Queja queja = null;
        QuejaDAO instance = new QuejaDAO();
        Queja expResult = null;
        Queja result = instance.confirmarLectura(queja);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
