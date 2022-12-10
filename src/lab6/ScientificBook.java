package lab6;

import java.util.Objects;

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
        this.index = Index;
    }

    public ScientificBook(String author, int year) {
        super(author, year);
        this.index = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Автор: ").append(getAvtor());
        str.append(" Название книги: ").append(getTitle());
        str.append(" Год издания: ").append(getYear());
        str.append(" Индекс цитируемости: ").append(getIndex());
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIndex());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ScientificBook MyBook = (ScientificBook) obj;
        if (MyBook.getAvtor().equals(this.getAvtor())
                && MyBook.getTitle().equals(this.getTitle())
                && MyBook.getYear() == this.getYear()
                && MyBook.getCost() == this.getCost()
                && MyBook.getIndex() == this.getIndex()
        ) {
            return true;
        } else return false;

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result = null;
        result = super.clone();
        return result;
    }
}