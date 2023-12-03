package estudos.formacaojava.alura.desafios.buscacep.exception;

public class ParametroInvalidoException extends RuntimeException {

    private String message;

    public ParametroInvalidoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
