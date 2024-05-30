package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.DadosConsulta;
import med.voll.api.model.DadosDetahConsulta;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosConsulta dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetahConsulta(null, null, null, null));
    }

}
