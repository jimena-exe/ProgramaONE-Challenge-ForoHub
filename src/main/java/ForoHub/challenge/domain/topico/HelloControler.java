package ForoHub.challenge.domain.topico;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControler {

    @GetMapping
    public String hola(){
        return "Hola jeje, primera prueba de conexión";
    }
}
