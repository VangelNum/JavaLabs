package lab5.exception;

public class InvalidBookCountException extends IllegalArgumentException {
    public InvalidBookCountException() {
        super();
    }
    public InvalidBookCountException(String q) {
        super(q);
    }
    public InvalidBookCountException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidBookCountException(Throwable cause) {
        super(cause);}
}