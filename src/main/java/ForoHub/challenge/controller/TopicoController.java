package ForoHub.challenge.controller;

import ForoHub.challenge.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
                topico.getStatus(), topico.getAutor(), topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }// status.toString()

    //Actualizar un topico
    //Poner un corrector de errores para el campo ID "El id no debe estar vacío".
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico, @PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id); //busca el tópico
        if (id.describeConstable().isPresent()) {
            System.out.println("El topico está presente en la bd");
            topico.actualizarDatosTopico(datosActualizarTopico); //mando los datos a actualizar
            System.out.println("Tópico actualizado");
        }
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getStatus(),
                topico.getAutor(), topico.getCurso()));
    }


    //Eliminar un tópico
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
//        if (id.describeConstable().isPresent()) {
//
//        }
    }


}
