package lab6.exception;

public class BookIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public BookIndexOutOfBoundsException(int i){
        super(i);
    }
    public BookIndexOutOfBoundsException(String i){
        super(i);
    }
    public BookIndexOutOfBoundsException(){
        super();
    }

}