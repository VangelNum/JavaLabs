package lab4.Job2;

import lab4.Job1.ScientificLibraryHall;

public class Item2 {
    public ScientificLibraryHall data;
    public Item2 prev;
    public Item2 next;

    public Item2(String hallName, int numBooks) {
        data = new ScientificLibraryHall(hallName, numBooks);
    }

    public Item2(ScientificLibraryHall data) {
        this.data = data;
    }
}
