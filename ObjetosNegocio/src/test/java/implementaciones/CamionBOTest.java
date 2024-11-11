package implementaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import interfaces.ICamionDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import implementaciones.CamionBO;
import java.util.Date;

class CamionBOTest {

    @Mock
    private ICamionDAO camionDAO;

    @InjectMocks
    private CamionBO camionBO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorNumeroUnidad_Success() throws ObjetosNegocioException {
        // Arrange
        Camion camion = new Camion();
        camion.setNumeroUnidad("123");
        when(camionDAO.obtenerPorNumeroUnidad("123")).thenReturn(camion);

        // Act
        CamionDTO result = camionBO.obtenerPorNumeroUnidad("123");

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getNumeroUnidad());
        verify(camionDAO).obtenerPorNumeroUnidad("123");
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

        // Act
        CamionDTO result = camionBO.actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha);

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
        assertThrows(ObjetosNegocioException.class, () -> 
            camionBO.actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha)
        );
        verify(camionDAO, times(2)).actualizarPrioridadYFechaMantenimiento("123", "Alta", nuevaFecha);
    }

    @Test
    void testActualizarEstado_Success() throws ObjetosNegocioException {
        // Arrange
        Camion camion = new Camion();
        camion.setNumeroUnidad("123");
        when(camionDAO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando")).thenReturn(camion);

        // Act
        Camion result = camionBO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando");

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
        assertThrows(ObjetosNegocioException.class, () -> 
            camionBO.actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando")
        );
        verify(camionDAO, times(2)).actualizarEstado("123", "Bueno", "Limpio", "Nuevas", "Funcionando");
    }
}