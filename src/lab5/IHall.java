package lab5;

import java.io.Serializable;

public interface IHall extends Cloneable, Serializable {
    public void setBooks(IBook[] books);
    public void setHallName(String hallName);
    public String getHallName();
    public int numbersOfBooks();
    public void print();
    public double getSumOfPrice();
    public IBook getBookByNumber(int i);
    public IBook getBestBook();
    public void changeBook(int i, IBook book);
    public void addBook(int i, IBook book);
    public void delBook(int i);

    public Object clone() throws CloneNotSupportedException;
}