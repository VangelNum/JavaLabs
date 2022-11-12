package lab4.Job1;

public class ScientificLibrary extends Book {

    private double index;

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public ScientificLibrary() {
        super();
        this.index = 0;
    }


    public ScientificLibrary(String author, String name, double price, int year, double index) {
        super(author, name, price, year);
        this.index = index;

    }

    public ScientificLibrary(String author, int year) {
        super(author, year);
        this.index = 0;

    }


}
