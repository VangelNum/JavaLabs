package lab5;

import lab5.exception.InvalidBookPriceException;

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
        this("Не определено", "Не определено",0.0,0);
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

}