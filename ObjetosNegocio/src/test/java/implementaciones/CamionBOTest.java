/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import static implementaciones.CamionBO.CamionADTO;
import interfaces.ICamionDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Date;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author karim
 */
@ExtendWith(MockitoExtension.class)
public class CamionBOTest {

    public CamionBOTest() {
    }

    @Mock
    private ICamionDAO camionDAO;

    @InjectMocks
    private CamionBO camionBO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of CamionADTO method, of class CamionBO.
     */
    @Test
    public void testCamionADTO_ReturnSuccess() {
        // Configurar el objeto Camion
        //Arrange
        Camion camion = new Camion();
        camion.setNumeroUnidad("1234");
        camion.setEstadoMotor("Bueno");
        camion.setEstadoLimpieza("Sucia");
        camion.setEstadoLlantas("Nuevo");
        camion.setEstadoLuces("Funciona");
        camion.setNivelPrioridad("Alto");
        camion.setFechaUltimoMantenimiento(new Date());
        CamionDTO camionDTO;

        //Act
        camionDTO = CamionADTO(camion);

        //Assert
        assertEquals(camion.getNumeroUnidad(), camionDTO.getNumeroUnidad());
        assertEquals(camion.getEstadoMotor(), camionDTO.getEstadoMotor());
        assertEquals(camion.getEstadoLimpieza(), camionDTO.getEstadoLimpieza());
        assertEquals(camion.getEstadoLlantas(), camionDTO.getEstadoLlantas());
        assertEquals(camion.getEstadoLuces(), camionDTO.getEstadoLuces());
        assertEquals(camion.getNivelPrioridad(), camionDTO.getNivelPrioridad());
        assertEquals(camion.getFechaUltimoMantenimiento(), camionDTO.getFechaUltimoMantenimiento());
    }

    @Test
    void testObtenerPorNumeroUnidad_NotFound() {
        // Arrange
        when(camionDAO.obtenerPorNumeroUnidad("123")).thenReturn(null);

        // Act & Assert
        assertThrows(ObjetosNegocioException.class, () -> camionBO.obtenerPorNumeroUnidad("123"));
        verify(camionDAO).obtenerPorNumeroUnidad("123");
    }

    @Test
    void testActualizarPrioridadYFechaMantenimiento_Success() throws ObjetosNegocioException {
        // Arrange
        Date nuevaFecha = new Date();
        Camion camion = new Camion();
        camion.setNumeroUnidad("123");
        when(camionDAO.actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha)).thenReturn(camion);
        CamionDTO result;

        // Act
        result = camionBO.actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha);

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getNumeroUnidad());
        verify(camionDAO, times(2)).actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha);
    }

    @Test
    void testActualizarPrioridadYFechaMantenimiento_Failure() {
        // Arrange
        Date nuevaFecha = new Date();
        when(camionDAO.actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha)).thenReturn(null);

        // Act & Assert
        assertThrows(ObjetosNegocioException.class, ()
                -> camionBO.actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha)
        );
        verify(camionDAO, times(2)).actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha);
    }

    @Test
    void testActualizarEstado_Success() throws ObjetosNegocioException {
        // Arrange
        Camion camion = new Camion();
        camion.setNumeroUnidad("123");
        when(camionDAO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando")).thenReturn(camion);
        Camion result;

        // Act
        result = camionBO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando");

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getNumeroUnidad());
        verify(camionDAO, times(2)).actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando");
    }

    @Test
    void testActualizarEstado_Failure() {
        // Arrange
        when(camionDAO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando")).thenReturn(null);

        // Act & Assert
        assertThrows(ObjetosNegocioException.class, ()
                -> camionBO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando")
        );
        verify(camionDAO, times(2)).actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando");
    }
}
