package com.company.doubleLinkedList;
import com.company.science.ScientificLibraryHall;
public class Item {
    public ScientificLibraryHall data;
    public Item next;
    public Item prev;
    public Item(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }
    public Item(ScientificLibraryHall data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
