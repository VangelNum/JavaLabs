
package lab3;

public class ChildrenBook extends Book {
    private int minAge;

    public ChildrenBook() {
        this.minAge = 0;
    }

    public ChildrenBook(String author, String title, double price, int year, int minAge) {
        super(author,title,price,year);
        this.minAge = minAge;
    }

    public ChildrenBook(String author, int year, int minAge) {
        super(author, year);
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
