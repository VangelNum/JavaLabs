package lab7;

import java.io.Serializable;

public class Item implements Cloneable, Serializable {
    public IBook data;
    public Item next;

    public Item() {
        this.next = this;
    }

    public Item(IBook i, Item k) {
        data = i;
        next = k;
    }

    public Item(IBook i) {
        data = i;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}