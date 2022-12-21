package lab5;

import java.io.Serializable;
import java.util.Objects;

public class ChildrenBook extends Book implements Cloneable, Serializable {
    private int minAge;
    public int getMinAge() {
        return minAge;
    }
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
    public ChildrenBook() {
        super();
        setMinAge(0);
    }
    public ChildrenBook(String author, String name,double price,int year,int minAge) {
        super(author,name,price,year);
        setMinAge(minAge);
    }
    public ChildrenBook(String author,int year) {
        super(author,year);
        setMinAge(0);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Автор: ").append(getAuthor());
        str.append(" Название книги: ").append(getName());
        str.append(" Год издания: ").append(getYear());
        str.append(" Минимальный возраст: ").append(getMinAge());
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMinAge());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        ChildrenBook book = (ChildrenBook) object;
        if (book.getAuthor().equals(this.getAuthor())
                && book.getName().equals(this.getName())
                && book.getYear() == this.getYear()
                && book.getPrice() == this.getPrice()
                && book.getMinAge() == this.minAge
        ) {
            return true;
        } else return false;
    }

    @Override
    public Object clone(){
        Object result = null;
        result = super.clone();
        return result;
    }
}
