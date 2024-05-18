package med.voll.api.model;

import jakarta.validation.constraints.NotNull;
import med.voll.api.DTO.EnderecoJPA;

public record AtualizaMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        Endereco endereco) {

}
