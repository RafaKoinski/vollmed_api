package med.voll.api.model;

import med.voll.api.DTO.MedicoJPA;

public record ListaMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public ListaMedico(MedicoJPA medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
