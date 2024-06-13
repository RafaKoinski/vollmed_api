package med.voll.api.model.consulta;

import med.voll.api.DTO.ConsultaJPA;

import java.time.LocalDateTime;

public record DadosDetahConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetahConsulta(ConsultaJPA consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
