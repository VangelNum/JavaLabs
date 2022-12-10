package lab6;

public class Item {
    public IBook data;
    public Item next;

    public Item() {
        this.next = this;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public Item(IBook i, Item k) {
        data = i;
        next = k;
    }

    public Item(IBook i) {
        data = i;
    }

}