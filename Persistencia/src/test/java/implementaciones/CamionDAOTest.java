/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Camion;
import excepciones.PersistenciaException;
import java.util.Date;
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
public class CamionDAOTest {
    private  CamionDAO camionDAO;
    
    public CamionDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        camionDAO = new CamionDAO();
    }
    
    @AfterEach
    public void tearDown() {
        camionDAO.cerrarConexion();
    }

    /**
     * Test of obtenerPorNumeroUnidad method, of class CamionDAO.
     */
    @Test
    public void testObtener_PorNumeroUnidad_ReturnSuccess() throws PersistenciaException {
        String numeroUnidadABuscar = "001";
        
        Camion resultado = camionDAO.obtenerPorNumUnidadCamion(numeroUnidadABuscar);
        
        assertEquals("001", resultado.getNumeroUnidad());
    }
    @Test
    public void testObtener_PorNumeroUnidadQueNoExiste_ReturnSuccess(){
        //Arrange
        String numeroUnidadABuscar = "077";
        
        //Act y assert
        assertThrows(PersistenciaException.class, () -> {
            camionDAO.obtenerPorNumUnidadCamion(numeroUnidadABuscar);
        });
    }

    /**
     * Este método para probarlo se tiene que cambiar los parametros de el act
     */
    @Test
    public void testActualizar_Estado_ReturnSuccess() throws PersistenciaException {
        //Arrange
        Camion camion = camionDAO.obtenerPorNumUnidadCamion("001");
        String estadoMotor = camion.getEstadoMotor(); 
        String estadoLimpieza = camion.getEstadoLimpieza();
        String estadoLlantas = camion.getEstadoLlantas(); 
        String estadoLuces = camion.getEstadoLuces();
        
        //Act
        Camion camionResultado = camionDAO.actualizarEstado("001", "Medio", "Malo", "Malo", "Bueno");
        
        //Assert
        assertNotEquals(estadoMotor, camionResultado.getEstadoMotor());
        assertNotEquals(estadoLimpieza, camionResultado.getEstadoLimpieza());
        assertNotEquals(estadoLlantas, camionResultado.getEstadoLlantas());
        assertNotEquals(estadoLuces, camionResultado.getEstadoLuces());
    }
    
    @Test
    public void testActualizar_EstadoMotor_ReturnSuccess() throws PersistenciaException {
        //Arrange
        Camion camion = camionDAO.obtenerPorNumeroUnidad("002");
        String estadoOriginalMotor = camion.getEstadoMotor();
        String estadoACambiar = "Bueno";
        
        //Act
        Camion camionResultado =  camionDAO.actualizarEstado("002", estadoACambiar, null, null, null);
        
        //Assert
        assertNotEquals(estadoOriginalMotor, camionResultado.getEstadoMotor());
    }
    
    @Test
    public void testActualizar_EstadoLimpieza_ReturnSuccess() throws PersistenciaException {
        //Arrange
        Camion camion = camionDAO.obtenerPorNumUnidadCamion("003");
        String estadoOriginalLimpieza = camion.getEstadoLimpieza();
        String estadoLlantas = camion.getEstadoLlantas();
        String estadoACambiar = "Medio";
        
        //Act
        Camion camionResultado = camionDAO.actualizarEstado("003", null, estadoACambiar, null, null);
        
        //Assert
        assertNotEquals(estadoOriginalLimpieza, camionResultado.getEstadoLimpieza());
        assertEquals(estadoLlantas, camionResultado.getEstadoLlantas());
    }
    
    @Test
    public void testActualizar_EstadoLlantas_ReturnSuccess() throws PersistenciaException {
        //Arrange
        Camion camion = camionDAO.obtenerPorNumeroUnidad("004");
        String estadoOriginalLlantas = camion.getEstadoLlantas();
        String estadoMotor = camion.getEstadoMotor();
        String estadoACambiar = "Malo";
        
        //Act
        Camion camionResultado = camionDAO.actualizarEstado("004", null, null, estadoACambiar, null);
        
        //Assert
        assertNotEquals(estadoOriginalLlantas, camionResultado.getEstadoLlantas());
        assertEquals(estadoMotor, camionResultado.getEstadoMotor());
    }
    @Test
    public void testActualizar_EstadoLuces_ReturnSuccess() throws PersistenciaException {
        //Arrange
        Camion camion = camionDAO.obtenerPorNumeroUnidad("005");
        String estadoOriginalLuces = camion.getEstadoLuces();
        String estadoLimpieza = camion.getEstadoLimpieza();
        String estadoACambiar = "Malo";
        
        //Act
        camionDAO.actualizarEstado("005", null, null, null, estadoACambiar);
        Camion camionResultado = camionDAO.obtenerPorNumeroUnidad("005");
        
        //Assert
        assertNotEquals(estadoOriginalLuces, camionResultado.getEstadoLuces());
        assertEquals(estadoLimpieza, camionResultado.getEstadoLimpieza());
    }

    /**
     * Test of actualizarPrioridadYFechaMantenimiento method, of class CamionDAO.
     */
    @Test
    public void testActualizar_Prioridad_Y_FechaMantenimientoAmbos_ReturnSuccess() throws PersistenciaException {
        Camion camion = camionDAO.obtenerPorNumeroUnidad("007");
        String nivelPrioridadOriginal = camion.getNivelPrioridad();
        Date fechaOriginal = camion.getFechaUltimoMantenimiento();
        
        Camion resultado = camionDAO.actualizarPrioridadYFechaMantenimiento("007", "Bajo", new Date());
        
        assertNotEquals(resultado.getNivelPrioridad(), nivelPrioridadOriginal);
        assertNotEquals(fechaOriginal.getTime(), resultado.getFechaUltimoMantenimiento().getTime());
    }
    @Test
    public void testActualizar_Prioridad_ReturnSuccess() throws PersistenciaException {
        Camion camion = camionDAO.obtenerPorNumeroUnidad("008");
        String nivelPrioridadOriginal = camion.getNivelPrioridad();
        Date fechaOriginal = camion.getFechaUltimoMantenimiento();
        
        Camion resultado = camionDAO.actualizarPrioridadYFechaMantenimiento("008", "Bueno", null);
        
        assertNotEquals(resultado.getNivelPrioridad(), nivelPrioridadOriginal);
        assertEquals(fechaOriginal.getTime(), resultado.getFechaUltimoMantenimiento().getTime());
    }
    @Test
    public void testActualizar_UltimoMantenimiento_ReturnSuccess() throws PersistenciaException {
        Camion camion = camionDAO.obtenerPorNumeroUnidad("009");
        String nivelPrioridadOriginal = camion.getNivelPrioridad();
        Date fechaOriginal = camion.getFechaUltimoMantenimiento();
        
        Camion resultado = camionDAO.actualizarPrioridadYFechaMantenimiento("009", null, new Date());
        
        assertEquals(resultado.getNivelPrioridad(), nivelPrioridadOriginal);
        assertNotEquals(fechaOriginal.getTime(), resultado.getFechaUltimoMantenimiento().getTime());
    }
    
}
