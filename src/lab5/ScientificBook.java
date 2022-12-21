package lab5;

import java.io.Serializable;
import java.util.Objects;

public class ScientificBook extends Book implements Serializable {
    private double citationIndex;

    public double getCitationIndex() {
        return citationIndex;
    }

    public void setCitationIndex(double citationIndex) {
        this.citationIndex = citationIndex;
    }

    public ScientificBook() {
        super();
        setCitationIndex(0);
    }

    public ScientificBook(String author, String name, double price, int year, double citationIndex) {
        super(author, name, price, year);
        setCitationIndex(citationIndex);
    }

    public ScientificBook(String author, int year) {
        super(author, year);
        setCitationIndex(0);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Автор: ").append(getAuthor());
        str.append(" Название книги: ").append(getName());
        str.append(" Год издания: ").append(getYear());
        str.append(" Индекс цитируемости: ").append(getCitationIndex());
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCitationIndex());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        ScientificBook MyBook = (ScientificBook) object;
        if (MyBook.getAuthor().equals(this.getAuthor())
                && MyBook.getName().equals(this.getName())
                && MyBook.getYear() == this.getYear()
                && MyBook.getPrice() == this.getPrice()
                && MyBook.getCitationIndex() == this.getCitationIndex()
        ) {
            return true;
        } else return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}