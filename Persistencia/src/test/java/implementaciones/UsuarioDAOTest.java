/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Usuario;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class UsuarioDAOTest {

    private static UsuarioDAO usuarioDAO;

    public UsuarioDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        usuarioDAO = new UsuarioDAO();
    }

    @AfterEach
    public void tearDown() {
        usuarioDAO.borrarUsuarios();
    }

    /**
     * Test of agregarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void agregarCliente_ClienteValido_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        Usuario resultado = null;

        // ACT
        try {
            resultado = usuarioDAO.agregarCliente(cliente);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }

        // ASSERT
        assertNotNull(resultado);
    }

    /**
     * Test of agregarCliente method, of class UsuarioDAO.
     */
    @Test
    public void agregarCliente_ClienteCorreoDuplicado_ReturnFail() throws Exception {
        // ARRANGE
        Usuario cliente1 = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        Usuario cliente2 = new Usuario("José Karim", "Franco", "Valencia", "", "Prueba@gmail.com", "Prueba321", "", "", "cliente");
        try {
            usuarioDAO.agregarCliente(cliente1);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }
        Usuario resultado = null;

        // ACT
        try {
            resultado = usuarioDAO.agregarCliente(cliente2);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreo_CorreoExistente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        try {
            usuarioDAO.agregarCliente(cliente);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }

        String correo = "Prueba@gmail.com";
        Usuario resultado = null;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreo(correo);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreo_CorreoInexistente_ReturnSuccess() {
        // ARRANGE
        String correo = "Prueba@gmail.com";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreo(correo);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_ValoresExistentes_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        try {
            usuarioDAO.agregarCliente(cliente);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }
        
        String correo = "Prueba@gmail.com";
        String contra = "Prueba123";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreoContra(correo, contra);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_CorreoInexistente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        try {
            usuarioDAO.agregarCliente(cliente);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }
        
        String correo = "correo_inexistente@gmail.com";
        String contra = "Prueba123";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreoContra(correo, contra);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_ContraInexistente_ReturnSuccess() throws Exception {
        // ARRANGE
        String correo = "Prueba@gmail.com";
        String contra = "contra_inexistente";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreoContra(correo, contra);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_ValoresInexistentes_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        try {
            usuarioDAO.agregarCliente(cliente);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }
        
        String correo = "correo_inexistente@gmail.com";
        String contra = "contra_inexistente";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreoContra(correo, contra);

        // ASSERT
        assertNull(resultado);
    }
    
    @Test
    public void agregarEmpleado_EmpleadoValido_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "cliente");
        Usuario resultado = null;

        // ACT
        try {
            resultado = usuarioDAO.agregarCliente(cliente);
        } catch (PersistenciaException pe) {
            throw new Exception(pe.getMessage());
        }

        // ASSERT
        assertNotNull(resultado);
    }

}
