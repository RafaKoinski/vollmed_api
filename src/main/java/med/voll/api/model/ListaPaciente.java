package med.voll.api.model;

import med.voll.api.DTO.PacienteJPA;

public record ListaPaciente(Long id, String nome, String email, String cpf) {
    public ListaPaciente(PacienteJPA paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
