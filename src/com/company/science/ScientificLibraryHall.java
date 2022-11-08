package com.company.science;
import com.company.children.Book;
import com.company.singleLinkedList.Item;
import com.company.singleLinkedList.LinkedList;
import java.util.Objects;
public class ScientificLibraryHall {
    private String name;
    private LinkedList list = new LinkedList();
    public ScientificLibraryHall(String name, int count) {
        this.name = name;
        for (int i = 0; i < count; i++) {
            this.list.insert(new Book());
        }
    }
    public ScientificLibraryHall(String name, Book[] booksArray) {
        this.name = name;
        for (int i = 0; i < booksArray.length; i++) {
            this.list.insert(booksArray[i]);
        }
    }
    public int countBooks() {
        return this.list.getCount();
    }
    public void printAllTitles() {
        var current = this.list.head;
        do {
            if (current != null) {
                System.out.print(current.data.getTitle());
                current = current.next;
                if (!Objects.equals(current, this.list.head)) {
                    System.out.print(", ");
                }
            }
        }
        while (!Objects.equals(current, this.list.head));
        System.out.println();
    }
    public double getTotalPrice() {
        var current = this.list.head;
        double total = 0.0;
        do {
            if (current != null) {
                total += current.data.getPrice();
                current = current.next;
            }
        }
        while (current != this.list.head);
        return total;
    }
    public Book getBook(int number) {
        Book result = null;
        var current = this.list.head;
        do {
            if (current != null) {
                if (number == 0) {
                    result = current.data;
                }
                current = current.next;
                number--;
            }
        }
        while (current != this.list.head);
        return result;
    }
    public void changeBook(int number, Book newValue) {
        var current = this.list.head;
        do {
            if (current != null) {
                if (number == 0) {
                    current.data = newValue;
                    break;
                }
                current = current.next;
                number--;
            }
        }
        while (current != this.list.head);
    }
    public Book[] getBooks() {
        Book[] result = new Book[this.countBooks()];
        var current = this.list.head;
        for (int i = 0; i < this.countBooks(); i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
    public void addBook(int position, Book newBook) {
        this.list.insertAt(position, newBook);
    }
    public void deleteBook(int position) {
        this.list.deleteAt(position);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Book getBestBook() {
        Book best = new Book();
        Item current = this.list.head;
        for (int i = 0; i < this.countBooks(); i++) {
            if (best.getPrice() <= current.data.getPrice()) {
                best = current.data;
            }
            current = current.next;
        }
        return best;
    }
}