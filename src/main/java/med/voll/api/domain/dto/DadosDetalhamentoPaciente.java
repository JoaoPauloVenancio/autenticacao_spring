package med.voll.api.domain.dto;

import lombok.Data;
import med.voll.api.domain.model.Endereco;
import med.voll.api.domain.model.Paciente;

@Data
public class DadosDetalhamentoPaciente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Endereco endereco;

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
        this.cpf = paciente.getCpf();
        this.endereco = paciente.getEndereco();
    }
}
