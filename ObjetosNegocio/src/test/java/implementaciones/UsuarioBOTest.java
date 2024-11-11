/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Usuario;
import dtos.UsuarioDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import utilidades.Encriptador;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class UsuarioBOTest {

    private static UsuarioBO usuarioBO;

    @BeforeAll
    public static void setUpClass() {
        usuarioBO = new UsuarioBO();
    }

    @AfterEach
    public void tearDown() {
        usuarioBO.borrarUsuarios();
    }

    @Test
    public void agregarUsuario_UsuarioClienteValido_ReturnSuccess() throws Exception {
        // ARRANGE
        UsuarioDTO clienteDTO = new UsuarioDTO("Diego", "Valenzuela", "Parra", "Prueba@gmail.com", "Prueba123", "cliente");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.agregarUsuario(clienteDTO);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void agregarUsuario_ClienteCorreoExistente_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO cliente1 = new UsuarioDTO("Diego", "Valenzuela", "Parra", "Prueba@gmail.com", "Prueba123", "cliente");
        UsuarioDTO cliente2 = new UsuarioDTO("José Karim", "Franco", "Valencia", "Prueba@gmail.com", "Prueba321", "cliente");
        usuarioBO.agregarUsuario(cliente1);
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.agregarUsuario(cliente2);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void agregarUsuario_EmpleadoValido_ReturnSuccess() throws Exception {
        // ARRANGE
        UsuarioDTO empleado = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        String esperado = "GERE";
        UsuarioDTO empleadoResultado;
        String tipoResultado;

        // ACT
        empleadoResultado = usuarioBO.agregarUsuario(empleado);
        tipoResultado = empleadoResultado.getTipo();

        // ASSERT
        assertNotNull(empleadoResultado);
        assertEquals(esperado, tipoResultado);
    }

    @Test
    public void agregarUsuario_EmpleadoCurpExistente_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO empleado1 = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        usuarioBO.agregarUsuario(empleado1);

        UsuarioDTO empleado2 = new UsuarioDTO("José Karim", "Franco", "Valencia", "9876543210", "JKFV040112HSRLR1W4", "VAPD040603TQ1", "karim@gmail.com", "Prueba321", "RRHH");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.agregarUsuario(empleado2);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void agregarUsuario_EmpleadoRfcExistente_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO empleado1 = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        usuarioBO.agregarUsuario(empleado1);

        UsuarioDTO empleado2 = new UsuarioDTO("José Karim", "Franco", "Valencia", "9876543210", "JKFV040112HSRLR1W4", "VAPD040603TQ1", "karim@gmail.com", "Prueba321", "RRHH");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.agregarUsuario(empleado2);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_ValoresExistentes_ReturnSuccess() throws Exception {
        // ARRANGE
        UsuarioDTO cliente = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        usuarioBO.agregarUsuario(cliente);
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.obtenerUsuarioCorreoContra(cliente);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_CorreoInexistente_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO cliente1 = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        usuarioBO.agregarUsuario(cliente1);
        UsuarioDTO cliente2 = new UsuarioDTO("José Karim", "Franco", "Valencia", "9876543210", "JKFV040112HSRLR1W4", "VAPD040603TQ1", "karim@gmail.com", "Prueba123", "RRHH");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.obtenerUsuarioCorreoContra(cliente2);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_ContraInexistente_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO cliente1 = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "prueba@gmail.com", "Prueba123", "GERE");
        usuarioBO.agregarUsuario(cliente1);
        UsuarioDTO cliente2 = new UsuarioDTO("José Karim", "Franco", "Valencia", "9876543210", "JKFV040112HSRLR1W4", "VAPD040603TQ1", "prueba@gmail.com", "Prueba321", "RRHH");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.obtenerUsuarioCorreoContra(cliente2);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void obtenerUsuarioCorreoContra_ValoresInexistentes_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO cliente1 = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        usuarioBO.agregarUsuario(cliente1);
        UsuarioDTO cliente2 = new UsuarioDTO("José Karim", "Franco", "Valencia", "9876543210", "JKFV040112HSRLR1W4", "VAPD040603TQ1", "karim@gmail.com", "Prueba321", "RRHH");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.obtenerUsuarioCorreoContra(cliente2);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void convertirUsuario_EntidadEnDto_ReturnSuccess() {
        // ARRANGE
        Usuario usuarioEnt = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "diego@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        UsuarioDTO esperado = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        UsuarioDTO resultado;

        // ACT
        resultado = usuarioBO.convertirUsuario(usuarioEnt);

        // ASSERT
        assertEquals(resultado.getNombres(), esperado.getNombres());
        assertEquals(resultado.getApellidoPaterno(), esperado.getApellidoPaterno());
        assertEquals(resultado.getApellidoMaterno(), esperado.getApellidoMaterno());
        assertEquals(resultado.getTelefono(), esperado.getTelefono());
        assertEquals(resultado.getCurp(), esperado.getCurp());
        assertEquals(resultado.getRfc(), esperado.getRfc());
        assertEquals(resultado.getCorreo(), esperado.getCorreo());
        assertEquals(resultado.getContra(), esperado.getContra());
        assertEquals(resultado.getTipo(), esperado.getTipo());
    }

    @Test
    public void convertirUsuario_DtoEnEntidad_ReturnSuccess() {
        // ARRANGE
        Encriptador e = new Encriptador();
        UsuarioDTO usuarioDTO = new UsuarioDTO("Diego", "Valenzuela", "Parra", "0123456789", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "diego@gmail.com", "Prueba123", "GERE");
        Usuario esperado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", e.encriptar("diego@gmail.com"), e.encriptar("Prueba123"), "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        Usuario resultado;

        // ACT
        resultado = usuarioBO.convertirUsuario(usuarioDTO);

        // ASSERT
        assertEquals(resultado.getNombres(), esperado.getNombres());
        assertEquals(resultado.getApellidoPaterno(), esperado.getApellidoPaterno());
        assertEquals(resultado.getApellidoMaterno(), esperado.getApellidoMaterno());
        assertEquals(resultado.getTelefono(), esperado.getTelefono());
        assertEquals(resultado.getCurp(), esperado.getCurp());
        assertEquals(resultado.getRfc(), esperado.getRfc());
        assertEquals(resultado.getCorreo(), esperado.getCorreo());
        assertEquals(resultado.getContrasenia(), esperado.getContrasenia());
        assertEquals(resultado.getTipo(), esperado.getTipo());
    }
}
