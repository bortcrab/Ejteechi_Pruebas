/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Respuesta;
import colecciones.Ticket;
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
 * @author Diego Valenzuela Parra
 */
public class TicketDAOTest {

    private static TicketDAO ticketDAO;

    public TicketDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        ticketDAO = new TicketDAO();
    }

    @AfterEach
    public void tearDown() {
        ticketDAO.borrarTickets();
    }

    /**
     * Test of agregarTicket method, of class TicketDAO.
     */
    @Test
    public void testAgregarTicket() {
        System.out.println("agregarTicket");
        Ticket ticket = null;
        TicketDAO instance = new TicketDAO();
        instance.agregarTicket(ticket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTickets method, of class TicketDAO.
     */
    @Test
    public void testObtenerTickets() {
        System.out.println("obtenerTickets");
        ObjectId idUsuario = null;
        TicketDAO instance = new TicketDAO();
        List<Ticket> expResult = null;
        List<Ticket> result = instance.obtenerTickets(idUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTicket method, of class TicketDAO.
     */
    @Test
    public void testObtenerTicket() {
        System.out.println("obtenerTicket");
        ObjectId folio = null;
        TicketDAO instance = new TicketDAO();
        Ticket expResult = null;
        Ticket result = instance.obtenerTicket(folio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRespuesta method, of class TicketDAO.
     */
    @Test
    public void testAgregarRespuesta() {
        System.out.println("agregarRespuesta");
        ObjectId folio = null;
        Respuesta respuesta = null;
        TicketDAO instance = new TicketDAO();
        instance.agregarRespuesta(folio, respuesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosTickets method, of class TicketDAO.
     */
    @Test
    public void testObtenerTodosTickets() {
        System.out.println("obtenerTodosTickets");
        ObjectId idAtendiendo = null;
        TicketDAO instance = new TicketDAO();
        List<Ticket> expResult = null;
        List<Ticket> result = instance.obtenerTodosTickets(idAtendiendo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarTicket method, of class TicketDAO.
     */
    @Test
    public void testActualizarTicket() {
        System.out.println("actualizarTicket");
        Ticket ticket = null;
        TicketDAO instance = new TicketDAO();
        instance.actualizarTicket(ticket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
