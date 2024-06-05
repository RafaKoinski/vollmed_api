package med.voll.api.erro;

public class ValidacaoExcepion extends RuntimeException {
    public ValidacaoExcepion(String mensagem) {
        super(mensagem);
    }
}
