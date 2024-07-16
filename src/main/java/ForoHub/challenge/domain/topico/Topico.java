package ForoHub.challenge.domain.topico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Enumerated(EnumType.STRING)
    private Estado status;
    private String autor;
    private String curso;

    public Topico(DatosCrearTopico datosCrearTopico) {
        this.titulo = datosCrearTopico.titulo();
        this.mensaje = datosCrearTopico.mensaje();
        this.status = datosCrearTopico.status();
        this.autor = datosCrearTopico.autor();
        this.curso = datosCrearTopico.curso();
    }

    public void actualizarDatosTopico(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }
        if (datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }
        if (datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }

    }

}
