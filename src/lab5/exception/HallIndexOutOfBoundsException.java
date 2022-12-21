package lab5.exception;

public class HallIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public HallIndexOutOfBoundsException() {
        super();
    }
    public HallIndexOutOfBoundsException(String q) {
        super(q);
    }
    public HallIndexOutOfBoundsException(int index) {
        super("Index out of range: " + index);
    }
    public HallIndexOutOfBoundsException(long index) {
        super("Index out of range: " + index);
    }
}