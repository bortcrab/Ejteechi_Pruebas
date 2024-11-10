/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import colecciones.Usuario;
import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;
import interfaces.IUsuarioDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import utilidades.Encriptador;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class UsuarioBOTest {

    @Mock
    private IUsuarioDAO usuarioDAO;

    @Mock
    private Encriptador encriptador;

    @InjectMocks
    private UsuarioBO usuarioBO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void agregarUsuario_UsuarioClienteValido_ReturnSuccess() throws Exception {
        // Arrange
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCorreo("correo@ejemplo.com");
        usuarioDTO.setTipo("cliente");

        Usuario usuarioEnt = new Usuario();
        usuarioEnt.setCorreo("correoEncriptado");

        when(encriptador.encriptar(usuarioDTO.getCorreo())).thenReturn("correoEncriptado");
        when(usuarioDAO.obtenerUsuarioCorreo("correoEncriptado")).thenReturn(null);
        when(usuarioDAO.agregarCliente(any(Usuario.class))).thenReturn(usuarioEnt);

        // Act
        UsuarioDTO resultado = usuarioBO.agregarUsuario(usuarioDTO);

        // Assert
        assertNotNull(resultado);
        verify(usuarioDAO, times(1)).agregarCliente(any(Usuario.class));
    }

    @Test
    public void agregarUsuario_UsuarioClienteInvalido_ReturnFail() throws Exception {
        // ARRANGE
        UsuarioDTO cliente = new UsuarioDTO("Diego", "Valenzuela", "Parra", "", "Prueba@gmail.com", "Prueba123", "", "", "cliente");
        when(usuarioBO.agregarUsuario(cliente)).thenThrow(ObjetosNegocioException.class);

        // ACT
        usuarioBO.agregarUsuario(cliente);

        // ASSERT
        // No ha ASSERT porque se lanza la excepción
    }

}
