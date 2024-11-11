/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Ticket;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

}
