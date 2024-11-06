package iniciarSesion;

import dtos.UsuarioDTO;
import interfaces.IUsuarioBO;
import excepciones.ObjetosNegocioException;
import implementaciones.UsuarioBO;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlIniciarSesion {

    private final IUsuarioBO usuarioBO;

    public CtrlIniciarSesion() {
        this.usuarioBO = new UsuarioBO();
    }

    public UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws IniciarSesionException {
        try {
            usuario = usuarioBO.obtenerUsuarioCorreoContra(usuario);
            return usuario;
        } catch (ObjetosNegocioException one) {
            throw new IniciarSesionException(one.getMessage());
        }
    }
}
