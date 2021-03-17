package formula.racecalculator.exceptions;

public class NoFileException extends RuntimeException {

    public NoFileException(String messages, Throwable cause) {
        super(messages, cause);
    }

    public NoFileException(String messages) {
        super(messages);
    }
}