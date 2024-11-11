/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Camion;
import dtos.CamionDTO;
import static implementaciones.CamionBO.CamionADTO;
import interfaces.ICamionDAO;
import interfaces.IQuejaDAO;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.refEq;

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
    public void testCamionADTO() {
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

    /**
     * Test of obtenerPorNumeroUnidad method, of class CamionBO.
     */
//    @Test
//    public void testObtenerPorNumeroUnidad() throws Exception {
//        Camion camion = new Camion("001", "bueno", new Date(), "Alto");
//        String numeroUnidad = "001";
//        
//        CamionDTO resultado = camionBO.obtenerPorNumeroUnidad(numeroUnidad);
//        
////        verify(camionDAO).obtenerPorNumeroUnidad(refEq(CamionBO.CamionADTO(camion)));
//        
//    }
//
//    /**
//     * Test of actualizarPrioridadYFechaMantenimiento method, of class CamionBO.
//     */
//    @Test
//    public void testActualizarPrioridadYFechaMantenimiento() throws Exception {
//        System.out.println("actualizarPrioridadYFechaMantenimiento");
//        String numeroUnidad = "";
//        String nuevaPrioridad = "";
//        Date nuevaFechaMantenimiento = null;
//        CamionBO instance = new CamionBO();
//        CamionDTO expResult = null;
//        CamionDTO result = instance.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of actualizarEstado method, of class CamionBO.
//     */
//    @Test
//    public void testActualizarEstado() throws Exception {
//        System.out.println("actualizarEstado");
//        String numeroUnidad = "";
//        String estadoMotor = "";
//        String estadoLimpieza = "";
//        String estadoLlantas = "";
//        String estadoLuces = "";
//        CamionBO instance = new CamionBO();
//        Camion expResult = null;
//        Camion result = instance.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
