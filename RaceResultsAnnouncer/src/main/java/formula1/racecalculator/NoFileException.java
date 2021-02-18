package formula1.racecalculator;

public class NoFileException extends RuntimeException {

    public NoFileException(String messages, Exception e) {
        super(messages + e.getMessage());
    }

    public NoFileException(String messages) {
        super(messages);
    }
}