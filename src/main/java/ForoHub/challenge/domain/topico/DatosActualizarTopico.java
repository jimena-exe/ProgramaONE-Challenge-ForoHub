package ForoHub.challenge.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO
public record DatosActualizarTopico(
                                    @NotBlank String titulo,
                                    @NotBlank String mensaje,
                                    Estado status,
                                    String autor,
                                    String curso) {


//    @NotNull Long id,
}
