package med.voll.api.model.consulta;

import med.voll.api.erro.ValidacaoExcepion;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidHorarioFuncionamento implements ValidacaoAgendamento {

    public void validar(DadosConsulta dados){

        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var abertura = dataConsulta.getHour() < 7;
        var encerramento = dataConsulta.getHour() > 18;

        if (domingo || abertura || encerramento){
            throw new ValidacaoExcepion("Consulta fora do horário de funcionamento");
        }
    }
}
