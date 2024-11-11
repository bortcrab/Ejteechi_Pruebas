package utilidades;

import excepciones.PresentacionException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilidades.Validador;

public class ValidadorTest {

    private final Validador validador = new Validador();

    // Test para validarVacio
    @Test
    public void testValidarVacio_ConCadenaVacia_LanzaExcepcion() {
        // Arrange
        String cadenaVacia = "";

        // Act & Assert
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarVacio(cadenaVacia);
        });
    }

    @Test
    public void testValidarVacio_ConCadenaConEspacios_LanzaExcepcion() {
        // Arrange
        String cadenaConEspacios = "     ";

        // Act & Assert
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarVacio(cadenaConEspacios);
        });
    }

    @Test
    public void testValidarVacio_ConCadenaNoVacia_NoLanzaExcepcion() {
        // Arrange
        String cadenaValida = "Texto válido";

        // Act & Assert
        assertDoesNotThrow(() -> validador.validarVacio(cadenaValida));
    }

    // Test para validarCorreo
    @Test
    public void testValidarCorreo_ConCorreoInvalido_LanzaExcepcion() {
        // Arrange
        String correoInvalido = "correo@invalido";

        // Act & Assert
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarCorreo(correoInvalido);
        });
    }

    @Test
    public void testValidarCorreo_ConCorreoValido_NoLanzaExcepcion() {
        // Arrange
        String correoValido = "correo@dominio.com";

        // Act & Assert
        assertDoesNotThrow(() -> validador.validarCorreo(correoValido));
    }

    // Test para validarTelefono
    @Test
    public void testValidarTelefono_ConTelefonoInvalido_LanzaExcepcion() {
        // Arrange
        String telefonoInvalido = "644012345"; // menos de 10 dígitos

        // Act & Assert
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarTelefono(telefonoInvalido);
        });
    }

    @Test
    public void testValidarTelefono_ConTelefonoValido_NoLanzaExcepcion() {
        // Arrange
        String telefonoValido = "6440123456"; // 10 dígitos

        // Act & Assert
        assertDoesNotThrow(() -> validador.validarTelefono(telefonoValido));
    }

    // Test para validarRFC
    @Test
    public void testValidarRFC_ConRfcInvalido_LanzaExcepcion() {
        // Arrange
        String rfcInvalido = "ABCD010312"; // Menos de 13 caracteres

        // Act & Assert
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarRFC(rfcInvalido);
        });
    }

    @Test
    public void testValidarRFC_ConRfcValido_NoLanzaExcepcion() {
        // Arrange
        String rfcValido = "ABCD010312MC2"; // 13 caracteres

        // Act & Assert
        assertDoesNotThrow(() -> validador.validarRFC(rfcValido));
    }

    // Test para validarContrasenia
    @Test
    public void testValidarContrasenia_ConContraseniaInvalida_LanzaExcepcion() {
        // Arrange
        String contraseniaInvalida = "12345"; // Menos de 8 caracteres

        // Act & Assert
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarContrasenia(contraseniaInvalida);
        });
    }

    @Test
    public void testValidarContrasenia_ConContraseniaValida_NoLanzaExcepcion() {
        // Arrange
        String contraseniaValida = "jk2aUHhaj9"; // Cumple con las condiciones

        // Act & Assert
        assertDoesNotThrow(() -> validador.validarContrasenia(contraseniaValida));
    }
    
    // Método de prueba para validar el contenido del ticket en formato AAA
    @Test
    public void testValidarTicket() {
        // Arrange

        // Act & Assert: Caso 1 - Contenido válido
        try {
            validador.validarTicket("Este es un ticket válido.");
        } catch (PresentacionException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }

        // Act & Assert: Caso 2 - Contenido vacío
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarTicket("");
        });
        assertEquals("El ticket no puede estar vacío.", exception.getMessage());

        // Act & Assert: Caso 3 - Contenido mayor a 500 caracteres
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarTicket("A".repeat(501));
        });
        assertEquals("El ticket no puede exceder los 500 caracteres.", exception.getMessage());
    }

    // Método de prueba para validar el contenido de la respuesta en formato AAA
    @Test
    public void testValidarRespuesta() {
        // Arrange

        // Act & Assert: Caso 1 - Contenido válido
        try {
            validador.validarRespuesta("Este es un mensaje válido.");
        } catch (PresentacionException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }

        // Act & Assert: Caso 2 - Contenido vacío
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarRespuesta("");
        });
        assertEquals("El mensaje no puede estar vacío.", exception.getMessage());

        // Act & Assert: Caso 3 - Contenido mayor a 500 caracteres
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarRespuesta("A".repeat(501));
        });
        assertEquals("El mensaje no puede exceder los 500 caracteres.", exception.getMessage());
    }

    // Método de prueba para validar los nombres en formato AAA
    @Test
    public void testValidarNombres() {
        // Arrange

        // Act & Assert: Caso 1 - Nombres válidos
        try {
            validador.validarNombres("Juan Pérez");
        } catch (PresentacionException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }

        // Act & Assert: Caso 2 - Nombres vacíos
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarNombres("");
        });
        assertEquals("El nombre no puede estar vacío.", exception.getMessage());

        // Act & Assert: Caso 3 - Nombres mayores a 100 caracteres
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarNombres("A".repeat(101));
        });
        assertEquals("El nombre no puede exceder los 100 caracteres.", exception.getMessage());

        // Act & Assert: Caso 4 - Nombres con caracteres no permitidos (números)
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarNombres("Juan123");
        });
        assertEquals("El nombre sólo puede tener letras.", exception.getMessage());
    }

    // Método de prueba para validar el apellido paterno en formato AAA
    @Test
    public void testValidarApellidoP() {
        // Arrange

        // Act & Assert: Caso 1 - Apellido paterno válido
        try {
            validador.validarApellidoP("González");
        } catch (PresentacionException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }

        // Act & Assert: Caso 2 - Apellido paterno vacío
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarApellidoP("");
        });
        assertEquals("El apellido paterno no puede estar vacío.", exception.getMessage());

        // Act & Assert: Caso 3 - Apellido paterno mayor a 100 caracteres
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarApellidoP("A".repeat(101));
        });
        assertEquals("El apellido paterno no puede exceder los 100 caracteres.", exception.getMessage());

        // Act & Assert: Caso 4 - Apellido paterno con caracteres no permitidos (números)
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarApellidoP("González123");
        });
        assertEquals("El apellido paterno sólo puede tener letras.", exception.getMessage());
    }

    // Método de prueba para validar el apellido materno en formato AAA
    @Test
    public void testValidarApellidoM() {
        // Arrange

        // Act & Assert: Caso 1 - Apellido materno válido
        try {
            validador.validarApellidoM("Martínez");
        } catch (PresentacionException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }

        // Act & Assert: Caso 2 - Apellido materno vacío
        PresentacionException exception = assertThrows(PresentacionException.class, () -> {
            validador.validarApellidoM("");
        });
        assertEquals("El apellido materno no puede estar vacío.", exception.getMessage());

        // Act & Assert: Caso 3 - Apellido materno mayor a 100 caracteres
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarApellidoM("A".repeat(101));
        });
        assertEquals("El apellido materno no puede exceder los 100 caracteres.", exception.getMessage());

        // Act & Assert: Caso 4 - Apellido materno con caracteres no permitidos (números)
        exception = assertThrows(PresentacionException.class, () -> {
            validador.validarApellidoM("Martínez123");
        });
        assertEquals("El apellido materno sólo puede tener letras.", exception.getMessage());
    }
}
