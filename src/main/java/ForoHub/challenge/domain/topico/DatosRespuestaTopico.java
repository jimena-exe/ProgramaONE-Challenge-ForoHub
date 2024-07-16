package ForoHub.challenge.domain.topico;

//DTO
public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   Estado status,
                                   String autor,
                                   String curso) {
}
