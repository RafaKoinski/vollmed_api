package med.voll.api.model.consulta;

import java.time.LocalDateTime;

public record DadosDetahConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
