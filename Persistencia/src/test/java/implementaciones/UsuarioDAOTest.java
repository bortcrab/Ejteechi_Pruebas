/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Usuario;
import excepciones.PersistenciaException;
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
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.agregarCliente(cliente);

        // ASSERT
        assertNotNull(resultado);
    }

    /**
     * Test of agregarCliente method, of class UsuarioDAO.
     */
    @Test
    public void agregarCliente_ClienteCorreoExistente_ThrowException() throws Exception {
        // ARRANGE
        Usuario cliente1 = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        Usuario cliente2 = new Usuario("José Karim", "Franco", "Valencia", "", "Prueba@gmail.com", "Prueba321", "", "", "cliente");
        usuarioDAO.agregarCliente(cliente1);
        boolean excepcion = false;

        // ACT
        try {
            usuarioDAO.agregarCliente(cliente2);
        } catch (PersistenciaException ex) {
            excepcion = true;
        }

        // ASSERT
        assertTrue(excepcion);
    }

    @Test
    public void obtenerUsuarioCorreo_CorreoExistente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario cliente = new Usuario("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        usuarioDAO.agregarCliente(cliente);

        String correo = "Prueba@gmail.com";
        Usuario resultado;

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
        usuarioDAO.agregarCliente(cliente);

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
        usuarioDAO.agregarCliente(cliente);

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
        usuarioDAO.agregarCliente(cliente);

        String correo = "correo_inexistente@gmail.com";
        String contra = "contra_inexistente";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerUsuarioCorreoContra(correo, contra);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void agregarEmpleado_EmpleadoRecursosHumanos_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario empleado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "RRHH");
        String esperado = "RRHH";
        Usuario empleadoResultado;
        String tipoResultado;

        // ACT
        empleadoResultado = usuarioDAO.agregarEmpleado(empleado);
        tipoResultado = empleadoResultado.getTipo();

        // ASSERT
        assertNotNull(empleadoResultado);
        assertEquals(esperado, tipoResultado);
    }

    @Test
    public void agregarEmpleado_EmpleadoAtencionCliente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario empleado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "AACC");
        String esperado = "AACC";
        Usuario empleadoResultado;
        String tipoResultado;

        // ACT
        empleadoResultado = usuarioDAO.agregarEmpleado(empleado);
        tipoResultado = empleadoResultado.getTipo();

        // ASSERT
        assertNotNull(empleadoResultado);
        assertEquals(esperado, tipoResultado);
    }

    @Test
    public void agregarEmpleado_EmpleadoMantenimiento_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario empleado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "PPMM");
        String esperado = "PPMM";
        Usuario empleadoResultado;
        String tipoResultado;

        // ACT
        empleadoResultado = usuarioDAO.agregarEmpleado(empleado);
        tipoResultado = empleadoResultado.getTipo();

        // ASSERT
        assertNotNull(empleadoResultado);
        assertEquals(esperado, tipoResultado);
    }

    @Test
    public void agregarEmpleado_EmpleadoGerente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario empleado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        String esperado = "GERE";
        Usuario empleadoResultado;
        String tipoResultado;

        // ACT
        empleadoResultado = usuarioDAO.agregarEmpleado(empleado);
        tipoResultado = empleadoResultado.getTipo();

        // ASSERT
        assertNotNull(empleadoResultado);
        assertEquals(esperado, tipoResultado);
    }

    @Test
    public void agregarEmpleado_EmpleadoCorreoExistente_ThrowException() throws PersistenciaException {
        // ARRANGE
        Usuario empleado1 = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        usuarioDAO.agregarEmpleado(empleado1);
        Usuario empleado2 = new Usuario("José Karim", "Franco", "Valencia", "9876543210", "Prueba@gmail.com", "Prueba321", "JKFV040112HSRLR1W4", "JKFV040112GHC", "RRHH");
        boolean excepcion = false;

        // ACT
        try {
            usuarioDAO.agregarEmpleado(empleado2);
        } catch (PersistenciaException ex) {
            excepcion = true;
        }

        // ASSERT
        assertTrue(excepcion);
    }

    @Test
    public void agregarEmpleado_EmpleadoCurpExistente_ThrowException() throws Exception {
        // ARRANGE
        Usuario empleado1 = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "diego@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        usuarioDAO.agregarEmpleado(empleado1);
        Usuario empleado2 = new Usuario("José Karim", "Franco", "Valencia", "9876543210", "karim@gmail.com", "Prueba321", "VAPD040603HSRLRGA6", "JKFV040112GHC", "RRHH");
        boolean excepcion = false;

        // ACT
        try {
            usuarioDAO.agregarEmpleado(empleado2);
        } catch (PersistenciaException ex) {
            excepcion = true;
        }

        // ASSERT
        assertTrue(excepcion);
    }

    @Test
    public void agregarEmpleado_EmpleadoRfcExistente_ThrowException() throws Exception {
        // ARRANGE
        Usuario empleado1 = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "diego@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        usuarioDAO.agregarEmpleado(empleado1);
        Usuario empleado2 = new Usuario("José Karim", "Franco", "Valencia", "9876543210", "karim@gmail.com", "Prueba321", "JKFV040112HSRLR1W4", "VAPD040603TQ1", "RRHH");
        boolean excepcion = false;

        // ACT
        try {
            usuarioDAO.agregarEmpleado(empleado2);
        } catch (PersistenciaException ex) {
            excepcion = true;
        }

        // ASSERT
        assertTrue(excepcion);
    }

    @Test
    public void obtenerEmpleadoCurp_CurpExistente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario empleado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        usuarioDAO.agregarEmpleado(empleado);

        String curp = "VAPD040603HSRLRGA6";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerEmpleadoCurp(curp);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerEmpleadoCurp_CurpInexistente_ReturnSuccess() throws Exception {
        String curp = "JKFV040112HSRLR1W4";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerEmpleadoCurp(curp);

        // ASSERT
        assertNull(resultado);
    }

    @Test
    public void obtenerEmpleadoRfc_RfcExistente_ReturnSuccess() throws Exception {
        // ARRANGE
        Usuario empleado = new Usuario("Diego", "Valenzuela", "Parra", "0123456789", "Prueba@gmail.com", "Prueba123", "VAPD040603HSRLRGA6", "VAPD040603TQ1", "GERE");
        usuarioDAO.agregarEmpleado(empleado);

        String rfc = "VAPD040603TQ1";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerEmpleadoRfc(rfc);

        // ASSERT
        assertNotNull(resultado);
    }

    @Test
    public void obtenerEmpleadoRfc_RfcInexistente_ReturnSuccess() throws Exception {
        String rfc = "VAPD040603TQ1";
        Usuario resultado;

        // ACT
        resultado = usuarioDAO.obtenerEmpleadoRfc(rfc);

        // ASSERT
        assertNull(resultado);
    }
}
