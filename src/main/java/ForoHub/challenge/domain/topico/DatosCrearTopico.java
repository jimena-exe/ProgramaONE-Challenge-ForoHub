package ForoHub.challenge.domain.topico;

//DTO
public record DatosCrearTopico(String idUsuario,
                               String titulo,
                               String mensaje,
                               Estado status,
                               String autor,
                               String curso) {
}
