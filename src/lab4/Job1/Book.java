package lab4.Job1;

public class Book {

    private String author, title;
    private int year;
    private double price;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.title = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public Book() {
        this("Не определено", "Не определено", 0.0, 0);
    }

    public Book(String author, String name, double price, int year) {
        this.author = author;
        this.title = name;
        this.price = price;
        this.year = year;
    }

    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }
}
