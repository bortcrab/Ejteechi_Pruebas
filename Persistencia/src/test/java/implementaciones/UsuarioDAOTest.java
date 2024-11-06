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
    public void testAgregarUsuario() {
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
     * Test of obtenerUsuarioCorreo method, of class UsuarioDAO.
     */
    @Test
    public void testObtenerUsuarioCorreo() {
        System.out.println("obtenerUsuarioCorreo");
        String correo = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuarioCorreo(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuarioCurp method, of class UsuarioDAO.
     */
    @Test
    public void testObtenerUsuarioCurp() {
        System.out.println("obtenerUsuarioCurp");
        String curp = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuarioCurp(curp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuarioRfc method, of class UsuarioDAO.
     */
    @Test
    public void testObtenerUsuarioRfc() {
        System.out.println("obtenerUsuarioRfc");
        String rfc = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuarioRfc(rfc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuarioCorreoContra method, of class UsuarioDAO.
     */
    @Test
    public void testObtenerUsuarioCorreoContra() {
        System.out.println("obtenerUsuarioCorreoContra");
        String correo = "";
        String contrasenia = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuarioCorreoContra(correo, contrasenia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
