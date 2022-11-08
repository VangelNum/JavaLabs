package com.company.singleLinkedList;

import com.company.children.Book;

public class Item {
    public Book data;
    public Item next;

    public Item() {
        this.data = null;
        this.next = null;
    }

    public Item(Book data) {
        this.data = data;
        this.next = null;
    }

    public Item(Book data, Item next) {
        this.data = data;
        this.next = next;
    }
}
