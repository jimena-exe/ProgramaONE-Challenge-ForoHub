package ForoHub.challenge.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO
public record DatosCrearTopico(@NotBlank String idUsuario,
                               @NotBlank String titulo,
                               @NotBlank String mensaje,
                               @NotNull Estado status,
                               @NotBlank String autor,
                               @NotBlank String curso) {
}
