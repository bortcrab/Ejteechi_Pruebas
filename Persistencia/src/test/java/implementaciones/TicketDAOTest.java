///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package implementaciones;
//
//import colecciones.Respuesta;
//import colecciones.Ticket;
//import colecciones.Usuario;
//import excepciones.PersistenciaException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.bson.types.ObjectId;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author Diego Valenzuela Parra
// */
//public class TicketDAOTest {
//
//    private static TicketDAO ticketDAO;
//    private static UsuarioDAO usuarioDAO;
//    private static Usuario cliente = new Usuario();
//    private static Usuario empleado = new Usuario();
//
//    public TicketDAOTest() {
//
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        try {
//            ticketDAO = new TicketDAO();
//            usuarioDAO = new UsuarioDAO();
//            cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "diego@gmail.com", "Prueba123", "", "", "cliente");
//            cliente = usuarioDAO.agregarCliente(cliente);
//            empleado = new Usuario("José Karim", "Franco", "Valencia", "9876543210", "karim@gmail.com", "Prueba321", "JKFV040112HSRLR1W4", "JKFV040112GHC", "GERE");
//            empleado = usuarioDAO.agregarEmpleado(empleado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(TicketDAOTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
//        ticketDAO.borrarTickets();
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//        usuarioDAO.borrarUsuarios();
//    }
//
//    /**
//     * Test of agregarTicket method, of class TicketDAO.
//     */
//    @Test
//    public void agregarTicket_TicketValido_ReturnSuccess() {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        int resultado;
//        int esperado = 1;
//
//        // ACT
//        ticketDAO.agregarTicket(ticket);
//
//        // ASSERT
//        resultado = ticketDAO.obtenerTickets(cliente.getId()).size();
//        assertEquals(esperado, resultado);
//    }
//
//    @Test
//    public void obtenerTickets_ClienteConTickets_ReturnSuccess() {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTickets(cliente.getId());
//
//        // ASSERT
//        assertNotNull(resultado);
//        assertEquals(1, resultado.size());
//    }
//
//    @Test
//    public void obtenerTickets_ClienteSinTickets_ReturnSuccess() {
//        // ARRANGE
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTickets(cliente.getId());
//
//        // ASSERT
//        assertEquals(0, resultado.size());
//    }
//
//    @Test
//    public void obtenerTickets_FolioExistente_ReturnSuccess() throws PersistenciaException {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        ObjectId folio = ticketDAO.obtenerTickets(cliente.getId()).getFirst().getId();
//        Ticket resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTicket(folio);
//
//        // ASSERT
//        assertNotNull(resultado);
//    }
//
//    @Test
//    public void obtenerTickets_FolioInexistente_ReturnFail() throws PersistenciaException {
//        // ARRANGE
//        ObjectId folio = new ObjectId();
//        Ticket resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTicket(folio);
//
//        // ASSERT
//        assertNotNull(resultado);
//    }
//
//    @Test
//    public void obtenerTodosTickets_NoHayTickets_ReturnSuccess() {
//        // ARRANGE
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTodosTickets(empleado.getId());
//
//        // ASSERT
//        assertEquals(0, resultado.size());
//    }
//
//    @Test
//    public void obtenerTodosTickets_TicketsSinAtender_ReturnSuccess() {
//        // ARRANGE
//        Ticket ticket1 = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", null, new ArrayList<>());
//        Ticket ticket2 = new Ticket("Ticket de prueba 2", new Date(), "Pendiente", cliente.getId(), "Diego", null, new ArrayList<>());
//        ticketDAO.agregarTicket(ticket1);
//        ticketDAO.agregarTicket(ticket2);
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTodosTickets(empleado.getId());
//
//        // ASSERT
//        assertEquals(2, resultado.size());
//    }
//
//    @Test
//    public void obtenerTodosTickets_EmpleadoAtiendeTodos_ReturnSuccess() {
//        // ARRANGE
//        Ticket ticket1 = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        Ticket ticket2 = new Ticket("Ticket de prueba 2", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket1);
//        ticketDAO.agregarTicket(ticket2);
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTodosTickets(empleado.getId());
//
//        // ASSERT
//        assertEquals(2, resultado.size());
//    }
//
//    @Test
//    public void obtenerTodosTickets_EmpleadoAtiendeAlgunos_ReturnSuccess() {
//        // ARRANGE
//        Ticket ticket1 = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        Ticket ticket2 = new Ticket("Ticket de prueba 2", new Date(), "Pendiente", cliente.getId(), "Diego", new ObjectId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket1);
//        ticketDAO.agregarTicket(ticket2);
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTodosTickets(empleado.getId());
//
//        // ASSERT
//        assertEquals(1, resultado.size());
//    }
//
//    @Test
//    public void obtenerTodosTickets_OtroEmpleadoAtiendeTodos_ReturnSuccess() {
//        // ARRANGE
//        Ticket ticket1 = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", new ObjectId(), new ArrayList<>());
//        Ticket ticket2 = new Ticket("Ticket de prueba 2", new Date(), "Pendiente", cliente.getId(), "Diego", new ObjectId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket1);
//        ticketDAO.agregarTicket(ticket2);
//        List<Ticket> resultado;
//
//        // ACT
//        resultado = ticketDAO.obtenerTodosTickets(empleado.getId());
//
//        // ASSERT
//        assertEquals(0, resultado.size());
//    }
//
//    @Test
//    public void agregarRespuesta_ClienteFolioValido_ReturnSuccess() throws PersistenciaException {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        ObjectId folio = ticketDAO.obtenerTickets(cliente.getId()).getFirst().getId();
//        Respuesta respuesta = new Respuesta("Respuesta de prueba :D", new Date(), cliente.getNombres(), cliente.getId());
//        List<Respuesta> resultado;
//
//        // ACT
//        ticketDAO.agregarRespuesta(folio, respuesta);
//
//        // ASSERT
//        resultado = ticketDAO.obtenerTicket(folio).getRespuestas();
//        assertEquals(1, resultado.size());
//    }
//
//    @Test
//    public void agregarRespuesta_EmpleadoFolioValido_ReturnSuccess() throws PersistenciaException {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        ObjectId folio = ticketDAO.obtenerTickets(cliente.getId()).getFirst().getId();
//        Respuesta respuesta = new Respuesta("Respuesta de prueba :D", new Date(), empleado.getNombres(), empleado.getId());
//        List<Respuesta> resultado;
//
//        // ACT
//        ticketDAO.agregarRespuesta(folio, respuesta);
//
//        // ASSERT
//        resultado = ticketDAO.obtenerTicket(folio).getRespuestas();
//        assertEquals(1, resultado.size());
//    }
//
//    @Test
//    public void agregarRespuesta_FolioInvalido_ReturnFail() throws PersistenciaException {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        ObjectId folio = new ObjectId();
//        Respuesta respuesta = new Respuesta("Respuesta de prueba :D", new Date(), empleado.getNombres(), empleado.getId());
//        List<Respuesta> resultado;
//
//        // ACT
//        ticketDAO.agregarRespuesta(folio, respuesta);
//
//        // ASSERT
//        resultado = ticketDAO.obtenerTicket(folio).getRespuestas();
//        assertEquals(0, resultado.size());
//    }
//
//    @Test
//    public void actualizarTicket_FolioValidoResuelto_ReturnSuccess() throws PersistenciaException {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        ObjectId folio = ticketDAO.obtenerTickets(cliente.getId()).getFirst().getId();
//        ticket = ticketDAO.obtenerTicket(folio);
//        ticket.setEstado("Resuelto");
//        String esperado = "Resuelto";
//        Ticket resultado;
//
//        // ACT
//        ticketDAO.actualizarTicket(ticket);
//
//        // ASSERT
//        resultado = ticketDAO.obtenerTicket(folio);
//        assertEquals(esperado, resultado.getEstado());
//    }
//
//    @Test
//    public void actualizarTicket_FolioValidoPendiente_ReturnSuccess() throws PersistenciaException {
//        // ARRANGE
//        Ticket ticket = new Ticket("Ticket de prueba 1", new Date(), "Resuelto", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>());
//        ticketDAO.agregarTicket(ticket);
//        ObjectId folio = ticketDAO.obtenerTickets(cliente.getId()).getFirst().getId();
//        ticket = ticketDAO.obtenerTicket(folio);
//        ticket.setEstado("Pendiente");
//        String esperado = "Pendiente";
//        Ticket resultado;
//
//        // ACT
//        ticketDAO.actualizarTicket(ticket);
//
//        // ASSERT
//        resultado = ticketDAO.obtenerTicket(folio);
//        assertEquals(esperado, resultado.getEstado());
//    }
//
//}
