package utilidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Clase de pruebas unitarias para la clase Encriptador.
 */
public class EncriptadorTest {
    
    private Encriptador encriptador;
    
    @BeforeEach
    public void setUp() {
        encriptador = new Encriptador();
    }
    
    @Test
    public void testEncriptar_CadenaAlfanumerica_ReturnSuccess() {
        // CP01: Encriptar cadena alfanumérica válida
        //Arrange
        String entrada = "Hola123";
        String resultado;
        
        //Act
        resultado = encriptador.encriptar(entrada);
        
        //Assert
        assertNotNull("La cadena encriptada no debe ser null", resultado);
        assertNotEquals("La cadena encriptada no debe ser igual a la original", entrada, resultado);
    }
    
    @Test
    public void testDesencriptar_CadenaPrevia_ReturnSuccess() throws Exception {
        // CP02: Desencriptar cadena previamente encriptada
        //ARRANGE
        String entrada = "Hola123";
        String encriptado = encriptador.encriptar(entrada);
        String desencriptado;
        
        //ACT
        desencriptado = encriptador.desencriptar(encriptado);
        
        //ASSERT
        assertEquals(entrada, desencriptado);
    }
    
    @Test
    public void testEncriptar_CadenaVacia_ReturnSuccess() {
        // CP03: Encriptar cadena vacía
        //ARRANGE
        String entrada = "";
        String resultado;
        
        //ACT
        resultado = encriptador.encriptar(entrada);
        
        //ASSERT
        assertNotNull("La cadena encriptada no debe ser null", resultado);
    }
    
    
    @Test
    public void testDesencriptar_CadenaInvalida_ReturnSuccess() throws Exception {
        // CP06: Desencriptar cadena inválida
         // Arrange: Preparamos los datos de entrada
        String entrada = "EstoNoEsUnaC@denaEncriptada";

        // Act & Assert: Verificamos que se lance la excepción y que el resultado sea null
        Exception exception = assertThrows(Exception.class, () -> {
            // Llamamos al método y asignamos el resultado
            String resultado = encriptador.desencriptar(entrada);
            // Aquí podemos usar assertNull dentro del mismo bloque para verificar que sea null si no lanza excepción
            assertNull(resultado, "El resultado debe ser null al desencriptar una cadena inválida");
        });
    }
    
    
    @Test
    public void testCicloCompleto_Encriptacion_Desencriptacion_ReturnSuccess() throws Exception {
        // CP08: Ciclo completo de encriptación-desencriptación
        //ARRANGE
        String entrada = "TestCompleto123!@#";
        String encriptado;
        String desencriptado;
        
        //ACT
        encriptado = encriptador.encriptar(entrada);
        desencriptado = encriptador.desencriptar(encriptado);
        
        //ASSERT
        assertNotNull( encriptado);
        assertNotEquals( entrada, encriptado);
        assertEquals(entrada, desencriptado);
    }
    
    @Test
    public void testMultiples_EncriptacionesConsistentes_ReturnSuccess() {
        // Prueba adicional: Verificar que múltiples encriptaciones del mismo valor son consistentes
        //Arrange
        String entrada = "PruebaConsistencia";
        
        //Act
        String encriptado1 = encriptador.encriptar(entrada);
        String encriptado2 = encriptador.encriptar(entrada);
        
        //Assert
        assertEquals(encriptado1, encriptado2);
    }
    
    @Test
    public void verificacion_QueGenereLaMismaLlave_ReturnSuccess(){
        //Arrange y act
        String valorEsperado = Encriptador.generarLlave().toString();
        String resultado = Encriptador.generarLlave().toString();
        
        //Assert
        assertEquals(valorEsperado, resultado);
    }
}