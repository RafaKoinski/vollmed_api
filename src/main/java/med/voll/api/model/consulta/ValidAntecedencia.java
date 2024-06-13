package med.voll.api.model.consulta;

import med.voll.api.erro.ValidacaoExcepion;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidAntecedencia implements  ValidacaoAgendamento {

    public void validar(DadosConsulta dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, dataConsulta).toMinutes();

        if (diferenca < 30){
            throw new ValidacaoExcepion("A consulta deve ser agendada pelo menos 30 minutos de antecedencia");
        }
    }
}
