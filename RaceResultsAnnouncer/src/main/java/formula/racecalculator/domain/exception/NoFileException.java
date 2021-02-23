package formula.racecalculator.domain.exception;

public class NoFileException extends RuntimeException {

    public NoFileException(String messages, Exception e) {
        super(messages + e);
    }

    public NoFileException(String messages) {
        super(messages);
    }
}