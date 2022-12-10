package lab6;

import lab6.exception.InvalidBookPriceException;

import java.util.Objects;

public class Book implements IBook {
    private String avtor, title;
    private double cost;
    private int year;

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setCost(double cost) {
        if (cost < 0) throw new InvalidBookPriceException(cost);
        this.cost = cost;
    }


    public double getCost() {
        return cost;
    }

    public Book() {
        this("Не определено", "Не определено", 0.0, 0);
    }

    public Book(String avtor, String title, double cost, int year) {
        this.avtor = avtor;
        this.title = title;
        this.cost = cost;
        this.year = year;
    }

    public Book(String avtor, int year) {
        this();
        this.avtor = avtor;
        this.year = year;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Автор: ").append(getAvtor());
        str.append(" Название книги: ").append(getTitle());
        str.append(" Год издания: ").append(getYear());
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Book MyBook = (Book) obj;
        if (MyBook.getAvtor().equals(this.avtor)
                && MyBook.getTitle().equals(this.title)
                && MyBook.getYear() == this.year
                && MyBook.getCost() == this.cost
        ) {
            return true;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAvtor(), getTitle());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result = null;
        try
        {
            result = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.err.println(e.getMessage());
        }
        return result;
    }
}