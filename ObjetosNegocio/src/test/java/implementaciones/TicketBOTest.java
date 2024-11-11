/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Respuesta;
import colecciones.Ticket;
import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;
import excepciones.PersistenciaException;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class TicketBOTest {

    private static UsuarioDTO cliente = new UsuarioDTO();
    private static UsuarioDTO empleado = new UsuarioDTO();

    @Mock
    private ITicketDAO ticketDAO;

    @InjectMocks
    private TicketBO ticketBO;

    @BeforeAll
    public static void setUpClass() {
        cliente = new UsuarioDTO(new ObjectId(), "Diego", "Valenzuela", "Parra", "", "", "", "diego@gmail.com", "Prueba123", "cliente");
        empleado = new UsuarioDTO(new ObjectId(), "José Karim", "Franco", "Valencia", "9876543210", "JKFV040112HSRLR1W4", "JKFV040112GHC", "karim@gmail.com", "Prueba321", "GERE");
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void agregarTicket_TicketValido_ReturnSuccess() {
        // ARRANGE
        TicketDTO ticket = new TicketDTO("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), cliente.getNombres(), new ArrayList<>());

        // ACT
        ticketBO.agregarTicket(ticket);

        // ASSERT
        verify(ticketDAO, times(1)).agregarTicket(any(Ticket.class));
    }

    @Test
    public void obtenerTickets_ClienteValido_ReturnSuccess() throws Exception {
        // ARRANGE
        Ticket ticketEnt = new Ticket("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), cliente.getNombres(), empleado.getId(), new ArrayList<>());
        ticketEnt.setId(new ObjectId());
        List<Ticket> esperado = new ArrayList<>() {
            {
                add(ticketEnt);
            }
        };
        when(ticketDAO.obtenerTickets(cliente.getId())).thenReturn(esperado);
        List<TicketDTO> resultado;

        // ACT
        resultado = ticketBO.obtenerTickets(cliente);

        // ASSERT
        assertNotNull(resultado);
        assertEquals(esperado.getFirst().getContenido(), resultado.getFirst().getContenido());
        assertEquals(esperado.getFirst().getIdUsuario(), resultado.getFirst().getIdUsuario());
        assertEquals(esperado.getFirst().getIdAtendiendo(), resultado.getFirst().getIdAtendiendo());
        assertEquals(esperado.getFirst().getNombreUsuario(), resultado.getFirst().getNombreUsuario());
    }

    @Test
    public void obtenerTicket_FolioValido_ReturnSuccess() throws Exception {
        // ARRANGE
        Ticket ticketEnt = new Ticket("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), cliente.getNombres(), empleado.getId(), new ArrayList<>());
        ticketEnt.setId(new ObjectId());
        Ticket esperado = ticketEnt;
        when(ticketDAO.obtenerTicket(ticketEnt.getId())).thenReturn(esperado);
        TicketDTO resultado;

        // ACT
        resultado = ticketBO.obtenerTicket(ticketEnt.getId());

        // ASSERT
        assertNotNull(resultado);
        assertEquals(esperado.getContenido(), resultado.getContenido());
        assertEquals(esperado.getIdUsuario(), resultado.getIdUsuario());
        assertEquals(esperado.getIdAtendiendo(), resultado.getIdAtendiendo());
        assertEquals(esperado.getNombreUsuario(), resultado.getNombreUsuario());
    }

    @Test
    public void obtenerTicket_FolioInvalido_ThrowException() throws Exception {
        // ARRANGE
        Ticket ticketEnt = new Ticket("Ticket de prueba", new Date(), "Pendiente", cliente.getId(), cliente.getNombres(), empleado.getId(), new ArrayList<>());
        ticketEnt.setId(new ObjectId());
        Ticket esperado = ticketEnt;
        when(ticketDAO.obtenerTicket(ticketEnt.getId())).thenReturn(null);
        TicketDTO resultado;

        // ACT y ASSERT
        ObjetosNegocioException excepcion = assertThrows(ObjetosNegocioException.class, () -> {
            ticketBO.obtenerTicket(ticketEnt.getId());
        });
    }

    @Test
    public void enviarRespuesta_FolioValido_ReturnSuccess() throws Exception {
        // ARRANGE
        ObjectId folio = new ObjectId();
        Respuesta respuesta = new Respuesta("Respuesta de prueba :D", new Date(), cliente.getNombres(), cliente.getId());
        Ticket esperado = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), "Diego", empleado.getId(), new ArrayList<>(Arrays.asList(respuesta)));
        esperado.setId(folio);
        when(ticketDAO.obtenerTicket(folio)).thenReturn(esperado);
        RespuestaDTO respuestaDTO = new RespuestaDTO("Respuesta de prueba :D", new Date(), cliente.getNombres(), cliente.getId());
        RespuestaDTO resultado;

        // ACT
        resultado = ticketBO.enviarRespuesta(folio, respuestaDTO).getRespuestas().getFirst();

        // ASSERT
        assertNotNull(resultado);
        assertEquals(respuesta.getContenido(), resultado.getContenido());
        assertEquals(respuesta.getEmisor(), resultado.getEmisor());
        assertEquals(respuesta.getIdEmisor(), resultado.getIdEmisor());
    }

    @Test
    public void enviarRespuesta_FolioInvalido_ThrowException() throws Exception {
        // ARRANGE
        ObjectId folio = new ObjectId();
        RespuestaDTO respuestaDTO = new RespuestaDTO("Respuesta de prueba :D", new Date(), cliente.getNombres(), cliente.getId());
        when(ticketDAO.obtenerTicket(folio)).thenReturn(null);
        RespuestaDTO resultado;

        // ACT y ASSERT
        ObjetosNegocioException excepcion = assertThrows(ObjetosNegocioException.class, () -> {
            ticketBO.enviarRespuesta(folio, respuestaDTO);
        });
    }

    @Test
    public void enviarRespuestaTrabajador_FolioValido_ReturnSuccess() throws Exception {
        // ARRANGE
        ObjectId folio = new ObjectId();
        Respuesta respuesta = new Respuesta("Respuesta de prueba :D", new Date(), empleado.getNombres(), empleado.getId());
        Ticket esperado = new Ticket("Ticket de prueba 1", new Date(), "Pendiente", cliente.getId(), cliente.getNombres(), empleado.getId(), new ArrayList<>(Arrays.asList(respuesta)));
        esperado.setId(folio);
        when(ticketDAO.obtenerTicket(folio)).thenReturn(esperado);
        RespuestaDTO respuestaDTO = new RespuestaDTO("Respuesta de prueba :D", new Date(), empleado.getNombres(), empleado.getId());
        RespuestaDTO resultado;

        // ACT
        resultado = ticketBO.enviarRespuesta(folio, respuestaDTO).getRespuestas().getFirst();

        // ASSERT
        assertNotNull(resultado);
        assertEquals(respuesta.getContenido(), resultado.getContenido());
        assertEquals(respuesta.getEmisor(), resultado.getEmisor());
        assertEquals(respuesta.getIdEmisor(), resultado.getIdEmisor());
    }

    @Test
    public void enviarRespuestaTrabajador_FolioInvalido_ThrowException() throws Exception {
        // ARRANGE
        ObjectId folio = new ObjectId();
        doThrow(PersistenciaException.class).when(ticketDAO).agregarRespuesta(folio, new Respuesta());
        RespuestaDTO respuestaDTO = new RespuestaDTO("Respuesta de prueba :D", new Date(), empleado.getNombres(), empleado.getId());

        // ACT y ASSERT
        ObjetosNegocioException excepcion = assertThrows(ObjetosNegocioException.class, () -> {
            ticketBO.enviarRespuestaTrabajador(folio, respuestaDTO, empleado.getId());
        });
    }

}
