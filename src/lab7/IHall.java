package lab7;

import java.io.Serializable;

public interface IHall extends Cloneable, Serializable {
    public void setBooks(IBook[] books);
    public IBook getBook(int k);

    public String getHallName();

    public void setName(String name);

    public int numbersBooks();

    public void print();

    public double getSumPrice();

    public IBook getBestBook();

    public void izmenenie(int k, IBook book);

    public void dobavBook(int k, IBook book);

    public void delete(int k);

    public Object clone() throws CloneNotSupportedException;


}