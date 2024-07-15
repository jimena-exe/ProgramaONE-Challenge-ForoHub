package ForoHub.challenge.controller;

import ForoHub.challenge.domain.topico.DatosCrearTopico;
import ForoHub.challenge.domain.topico.Topico;
import ForoHub.challenge.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void crearTopico(@RequestBody @Valid DatosCrearTopico datosCrearTopico){
        topicoRepository.save(new Topico(datosCrearTopico));
    }

}
