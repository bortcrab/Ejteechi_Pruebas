package iniciarSesion;

import dtos.UsuarioDTO;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeIniciarSesion implements IIniciarSesion {
    
    private final CtrlIniciarSesion ctrlIniciarSesion;

    public FacadeIniciarSesion() {
        this.ctrlIniciarSesion = new CtrlIniciarSesion();
    }
    
    @Override
    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO) throws IniciarSesionException {
        usuarioDTO = ctrlIniciarSesion.iniciarSesion(usuarioDTO);
        
        return usuarioDTO;
    }
}
