package med.voll.api.service.consultas.validacoes;

import med.voll.api.domain.dto.DadosAgendamentoConsulta;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.utils.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findByAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("consulta nao pode ser agendada com medico excluido");

        }
    }
}
