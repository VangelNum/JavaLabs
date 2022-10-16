package libraries;

public class ScientificBook extends Book {
    private double Index;

    public double getIndex() {
        return Index;
    }

    public void setIndex(double Index) {
        this.Index = Index;
    }

    public ScientificBook() {
        this.Index = 0;
    }

    public ScientificBook(String author, int year, double index) {
        super(author, year);
        this.Index = Index;
    }

    public ScientificBook(String author, String title, double price, int year, double Index) {
        super(author,title,price,year);
        this.Index = Index;
    }


}
