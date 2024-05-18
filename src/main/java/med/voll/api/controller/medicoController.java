package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.MedicoJPA;
import med.voll.api.model.AtualizaMedico;
import med.voll.api.model.ListaMedico;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class medicoController {
    @Autowired //Anotação para o Spring saber que ele que vai estanciar essa classe
    private MedicoRepository repository;
    @PostMapping
    @Transactional //Por conta da transação escrita com o banco de dados (Não entendi ao certo)
    public ResponseEntity cadastrar(@RequestBody @Valid Medico dados, UriComponentsBuilder uriBuilder) {
        var medico = new MedicoJPA(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoJPA(medico));
    }
    @GetMapping
    public ResponseEntity<Page<ListaMedico>> ListarMedico(@PageableDefault(size = 10, sort = {"nome"}) Pageable pag){
        return ResponseEntity.ok(repository.findAllByAtivoTrue(pag).map(ListaMedico::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        medico = repository.getReferenceById(dados.id());
        return ResponseEntity.ok(new MedicoJPA(medico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public  ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new MedicoJPA(medico));
    }

}
