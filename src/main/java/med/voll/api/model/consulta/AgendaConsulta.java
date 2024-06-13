package med.voll.api.model.consulta;

import med.voll.api.DTO.ConsultaJPA;
import med.voll.api.DTO.MedicoJPA;
import med.voll.api.erro.ValidacaoExcepion;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidacaoAgendamento> validadores;

    public void agendar(DadosConsulta dados){
        if (!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoExcepion("Id do paciente não existe!");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoExcepion("Id do médico informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new ConsultaJPA(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }

    private MedicoJPA escolherMedico(DadosConsulta dados) {
        if (dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null){
            throw new ValidacaoExcepion("A especialidade é obrigatória quando o médico não for escolhido!");
        }

        return medicoRepository.escolherAleatMedicoLivreData(dados.especialidade(), dados.data());
    }
}
