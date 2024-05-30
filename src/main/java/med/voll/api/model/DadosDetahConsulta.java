package med.voll.api.model;

import java.time.LocalDateTime;

public record DadosDetahConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
