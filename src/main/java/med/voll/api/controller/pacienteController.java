package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.PacienteJPA;
import med.voll.api.model.AtualizaPaciente;
import med.voll.api.model.ListaPaciente;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class pacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid Paciente paciente){
        repository.save(new PacienteJPA(paciente));
    }
    @GetMapping
    public Page<ListaPaciente> ListarPaciente(@PageableDefault(size = 10, sort = {"nome"}) Pageable pag){
        return repository.findAllByAtivoTrue(pag).map(ListaPaciente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public  void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }
}
