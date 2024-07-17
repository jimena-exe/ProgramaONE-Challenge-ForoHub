package ForoHub.challenge.controller;

import ForoHub.challenge.domain.usuario.DatosAutenticacionUser;
import ForoHub.challenge.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ForoHub.challenge.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenService tokenService;

    @Autowired
    private TokenService tokenS;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUser datosAutenticacionUser){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUser.nombreUsuario(),
                datosAutenticacionUser.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenS.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        authenticationManager.authenticate(authToken);
        return ResponseEntity.ok().build();
    }
}
