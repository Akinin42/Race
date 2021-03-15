package formula.racecalculator.io;

@SuppressWarnings("serial")
public class NoFileException extends RuntimeException {

    public NoFileException(String messages, Throwable cause) {
        super(messages, cause);
    }

    public NoFileException(String messages) {
        super(messages);
    }
}