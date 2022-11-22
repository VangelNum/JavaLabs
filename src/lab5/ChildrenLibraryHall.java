package lab5;

import lab5.exception.BookIndexOutOfBoundsException;

public class ChildrenLibraryHall implements IHall {
    private String name;
    private IBook[] books;

    public void setBooks(IBook[] books) {
        this.books = books;
    }

    public String getName() {
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

    public int numbersOfBooks() {
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

    public void nameBooks() {
        for (int i = 0; i < getNumBook(); i++) {
            System.out.println(books[i].getTitle());
        }
    }

    public double allCoast() {
        double coast = 0.0;
        for (int i = 0; i < books.length; i++) {
            coast += books[i].getCost();
        }
        return coast;
    }

    private boolean isIndex(int i) {
        return books != null && i >= 0 && i < books.length;
    }

    @Override
    public IBook getBook(int i) {
        if (isIndex(i)) {
            return books[i];
        } else return null;
    }

    @Override
    public void changeBook(int i, IBook newBook) {
        if (isIndex(i)) {
            books[i] = newBook;
        } else throw new BookIndexOutOfBoundsException(i);
    }

    @Override
    public void addBook(int i, IBook book) {
        IBook[] newBooks = new ChildrenBook[books.length + 1];
        for (int j = 0; j < i; j++) {
            newBooks[j] = books[j];
        }
        newBooks[i] = book;
        for (int j = i; j < books.length; j++) {
            newBooks[j + 1] = books[j];
        }
        books = newBooks;
    }

    @Override
    public void delBook(int i) {
        if (isIndex(i)) {
            int size = books.length - 1;
            IBook[] copy = new ChildrenBook[size];
            for (int j = 0; j < i; j++) {
                copy[j] = books[j];
            }
            for (int j = i + 1; j <= size; j++) {
                copy[j - 1] = books[j];
            }
            this.books = copy;
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

}