package lab6;

import lab6.exception.BookIndexOutOfBoundsException;

import java.util.Arrays;
import java.util.Objects;

public class ChildrenLibraryHall implements IHall {
    private String name;
    private IBook[] books;

    public void setBooks(IBook[] books) {
        this.books = books;
    }

    public String getHallName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildrenLibraryHall(String n, int c) {
        this.name = n;
        books = new ChildrenBook[c];
        for (int i = 0; i < c; i++) {
            books[i] = new ChildrenBook();
        }
    }

    public ChildrenLibraryHall(String n, IBook[] books) {
        this.name = n;
        setBooks(books);
    }

    public IBook[] getBooks() {
        return books;
    }

    public int getNumBook() {
        return books.length;
    }

    public int numbersBooks() {
        return books.length;
    }

    @Override
    public void print() {
        System.out.println(name);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle());
        }
    }

    @Override
    public double getSumPrice() {
        double sum = 0;
        for (int i = 0; i < getNumBook(); i++) {
            sum += books[i].getCost();
        }
        return sum;
    }

    public void nameBook() {
        for (int i = 0; i < getNumBook(); i++) {
            System.out.println(books[i].getTitle());
        }
    }

    public double Cost() {
        double coast = 0.0;
        for (int i = 0; i < books.length; i++) {
            coast += books[i].getCost();
        }
        return coast;
    }

    private boolean isIndex(int i) {
        if (books != null && i >= 0 && i < books.length) {
            return true;
        }
        throw new BookIndexOutOfBoundsException(i);
    }

    @Override
    public IBook getBook(int i) {
        if (isIndex(i)) {
            return books[i];
        }
        return null;
    }

    @Override
    public void izmenenie(int i, IBook newBook) {
        if (isIndex(i)) {
            books[i] = newBook;
        }
    }

    @Override
    public void dobavBook(int i, IBook book) {
        try {
            IBook[] newBooks = new ChildrenBook[books.length + 1];
            for (int j = 0; j < i; j++) {
                newBooks[j] = books[j];
            }
            newBooks[i] = book;
            for (int j = i; j < books.length; j++) {
                newBooks[j + 1] = books[j];
            }
            books = newBooks;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int k) {
        try {
            int size = books.length - 1;
            IBook[] copy = new ChildrenBook[size];
            for (int j = 0; j < k; j++) {
                copy[j] = books[j];
            }
            for (int j = k + 1; j <= size; j++) {
                copy[j - 1] = books[j];
            }
            this.books = copy;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public IBook getBestBook() {
        int n = 0;
        double maxPrice = 0.0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null)
                if (books[i].getCost() > maxPrice) {
                    maxPrice = books[i].getCost();
                    n = i;
                }
        }
        return books[n];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Тип зала: ").append(getHallName());
        str.append(" Количество книг: ").append(getNumBook());
        str.append(" Информация по каждой книге: ").append(Arrays.toString(getBooks()));
        return str.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getHallName());
        result = 31 * result + Arrays.hashCode(getBooks());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ChildrenLibraryHall MyHall = (ChildrenLibraryHall) obj;

        if (MyHall.getNumBook() == this.getNumBook()
                && Arrays.equals(MyHall.getBooks(), this.getBooks())
        ) {
            return true;
        } else return false;

    }

    @Override
    public Object clone(){
        Object result = null;
        try
        {
            result = super.clone();
            ((ChildrenLibraryHall) result).books = new IBook[numbersBooks()];
            for (int i = 0; i < numbersBooks(); i++) {
                ((ChildrenLibraryHall) result).books[i] = (IBook) books[i].clone();
            }
        }catch (Exception e){}
        return result;
    }
}