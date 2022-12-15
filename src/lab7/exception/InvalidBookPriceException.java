package lab7.exception;

public class InvalidBookPriceException extends IllegalArgumentException {
    public InvalidBookPriceException() {
        super();
    }
    public InvalidBookPriceException(double cost) {
        super(String.valueOf(cost));
    }
}