package med.voll.api.service.consultas.validacoes;

import med.voll.api.domain.dto.DadosAgendamentoConsulta;
import med.voll.api.utils.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAbertura || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("consulta fora do horario de funcionamento");
        }
    }
}
