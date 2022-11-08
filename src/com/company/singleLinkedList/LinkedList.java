package com.company.singleLinkedList;

import com.company.children.Book;

public class LinkedList {
    public Item head;
    public Item tail;
    private int count = 0;

    public LinkedList() {
        this.head = new Item();
        this.head.data = null;
        this.head.next = this.head;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void insert(Book data) {
        Item newItem = new Item(data);
        if (this.head.data == null) {
            this.head = newItem;
            this.tail = newItem;
            this.tail.next = head;
        } else {
            newItem.next = this.head;
            this.tail.next = newItem;
            this.tail = newItem;
        }
        this.count++;
    }

    public void insertAt(int position, Book data) {
        Item current = this.head;
        Item previous = this.head;
        Item newNode = new Item(data);

        Item tmp = this.head;
        if (position < 0 || position > this.count) {
            System.out.println("Invalid position!");
        } else {
            int i = 0;
            while (i != position) {
                previous = current;
                current = current.next;
                i++;
            }
            tmp.data = data;
            previous.next = tmp;
            tmp.next = current;
            this.count++;
            tailReset();
        }
    }


    private void tailReset() {
        Item tmp = this.head;
        for (int i = 0; i < this.count - 1; i++) {
            tmp = tmp.next;
        }
        tail = tmp;
    }

    public boolean Remove(Book data) {
        Item current = head;
        Item previous = null;
        if (this.isEmpty()) {
            return false;
        }
        do {
            if (current.data.equals(data)) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current == this.tail)
                        this.tail = previous;
                } else {
                    if (this.count == 1) {
                        this.head.data = this.tail.data = null;
                    } else {
                        this.head = current.next;
                        this.tail.next = current.next;
                    }
                }
                this.count--;
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != this.head);
        return false;
    }

    public void deleteAt(int position) {
        Item current = this.head;
        Item previous = this.head;
        if (position < 0 || position > this.count) {
            System.out.println("Invalid position!");
        } else {
            int i = 0;
            while (i != position) {
                previous = current;
                current = current.next;
                i++;
            }
            previous.next = current.next;
            this.count--;
            tailReset();
        }
    }
}
