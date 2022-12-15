package lab7;

import lab7.exception.BookIndexOutOfBoundsException;
import lab7.exception.HallIndexOutOfBoundsException;
import lab7.exception.InvalidBookCountException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ChildrenLibrary implements ILibrary, Serializable {
    IHall[] libHall;

    public ChildrenLibrary() {

    }

    public IHall[] getLibHall() {
        return libHall;
    }
    public void setLibHall(IHall[] libHall) {
        this.libHall = libHall;
    }

    public ChildrenLibrary(int numberOfHalls,int[] sizeBooksInHall){
        if (numberOfHalls != sizeBooksInHall.length) throw new InvalidBookCountException();
        libHall = new ChildrenLibraryHall[numberOfHalls];
        for (int i = 0; i < numberOfHalls; i ++){
            libHall[i] = new ChildrenLibraryHall("unknown", sizeBooksInHall[i]);
        }
    }
    // Принимающий массив залов.
    public ChildrenLibrary(IHall[] newlibraryHall)
    {
        setLibHall(newlibraryHall);
    }

    public int getNumBooks() {
        int count = 0;
        for (int i = 0; i < libHall.length; i++) {
            count += libHall[i].numbersBooks();
        }
        return count;
    }

    public double getPriceBooks() {
        double sum = 0.0;
        for (int i = 0; i < getNumHall(); i++) {
            sum += libHall[i].getSumPrice();
        }
        return sum;
    }

    public IHall[] arrHall() {
        return libHall;
    }


    public void add(int i, IBook newBook) {
        try {
            if (i >= 0 && i < getNumBooks()) {
                int counter = 0;
                for (int j = 0; j < libHall.length; j++) {
                    if (i <= counter + getHallSizeWithIndex(j)) {
                        libHall[j].dobavBook(i - counter, newBook);
                        break;
                    }
                    counter += getHallSizeWithIndex(j);
                }
            }
        } catch(BookIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void DELETEBook(int number) {
        try {
            if (number >= 0 && number < getNumBooks())
                libHall[getIndexNumHall(number)].delete(getNumBookInHall(number));
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    private int getIndexNumHall(int i) {
        for (int j = 0; j < getNumHall(); j++) {
            if (libHall[j].numbersBooks() <= i) {
                i -= libHall[j].numbersBooks();
            } else {
                return j;
            }
        }
        return -1;
    }

    private int getNumBookInHall(int i) {
        for (int j = 0; j < libHall.length; j++) {
            if (libHall[j].numbersBooks() <= i) i -= libHall[j].numbersBooks();
            else return i;
        }
        return -1;
    }

    public int getHallSizeWithIndex(int index) {
        return libHall[index].numbersBooks();
    }

    public int getNumHall() {
        return libHall.length;
    }

    public IHall getHall(int index) {
        if (index >= 0 && index < libHall.length)
            return libHall[index];
        else return null;
    }

    public IBook getBook(int index) {
        if (index >= 0 && index < getNumBooks())
            return libHall[getIndexNumHall(index)].getBook(getNumBookInHall(index));
        else return null;
    }

    public IBook[] sort() {
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
        StringBuilder str = new StringBuilder("");
        String str1 = "";
        for (int i = 0; i < getNumHall(); i++) {
            str.append(libHall[i].getHallName()).append(" ").append(libHall[i].numbersBooks());
            str1 = "Название зала: " + libHall[i].getHallName() + " Количество книг: " + libHall[i].numbersBooks();
            for (int j = 0;j<libHall[i].numbersBooks();j++) {
                String str3 = (String.valueOf(libHall[i].getBook(j)));
                System.out.println(str1 + " " + str3);
            }
        }
    }

    public void zamenaHoll(int i, IHall newLibraryHall) {
        try {
            if (i >= 0 && i < libHall.length) libHall[i] = newLibraryHall;
        } catch (HallIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            throw new HallIndexOutOfBoundsException(i);
        }

    }

    public void zamenaBook(int i, IBook newBook) {
        if (i >= 0 && i < getNumBooks())
            libHall[getIndexNumHall(i)].izmenenie(getNumBookInHall(i), newBook);
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


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Количество залов: ").append(getLibHall().length).append(" ");
        str.append(Arrays.toString(getLibHall()));
        return str.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getLibHall().length);
        result = 31 * result + Arrays.hashCode(getLibHall());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ChildrenLibrary MyLibrary = (ChildrenLibrary) obj;
        if (MyLibrary.getLibHall().length == this.getLibHall().length
                && Arrays.equals(MyLibrary.getLibHall(), this.getLibHall())
        ) {
            return true;
        } else return false;

    }
    @Override
    public Object clone() {
        Object result = null;
        try {
            result = super.clone();
            ((ChildrenLibrary) result).libHall = new IHall[getNumHall()];
            for (int i = 0; i < getNumHall(); i++) {
                ((ChildrenLibrary) result).libHall[i] = (IHall) libHall[i].clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

}
