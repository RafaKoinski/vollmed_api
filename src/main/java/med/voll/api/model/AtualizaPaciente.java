package med.voll.api.model;

import jakarta.validation.constraints.NotNull;

public record AtualizaPaciente(
        @NotNull
        long id,
        String nome,
        String telefone,
        Endereco endereco) {
}
