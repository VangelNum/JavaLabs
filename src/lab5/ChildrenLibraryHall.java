package lab5;

import lab5.exception.BookIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ChildrenLibraryHall implements IHall, Serializable {
    private String hallName;
    private IBook[] books;
    public void setBooks(IBook[] books) {
        this.books = books;
    }
    public String getHallName() {return hallName;}
    public void setHallName(String hallName) {this.hallName =hallName;}
    public ChildrenLibraryHall(String hallName,int countOfBooks) {
        setHallName(hallName);
        books = new ChildrenBook[countOfBooks];
        for (int i = 0; i < countOfBooks; i++) {
            books[i] = new ChildrenBook();
        }
    }
    public ChildrenLibraryHall(String hallName,IBook[] books){
        setHallName(hallName);
        setBooks(books);
    }
    public IBook[] getBooks() {
        return books;
    }
    public int getNumBook(){
        return books.length;
    }
    public int numbersOfBooks(){
        return books.length;
    }
    @Override
    public void print() {
        System.out.println(hallName);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
    }
    @Override
    public double getSumOfPrice() {
        double sum=0;
        for (int i = 0; i < getNumBook(); i++) {sum += books[i].getPrice();}
        return sum;}
    public void nameBooks() {
        for (int i = 0; i < getNumBook(); i++)
        {System.out.println(books[i].getName());}
    }
    public double allPrices() {
        double prices = 0.0;
        for (int i = 0; i < books.length; i++) {prices += books[i].getPrice();}
        return prices;
    }
    private boolean isIndex(int i){
        return books != null && i >= 0 && i < books.length;
    }
    @Override
    public IBook getBookByNumber(int i){
        if (isIndex(i)){
            return books[i];
        } else return null;
    }
    @Override
    public void changeBook(int i,IBook newBook) {
        if (isIndex(i)){books[i]=newBook;}
        else throw new BookIndexOutOfBoundsException(i);
    }
    @Override
    public void addBook(int i, IBook book){
        IBook[] newBooks = new ChildrenBook[books.length+1];
        for (int j = 0; j < i; j++) {
            newBooks[j] = books[j];
        }
        newBooks[i] = book;
        for (int j = i; j < books.length; j++) {
            newBooks[j+1] = books[j];
        }
        books = newBooks;
    }
    @Override
    public void delBook(int i){
        if (isIndex(i)) {
            int size = books.length - 1;
            IBook[] copy = new ChildrenBook[size];
            for (int j = 0; j < i; j++) {
                copy[j]=books[j];
            }
            for (int j = i+1; j <= size; j++) {
                copy[j-1] = books[j];
            }
            this.books = copy;
        }
    }
    @Override
    public IBook getBestBook(){
        int q = 0;
        double maxPrice = 0.0;
        for (int i = 0; i < books.length; i++){
            if (books[i] != null)
                if (books[i].getPrice() > maxPrice){
                    maxPrice = books[i].getPrice();
                    q = i;
                }
        }
        return books[q];
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
            ((ChildrenLibraryHall) result).books = new IBook[numbersOfBooks()];
            for (int i = 0; i < numbersOfBooks(); i++) {
                ((ChildrenLibraryHall) result).books[i] = (IBook) books[i].clone();
            }
        }catch (Exception e){}
        return result;
    }
}