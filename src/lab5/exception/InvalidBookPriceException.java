package lab5.exception;

public class InvalidBookPriceException extends IllegalArgumentException{
    public InvalidBookPriceException(double cost) {
        System.out.println("Неправильная сумма");
    }
}