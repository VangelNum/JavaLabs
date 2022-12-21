package lab5;

import java.io.Serializable;

public interface ILibrary extends Cloneable, Serializable {
    public int getCountOfHalls();
    public int getCountOfBooksInLibrary();
    public double getSumOfPricesInLibrary();
    public IHall[] getArrayHalls();
    public IHall getHall(int index);
    public IBook getBook(int index);
    public IBook[] getSortBooksByPrice();
    public void print();
    public void changeHall(int i, IHall newLibraryHall);
    public void changeBook(int i, IBook newBook);
    public void addBook(int i , IBook newBook);
    public void deleteBook(int i);
    public IBook getBestBook();
    public boolean isEmpty();

    public Object clone() throws CloneNotSupportedException;
}
