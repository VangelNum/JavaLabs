package lab5;

import lab5.exception.BookIndexOutOfBoundsException;
import lab5.exception.HallIndexOutOfBoundsException;
import lab5.exception.InvalidBookCountException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ChildrenLibrary implements ILibrary, Serializable {
    IHall[] libraryHall;

    public IHall[] getLibraryHall() { return libraryHall; }

    public void setLibraryHall(IHall[] libraryHall) {
        this.libraryHall = libraryHall;
    }

    public ChildrenLibrary(int numberOfHalls, int[] sizeBooksInHall) {
        if (numberOfHalls != sizeBooksInHall.length) throw new InvalidBookCountException();
        libraryHall = new ChildrenLibraryHall[numberOfHalls];
        for (int i = 0; i < numberOfHalls; i++) {
            libraryHall[i] = new ChildrenLibraryHall("Undefined", sizeBooksInHall[i]);
        }
    }

    public ChildrenLibrary(IHall[] newlibraryHall) {
        setLibraryHall(newlibraryHall);
    }

    public int getCountOfHalls() {
        return libraryHall.length;
    }

    public int getCountOfBooksInLibrary() {
        int CountOfBooksInLibrary = 0;
        for (int i = 0; i < libraryHall.length; i++) {
            CountOfBooksInLibrary += libraryHall[i].numbersOfBooks();
        }
        return CountOfBooksInLibrary;
    }

    public double getSumOfPricesInLibrary() {
        double SumOfPricesInLibrary = 0.0;
        for (int i = 0; i < getCountOfHalls(); i++) {
            SumOfPricesInLibrary += libraryHall[i].getSumOfPrice();
        }
        return SumOfPricesInLibrary;
    }

    public IHall[] getArrayHalls() {
        return libraryHall;
    }

    public IHall getHall(int index) {
        if (index >= 0 && index < libraryHall.length)
            return libraryHall[index];
        else return null;
    }

    public IBook getBook(int index) {
        if (index >= 0 && index < getCountOfBooksInLibrary())
            return libraryHall[getNumHallIndexBook(index)].getBookByNumber(getNumBookInHall(index));
        else return null;
    }

    public IBook[] getSortBooksByPrice() {
        IBook[] books = new ChildrenBook[getCountOfBooksInLibrary()];
        for (int i = 0; i < getCountOfBooksInLibrary(); i++) {
            books[i] = getBook(i);
        }
        for (int i = 0; i < books.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < books.length; j++) {
                if (getBook(j).getPrice() < getBook(min).getPrice()) min = j;
            }
            books[i] = getBook(min);
        }
        return books;
    }

    public void print() {
        StringBuilder str = new StringBuilder("");
        String str1 = "";
        for (int i = 0; i < getCountOfHalls(); i++) {
            str.append(libraryHall[i].getHallName()).append(" ").append(libraryHall[i].numbersOfBooks());
            str1 = "Название зала: " + libraryHall[i].getHallName() + " Количество книг: " + libraryHall[i].numbersOfBooks();
            for (int j = 0;j<libraryHall[i].numbersOfBooks();j++) {
                String str3 = (String.valueOf(libraryHall[i].getBookByNumber(j)));
                System.out.println(str1 + " " + str3);
            }
        }
    }

    public void changeHall(int i, IHall newLibraryHall) {
        if (i >= 0 && i < libraryHall.length) libraryHall[i] = newLibraryHall;
        else throw new HallIndexOutOfBoundsException(i);
    }

    public void changeBook(int i, IBook newBook) {
        if (i >= 0 && i < getCountOfBooksInLibrary())
            libraryHall[getNumHallIndexBook(i)].changeBook(getNumBookInHall(i), newBook);
    }

    public void addBook(int i, IBook newBook) {
        if (i >= 0 && i < getCountOfBooksInLibrary()) {
            int count = 0;
            for (int j = 0; j < libraryHall.length; j++) {
                if (i <= count + getHallSize(j)) {
                    libraryHall[j].addBook(i - count, newBook);
                    break;
                }
                count += getHallSize(j);
            }
        } else throw new BookIndexOutOfBoundsException(i);
    }

    public void deleteBook(int i) {
        if (i >= 0 && i < getCountOfBooksInLibrary())
            libraryHall[getNumHallIndexBook(i)].delBook(getNumBookInHall(i));
        else throw new BookIndexOutOfBoundsException(i);
    }

    public IBook getBestBook() {
        IBook bestBook = new ChildrenBook();
        double maxPrice = 0.0;
        for (int i = 0; i < libraryHall.length; i++) {
            if (libraryHall[i].getBestBook().getPrice() > maxPrice) {
                maxPrice = libraryHall[i].getBestBook().getPrice();
                bestBook = libraryHall[i].getBestBook();
            }
        }
        return bestBook;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private int getNumHallIndexBook(int i) {
        for (int j = 0; j < getCountOfHalls(); j++) {
            if (libraryHall[j].numbersOfBooks() <= i) {
                i -= libraryHall[j].numbersOfBooks();
            } else {
                return j;
            }
        }
        return -1;
    }

    private int getNumBookInHall(int i) {
        for (int j = 0; j < libraryHall.length; j++) {
            if (libraryHall[j].numbersOfBooks() <= i) i -= libraryHall[j].numbersOfBooks();
            else return i;
        }
        return -1;
    }

    public int getHallSize(int index) {
        return libraryHall[index].numbersOfBooks();
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nКоличество залов: ").append(getLibraryHall().length).append("\n");
        str.append(Arrays.toString(getLibraryHall()));
        return str.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getLibraryHall().length);
        result = 31 * result + Arrays.hashCode(getLibraryHall());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        ChildrenLibrary MyLibrary = (ChildrenLibrary) object;

        if (MyLibrary.getLibraryHall().length == this.getLibraryHall().length
                && Arrays.equals(MyLibrary.getLibraryHall(), this.getLibraryHall())
        ) {
            return true;
        } else return false;
    }



    @Override
    public Object clone() {
        Object result = null;
        try {
            result = super.clone();
            ((ChildrenLibrary) result).libraryHall = new IHall[getCountOfHalls()];
            for (int i = 0; i < getCountOfHalls(); i++) {
                ((ChildrenLibrary) result).libraryHall[i] = (IHall) libraryHall[i].clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
