package lab6.exception;

public class InvalidBookCountException extends IllegalArgumentException {
    public InvalidBookCountException() {
        super();
    }

    public InvalidBookCountException(String s) {
        super(s);
    }

    public InvalidBookCountException(String mes, Throwable thow) {
        super(mes, thow);
    }
}