package ForoHub.challenge.controller;

import ForoHub.challenge.domain.usuario.DatosAutenticacionUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUser datosAutenticacionUser){
        Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticacionUser.nombreUsuario(),
                datosAutenticacionUser.clave());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
