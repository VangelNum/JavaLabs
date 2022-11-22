package lab5.exception;

public class BookIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public BookIndexOutOfBoundsException(int i){
        System.out.println("выход за границы номера книг ");
    }
    public BookIndexOutOfBoundsException(String i){
        System.out.println("выход за границы номера книг " + i);
    }
}