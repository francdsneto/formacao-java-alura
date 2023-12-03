package estudos.formacaojava.alura.desafios.buscacep.exception;

public class CepInvalidoException extends RuntimeException {

    private String message;

    public CepInvalidoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
