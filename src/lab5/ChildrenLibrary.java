package lab5;

import lab5.exception.BookIndexOutOfBoundsException;
import lab5.exception.HallIndexOutOfBoundsException;
import lab5.exception.InvalidBookCountException;

public class ChildrenLibrary implements ILibrary {
    IHall[] libHall;

    public IHall[] getLibHall() {
        return libHall;
    }
    public void setLibHall(IHall[] libHall) {
        this.libHall = libHall;
    }

    public ChildrenLibrary(int numberHall, int[] sizeBooksInHall) {
        if (numberHall != sizeBooksInHall.length) throw new InvalidBookCountException();
        libHall = new ChildrenLibraryHall[numberHall];
        for (int i = 0; i < numberHall; i++) {
            libHall[i] = new ChildrenLibraryHall("unknown", sizeBooksInHall[i]);
        }
    }

    public ChildrenLibrary(IHall[] newLibraryHall) {
        setLibHall(newLibraryHall);
    }

    public int getNumHall() {
        return libHall.length;
    }

    public int getNumBooks() {
        int sum = 0;
        for (int i = 0; i < libHall.length; i++) {
            sum += libHall[i].numbersOfBooks();
        }
        return sum;
    }

    public double getPriceBooks() {
        double sum = 0.0;
        for (int i = 0; i < getNumHall(); i++) {
            sum += libHall[i].getSumPrice();
        }
        return sum;
    }

    public IHall[] getArrayHalls() {
        return libHall;
    }

    public IHall getHall(int index) {
        if (index >= 0 && index < libHall.length)
            return libHall[index];
        else return null;
    }

    public IBook getBook(int index) {
        if (index >= 0 && index < getNumBooks())
            return libHall[getNumHallIndexBook(index)].getBook(getNumBookInHall(index));
        else return null;
    }

    public IBook[] getSort() {
        IBook[] books = new ChildrenBook[getNumBooks()];
        for (int i = 0; i < getNumBooks(); i++) {
            books[i] = getBook(i);
        }
        for (int i = 0; i < books.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < books.length; j++) {
                if (getBook(j).getCost() < getBook(min).getCost()) min = j;
            }
            books[i] = getBook(min);
        }
        return books;
    }

    public void print() {
        StringBuilder str = new StringBuilder("library");
        for (int i = 0; i < getNumHall(); i++) {
            str.append(libHall[i].getName()).append(libHall[i].numbersOfBooks());
        }
    }

    public void changeHall(int i, IHall newLibraryHall) {
        if (i >= 0 && i < libHall.length) libHall[i] = newLibraryHall;
        else throw new HallIndexOutOfBoundsException(i);
    }

    public void changeBook(int i, IBook newBook) {
        if (i >= 0 && i < getNumBooks())
            libHall[getNumHallIndexBook(i)].changeBook(getNumBookInHall(i), newBook);
    }

    public void addBook(int i, IBook newBook) {
        if (i >= 0 && i < getNumBooks()) {
            int counter = 0;
            for (int j = 0; j < libHall.length; j++) {
                if (i <= counter + getHallSize(j)) {
                    libHall[j].addBook(i - counter, newBook);
                    break;
                }
                counter += getHallSize(j);
            }
        } else throw new BookIndexOutOfBoundsException(i);
    }

    public void deleteBook(int i) {
        if (i >= 0 && i < getNumBooks())
            libHall[getNumHallIndexBook(i)].delBook(getNumBookInHall(i));
        else throw new BookIndexOutOfBoundsException(i);
    }

    public IBook getBestBook() {
        IBook bestBook = new ChildrenBook();
        double maxPrice = 0.0;
        for (int i = 0; i < libHall.length; i++) {
            if (libHall[i].getBestBook().getCost() > maxPrice) {
                maxPrice = libHall[i].getBestBook().getCost();
                bestBook = libHall[i].getBestBook();
            }
        }
        return bestBook;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private int getNumHallIndexBook(int i) {
        for (int j = 0; j < getNumHall(); j++) {
            if (libHall[j].numbersOfBooks() <= i) {
                i -= libHall[j].numbersOfBooks();
            } else {
                return j;
            }
        }
        return -1;
    }

    private int getNumBookInHall(int i) {
        for (int j = 0; j < libHall.length; j++) {
            if (libHall[j].numbersOfBooks() <= i) i -= libHall[j].numbersOfBooks();
            else return i;
        }
        return -1;
    }

    public int getHallSize(int index) {
        return libHall[index].numbersOfBooks();
    }
}
