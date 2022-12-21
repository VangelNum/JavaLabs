package lab5;

import lab5.exception.InvalidBookPriceException;

import java.io.Serializable;
import java.util.Objects;

public class Book implements IBook, Serializable {

    private String author,name;
    private int year;
    private double price;

    public void setAuthor(String author) {this.author=author;}
    public void setName(String name)   {this.name=name;}
    public void setPrice(double price)  {this.price=price;}
    public void setYear(int year)   {this.year=year;}{
        if (price < 0) throw new InvalidBookPriceException(price);
        this.price = price;
    }
    public String getAuthor(){return author;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getYear(){return year;}

    public Book() {
        setAuthor("Не определено");
        setName("Не определено");
        setPrice(0.0);
        setYear(0);
    }
    public Book(String author, String name,double price,int year) {
        setAuthor(author);
        setName(name);
        setPrice(price);
        setYear(year);
    }
    public Book(String author,int year) {
        this();
        setAuthor(author);
        setYear(year);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Автор: ").append(getAuthor());
        string.append(" Название книги: ").append(getName());
        string.append(" Год издания: ").append(getYear());
        return string.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != this.getClass()) return false;

        Book book = (Book) object;
        if (book.getAuthor().equals(this.author)
                && book.getName().equals(this.name)
                && book.getYear() == this.year
                && book.getPrice() == this.price
        ) {
            return true;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getName());
    }

    @Override
    public Object clone() {
        Object result = null;
        try {
            result = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}