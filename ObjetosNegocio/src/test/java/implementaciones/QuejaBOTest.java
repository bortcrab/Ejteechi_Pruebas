/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Queja;
import dtos.QuejaDTO;
import interfaces.IQuejaDAO;
import interfaces.IUsuarioDAO;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import utilidades.Encriptador;

/**
 *
 * @author karim
 */
@ExtendWith(MockitoExtension.class)
public class QuejaBOTest {
    
    public QuejaBOTest() {
    }
    private Date fechaPlantilla1 = new Date(1732406400000L);//Fecha con el 24 de noviembre de 2024
    private Date fechaPlantilla2 = new Date(1730419200000L);//Fecha con el 01 de noviembre de 2024
    @Mock
    private IQuejaDAO quejaDAO;


    @InjectMocks
    private QuejaBO quejaBO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of enviarQueja method, of class QuejaBO.
     */

    @Test
    public void testEnviarQuejaExito() throws Exception {
        // Arrange
        QuejaDTO quejaDTO = new QuejaDTO("Nueva queja");
        Queja queja = new Queja("Nueva queja");

        // Configura el mock para verificar la llamada sin devolver nada (void method)
        doNothing().when(quejaDAO).insertarQueja(queja);

        // Act
        QuejaDTO resultado = quejaBO.enviarQueja(quejaDTO);

        // Assert
        assertEquals(quejaDTO, resultado); // Verifica que el DTO retornado es el mismo que el de entrada
        verify(quejaDAO, times(1)).insertarQueja(any(Queja.class)); // Verifica que insertarQueja fue llamado
    }

    /**
     * Test of convertirQuejaToDTO method, of class QuejaBO.
     */
    @Test
    public void testConvertirQuejaToDTO() {
        //ARRANGE
        Queja quejaConvertir = new Queja(new ObjectId("64a1bc7e9f4b8d3c5a6f2e3a"),"Leida", fechaPlantilla1, "Sube mucho el lag", true, true, new ObjectId("72a1bc7e9f4b8d3c5a6f2e3a"));
        QuejaDTO quejaEsperada = new QuejaDTO(new ObjectId("64a1bc7e9f4b8d3c5a6f2e3a"),"Leida", fechaPlantilla1, "Sube mucho el lag", true, true, new ObjectId("72a1bc7e9f4b8d3c5a6f2e3a"));
        
        //ACT
        QuejaDTO resultado = QuejaBO.convertirQuejaToDTO(quejaConvertir);
        //ASSERT
        assertEquals(resultado.getDescripcion(), quejaEsperada.getDescripcion());
        assertTrue(resultado.isAnonimo());
        assertTrue(resultado.isLeido());
        assertEquals(resultado.getIdCliente().toHexString(), quejaEsperada.getIdCliente().toHexString());
        assertEquals(resultado.getTipoQueja(), quejaEsperada.getTipoQueja());
    }

    /**
     * Test of convertirDTOToQueja method, of class QuejaBO.
     */
    @Test
    public void testConvertirDTOToQueja() {
        //ARRANGE
        QuejaDTO quejaDTO = new QuejaDTO();
        quejaDTO.setDescripcion("hola123");
        quejaDTO.setAnonimo(false);
        quejaDTO.setLeido(true);
        
        //ACT
        Queja resultado = QuejaBO.convertirDTOToQueja(quejaDTO);
        //ASSERT
        assertEquals("hola123", resultado.getComentario());
        assertFalse(resultado.isAnonimo());
        assertTrue(resultado.isLeido());
    }


    @Test
    public void testObtenerQuejasSeleccionElijeUno() throws Exception {
        // Arrange
        List<Queja> quejasMock = Arrays.asList(new Queja("Queja1"), new Queja("Queja2"));
        when(quejaDAO.obtenerTodasLasQuejas()).thenReturn(quejasMock);

        // Act
        List<QuejaDTO> resultado = quejaBO.obtenerQuejas("<Elije uno>");

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Queja1", resultado.get(0).getTipoQueja());
        verify(quejaDAO, times(1)).obtenerTodasLasQuejas();
    }
    
    @Test
    public void testObtenerQuejasSeleccionNoLeidos() throws Exception {
        // Arrange
        List<Queja> quejasMock = Arrays.asList(new Queja("Queja3"));
        when(quejaDAO.obtenerQuejasPorEstadoYAnonimato(false)).thenReturn(quejasMock);

        // Act
        List<QuejaDTO> resultado = quejaBO.obtenerQuejas("No leidos");

        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Queja3", resultado.get(0).getTipoQueja());
        verify(quejaDAO, times(1)).obtenerQuejasPorEstadoYAnonimato(false);
    }

    @Test
    public void testObtenerQuejasSeleccionLeidos() throws Exception {
        // Arrange
        List<Queja> quejasMock = Arrays.asList(new Queja("Queja4"));
        when(quejaDAO.obtenerQuejasPorEstadoYAnonimato(true)).thenReturn(quejasMock);

        // Act
        List<QuejaDTO> resultado = quejaBO.obtenerQuejas("Leidos");

        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Queja4", resultado.get(0).getTipoQueja());
        verify(quejaDAO, times(1)).obtenerQuejasPorEstadoYAnonimato(true);
    }

    @Test
    public void testObtenerQuejasSeleccionOtroTipo() throws Exception {
        // Arrange
        String seleccionTipo = "Urgente";
        List<Queja> quejasMock = Arrays.asList(new Queja("Queja5"));
        when(quejaDAO.obtenerQuejasPorTipo(seleccionTipo)).thenReturn(quejasMock);

        // Act
        List<QuejaDTO> resultado = quejaBO.obtenerQuejas(seleccionTipo);

        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Queja5", resultado.get(0).getTipoQueja());
        verify(quejaDAO, times(1)).obtenerQuejasPorTipo(seleccionTipo);
    }

    /**
     * Test of confirmarLectura method, of class QuejaBO.
     */
    @Test
    public void testConfirmarLectura() throws Exception {
         // Arrange
        Queja quejaEntrada = new Queja("Alo");
        Queja quejaModificada = new Queja("Modificada");
        QuejaDTO quejaDTOEntrada = new QuejaDTO("Alo"); // Crear el DTO inicial con el valor esperado
        QuejaDTO quejaDTOModificada = new QuejaDTO("Modificada"); // El DTO esperado después de la modificación

        // Configuración del mock para devolver quejaModificada cuando se llame a quejaDAO.confirmarLectura con cualquier Queja
        when(quejaDAO.confirmarLectura(any(Queja.class))).thenReturn(quejaModificada);

        // Act
        QuejaDTO resultado = quejaBO.confirmarLectura(quejaDTOEntrada);

        // Assert
        assertEquals(quejaDTOModificada.getTipoQueja(), resultado.getTipoQueja()); // Compara solo el nombre o el atributo relevante
    }
    
}
