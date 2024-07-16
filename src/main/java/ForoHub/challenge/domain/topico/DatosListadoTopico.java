package ForoHub.challenge.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO
public record DatosListadoTopico( Long id,
                                  String titulo,
                                  String mensaje,
                                  Estado status,
                                  String autor,
                                  String curso) {
    //Constructor
    public DatosListadoTopico(Topico topico){
        this(   topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
