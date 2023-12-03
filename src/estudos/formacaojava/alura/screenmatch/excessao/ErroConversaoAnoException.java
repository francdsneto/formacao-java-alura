package estudos.formacaojava.alura.screenmatch.excessao;

public class ErroConversaoAnoException extends RuntimeException {

    private String mensagem;
    public ErroConversaoAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
