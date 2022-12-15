package lab6;

public class Item2 {
    public IHall data;
    public Item2 prev;
    public Item2 next;

    public Item2(String hallName, int numBooks) {
        data = new ScientificLibraryHall(hallName, numBooks);
    }

    public Item2(IHall l) {
        data = l;
        this.prev = null;
        this.next = null;
    }

    public Item2() {
        this.prev = this;
        this.next = this;
        this.data = null;
    }

}