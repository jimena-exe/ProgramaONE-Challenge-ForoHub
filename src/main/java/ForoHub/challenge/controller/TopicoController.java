package ForoHub.challenge.controller;

import ForoHub.challenge.domain.topico.DatosCrearTopico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    public void crearTopico(@RequestBody DatosCrearTopico datosCrearTopico){
        System.out.println(datosCrearTopico);
    }

}
