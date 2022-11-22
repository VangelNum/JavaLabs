package lab5;

public class ChildrenBook extends Book {
    private int vozr;

    public int getVozr() {
        return vozr;
    }

    public void setVozr(int vozr) {
        this.vozr = vozr;
    }

    public ChildrenBook() {
        super();
        this.vozr = 0;
    }

    public ChildrenBook(String a, int g, int v) {
        super(a, g);
        setVozr(v);
    }

    public ChildrenBook(String a, String n, double c, int g, int v) {
        super(a, n, c, g);
        setVozr(v);
    }

}
