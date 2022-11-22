package lab5;

public class Item {
    public IBook data;
    Item next;

    public Item() {
        data = new ScientificBook();
    }

    public Item(IBook data) {
        this.data = data;
    }
}