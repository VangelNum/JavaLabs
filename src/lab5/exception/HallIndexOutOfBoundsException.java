package lab5.exception;

public class HallIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public HallIndexOutOfBoundsException(int i) {
        System.out.println("Выход за границы номера зала" + i);
    }
}