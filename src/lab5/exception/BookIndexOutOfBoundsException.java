package lab5.exception;

public class BookIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public BookIndexOutOfBoundsException() {
        super();
    }
    public BookIndexOutOfBoundsException(String q) {
        super(q);
    }
    public BookIndexOutOfBoundsException(int index) {
        super("Index out of range: " + index);
    }
    public BookIndexOutOfBoundsException(long index) {
        super("Index out of range: " + index);
    }
}