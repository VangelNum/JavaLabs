package lab5;

public class ScientificBook extends Book {
    private double index;

    public double getIndex() {
        return index;
    }
    public void setIndex(double index) {
        this.index = index;
    }
    public ScientificBook() {
        super();
        this.index = 0;
    }

    public ScientificBook(String avtor, String title, double cost, int year, double Index) {
        super(avtor, title, cost, year);
        this.index = 0;
    }

    public ScientificBook(String author, int year) {
        super(author, year);
        this.index = 0;
    }

}