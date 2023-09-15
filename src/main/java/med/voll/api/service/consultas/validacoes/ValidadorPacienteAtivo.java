package med.voll.api.service.consultas.validacoes;

import med.voll.api.domain.dto.DadosAgendamentoConsulta;
import med.voll.api.repository.PacienteRepository;
import med.voll.api.utils.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var pacienteEstaAtivo = repository.findAtivoById(dadosAgendamentoConsulta.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com paciente exclusivo");
        }
    }
}
