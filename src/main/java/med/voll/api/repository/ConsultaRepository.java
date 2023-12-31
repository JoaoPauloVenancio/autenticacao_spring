package med.voll.api.repository;

import med.voll.api.domain.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    Boolean existsByPacienteIdAndDataBetween(Long aLong, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
