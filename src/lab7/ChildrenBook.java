package lab7;

import java.io.Serializable;
import java.util.Objects;

public class ChildrenBook extends Book implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Автор: ").append(getAvtor());
        str.append(" Название книги: ").append(getTitle());
        str.append(" Год издания: ").append(getYear());
        str.append(" Минимальный возраст: ").append(getVozr());
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVozr());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ChildrenBook MyBook = (ChildrenBook) obj;
        if (MyBook.getAvtor().equals(this.getAvtor())
                && MyBook.getTitle().equals(this.getTitle())
                && MyBook.getYear() == this.getYear()
                && MyBook.getCost() == this.getCost()
                && MyBook.getVozr() == this.vozr
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
