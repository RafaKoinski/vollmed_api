package med.voll.api.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.AtualizaPaciente;
import med.voll.api.model.Especialidade;
import med.voll.api.model.Paciente;

@Table(name = "pacientes")
@Entity(name = "Pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private boolean ativo;
    @Embedded
    private EnderecoJPA endereco;

    public PacienteJPA(Paciente paciente) {
        this.ativo = true;
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.cpf = paciente.cpf();
        this.telefone = paciente.telefone();
        this.endereco = new EnderecoJPA(paciente.endereco());
    }

    public void atualizarInfo(AtualizaPaciente dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.telefone() != null)
            this.telefone = dados.telefone();

        if (dados.endereco() != null)
            endereco.atualizaInformacoes(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}
