package lab5.exception;

public class InvalidBookCountException extends IllegalArgumentException{
    public InvalidBookCountException(){
        System.out.println("Неверное количество книг ");
    }
}