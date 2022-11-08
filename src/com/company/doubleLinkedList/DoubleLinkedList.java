package com.company.doubleLinkedList;
import com.company.science.ScientificLibraryHall;
public class DoubleLinkedList {
    public Item head;
    public Item tail;
    private int count;
    public int getCount() {
        return this.count;
    }
    public boolean isEmpty() {
        return this.count == 0;
    }
    public void insert(ScientificLibraryHall data) {
        Item newItem = new Item(data);
        this.head = newItem;
        this.tail = newItem;
        this.tail.next = this.head;
        this.tail.prev = this.head;
//        if (this.head.data == null) {
//            this.head = newItem;
//            this.tail = newItem;
//            this.tail.next = this.head;
//            this.tail.prev = this.head;
//        } else {
//            newItem.next = this.head;
//            this.tail.next = newItem;
//            this.tail = newItem;
//        }
        this.count++;
    }
    public void insertAt(int position, ScientificLibraryHall data) {
        Item current = this.head;
        Item newNode = new Item(data);
        Item tmp = new Item();
        if (position < 0 || position > this.count + 1) {
            System.out.println("Invalid position!");
        } else {
            int i = 0;
            while (i != position) {
                current.prev = current;
                current = current.next;
                i++;
            }
            tmp.data = data;
            current.prev.next = tmp;
            tmp.next = current;
            this.count++;
            tailReset();
        }
    }
    private void tailReset() {
        Item tmp = this.head;
        tail = tmp.prev;
    }
    public void deleteAt(int position) {
        Item current = this.head;
        if (position < 0 || position > this.count) {
            System.out.println("Invalid position!");
        } else {
            int i = 0;
            while (i != position) {
                current.prev = current;
                current = current.next;
                i++;
            }
            current.prev.next = current.next;
            this.count--;
            tailReset();
        }
    }
}