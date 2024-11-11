/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Camion;
import dtos.CamionDTO;
import static implementaciones.CamionBO.CamionADTO;
import interfaces.ICamionDAO;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

        // Llamar al método que convierte el objeto Camion en CamionDTO
        //Act
        CamionDTO camionDTO = CamionADTO(camion);

        // Verificar que los valores del CamionDTO son correctos
        //Assert
        assertEquals(camion.getNumeroUnidad(), camionDTO.getNumeroUnidad());
        assertEquals(camion.getEstadoMotor(), camionDTO.getEstadoMotor());
        assertEquals(camion.getEstadoLimpieza(), camionDTO.getEstadoLimpieza());
        assertEquals(camion.getEstadoLlantas(), camionDTO.getEstadoLlantas());
        assertEquals(camion.getEstadoLuces(), camionDTO.getEstadoLuces());
        assertEquals(camion.getNivelPrioridad(), camionDTO.getNivelPrioridad());
        assertEquals(camion.getFechaUltimoMantenimiento(), camionDTO.getFechaUltimoMantenimiento());
    }
}
