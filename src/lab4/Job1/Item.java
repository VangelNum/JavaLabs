package lab4.Job1;

public class Item {
    public ScientificLibrary data;
    public Item next;

    public Item() {
        data = new ScientificLibrary();
    }

    public Item(ScientificLibrary data) {
        this.data = data;
    }
}