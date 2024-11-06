/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarEmpleado;

import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;
import excepciones.RegistrarEmpleadoException;
import implementaciones.UsuarioBO;
import interfaces.IUsuarioBO;

/**
 *
 * @author franc
 */
public class CtrlRegistrarEmpleado {
    private final IUsuarioBO usuarioBO;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public CtrlRegistrarEmpleado() {
        usuarioBO = new UsuarioBO();
    }

    /**
     * Método para crear la cuenta de un usuario del tipo "cliente".
     *
     * @param usuario Usuario a quien se le creará la cuenta.
     * @return El usuario con sus datos encriptados.
     * @throws CrearCuentaClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    public UsuarioDTO registrarEmpleado(UsuarioDTO usuario) throws RegistrarEmpleadoException {
        try {
            // Mandamos a crear la cuenta y devolvemos el usuario con sus datos encriptados.
            return usuarioBO.agregarUsuario(usuario);
        } catch (ObjetosNegocioException one) {
            // Si ya existe una cuenta con el correo proporcionado.
            throw new RegistrarEmpleadoException(one.getMessage());
        }
    }
}
