/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Diego Valenzuela Parra
 */
@ExtendWith(MockitoExtension.class)
public class UsuarioDAOTest {

    @Mock
    private UsuarioDAO usuarioDAO;
    
    public UsuarioDAOTest() {
    }

    /**
     * Test of agregarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void agregarUsuario_UsuarioCorrecto_ReturnSuccess() {
        // ARRANGE
        Usuario usuario = new Usuario("Diego", "Valenzuela", "Parra", "6441000000", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "cliente");
        Usuario esperado = new Usuario("Diego", "Valenzuela", "Parra", "6441000000", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "cliente");
        when(usuarioDAO.agregarUsuario(usuario)).thenReturn(esperado);
        Usuario resultado;
        
        // ACT
        resultado = usuarioDAO.agregarUsuario(usuario);
        
        // ASSERT
        assertEquals(esperado, resultado);
        verify(usuarioDAO, times(1)).agregarUsuario(usuario);
    }

    /**
     * Test of obtenerUsuarioCurp method, of class UsuarioDAO.
     */
    @Test
    public void obtenerUsuarioCurp_UsuarioExistente_ReturnSuccess() {
        // ARRANGE
        String curp = "VAPD040603HSRLRGA6";
        Usuario esperado = new Usuario("Diego", "Valenzuela", "Parra", "6441000000", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "cliente");
        when(usuarioDAO.obtenerUsuarioCurp(curp)).thenReturn(esperado);
        Usuario resultado;
        
        // ACT
        resultado = usuarioDAO.obtenerUsuarioCurp(curp);
        
        // ASSERT
        assertEquals(esperado, resultado);
        verify(usuarioDAO, times(1)).obtenerUsuarioCurp(curp);
    }

    /**
     * Test of obtenerUsuarioRfc method, of class UsuarioDAO.
     */
    @Test
    public void obtenerUsuarioRfc_UsuarioExistente_ReturnSuccess() {
        // ARRANGE
        String rfc = "VAPD040603TQ1";
        Usuario esperado = new Usuario("Diego", "Valenzuela", "Parra", "6441000000", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "cliente");
        when(usuarioDAO.obtenerUsuarioRfc(rfc)).thenReturn(esperado);
        Usuario resultado;
        
        // ACT
        resultado = usuarioDAO.obtenerUsuarioRfc(rfc);
        
        // ASSERT
        assertEquals(esperado, resultado);
        verify(usuarioDAO, times(1)).obtenerUsuarioRfc(rfc);
    }

    /**
     * Test of obtenerUsuarioCorreoContra method, of class UsuarioDAO.
     */
    @Test
    public void obtenerUsuarioCorreoContra_UsuarioExistente_ReturnSuccess() {
        // ARRANGE
        String correo = "Prueba@gmail.com";
        String contrasenia = "Prueba123";
        Usuario esperado = new Usuario("Diego", "Valenzuela", "Parra", "6441000000", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "cliente");
        when(usuarioDAO.obtenerUsuarioCorreoContra(correo, contrasenia)).thenReturn(esperado);
        Usuario resultado;
        
        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreoContra(correo, contrasenia);
        
        // ASSERT
        assertEquals(esperado, resultado);
        verify(usuarioDAO, times(1)).obtenerUsuarioCorreoContra(correo, contrasenia);
    }

}
