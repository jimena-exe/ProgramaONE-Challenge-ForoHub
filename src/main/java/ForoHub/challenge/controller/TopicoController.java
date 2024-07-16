package ForoHub.challenge.controller;

import ForoHub.challenge.domain.topico.DatosCrearTopico;
import ForoHub.challenge.domain.topico.DatosListadoTopico;
import ForoHub.challenge.domain.topico.Topico;
import ForoHub.challenge.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    //Crear tópico
    @PostMapping
    public void crearTopico(@RequestBody DatosCrearTopico datosCrearTopico){
            topicoRepository.save(new Topico(datosCrearTopico));
    }

    //Listar todos los tópicos
    @GetMapping
    public Page<DatosListadoTopico> mostrarTodosLosTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);

    }

    //Listar un solo tópico por id
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosListadoTopico> mostrarDatoTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosListadoTopico(
                topico.getId(),topico.getTitulo(), topico.getMensaje(),
                topico.getStatus(), topico.getAutor(), topico.getCurso().toString());
        return ResponseEntity.ok(datosTopico);
        }


}
