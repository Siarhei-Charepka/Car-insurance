package exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException() {
        super("Invalid Data");
    }
}
