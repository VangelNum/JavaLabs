package lab5.exception;

public class InvalidBookPriceException extends IllegalArgumentException{
    public InvalidBookPriceException() {
        super();
    }
    public InvalidBookPriceException(double price) {
        super(String.valueOf(price));
    }
    public InvalidBookPriceException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidBookPriceException(Throwable cause) {
        super(cause);
    }
}