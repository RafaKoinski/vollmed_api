package med.voll.api.DTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.Endereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoJPA {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String complemento;
    private String num;

    public EnderecoJPA(Endereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.num = dados.num();
        this.complemento = dados.complemento();
    }


    public void atualizaInformacoes(Endereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.num() != null) {
            this.num = dados.num();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }

}

