/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package registrarEmpleado;

import dtos.UsuarioDTO;
import excepciones.RegistrarEmpleadoException;

/**
 *
 * @author franc
 */
public interface IRegistrarEmpleado {
    /**
     * Método para registrar a un usuario del tipo seleccionado.
     *
     * @param usuario Usuario a quien se le creará la cuenta.
     * @return El usuario con sus datos encriptados.
     * @throws RegistrarEmpleadoException si ya hay una cuenta con el correo
     * proporcionado.
     */
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws RegistrarEmpleadoException;
}
