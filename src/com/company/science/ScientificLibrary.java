package com.company.science;


import com.company.children.Book;
import com.company.doubleLinkedList.Item;
import com.company.doubleLinkedList.DoubleLinkedList;
public class ScientificLibrary {
    private DoubleLinkedList list = new DoubleLinkedList();

    public ScientificLibrary(int count, int[] booksInHallCount) {
        for (int i = 0; i < count; i++) {
            list.insert(new ScientificLibraryHall("Не определено", booksInHallCount[i]));
        }
    }

    public ScientificLibrary(ScientificLibraryHall[] halls) {
        for (int i = 0; i < halls.length; i++) {
            list.insert(halls[i]);
        }
    }

    private static Book[] sortArray(Book[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getPrice() < arr[j + 1].getPrice()) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        }
        return arr;
    }

    public int getHallAmount() {
        return this.list.getCount();
    }

    public int getHallBooks(int position) {
        Item current = this.list.head;
        do {
            if (current != null) {
                if (position == 0) {
                    return current.data.countBooks();
                }
                position--;
                current = current.next;
            }
        }
        while (current != this.list.head);
        return 0;
    }

    public int getTotalBooksAmount() {
        int total = 0;
        Item current = this.list.head;
        do {
            if (current != null) {
                total += current.data.countBooks();
                current = current.next;
            }
        }
        while (current != this.list.head);
        return total;
    }

    public ScientificLibraryHall getHall(int position) {
        Item current = this.list.head;
        do {
            if (current != null) {
                if (position == 0) {
                    return current.data;
                }
                position--;
                current = current.next;
            }
        }
        while (current != this.list.head);
        return null;
    }

    public ScientificLibraryHall[] getHalls() {
        ScientificLibraryHall[] halls = new ScientificLibraryHall[this.getHallAmount()];
        Item current = this.list.head;
        for (int i = 0; i < this.getHallAmount(); i++) {
            halls[i] = current.data;
            current = current.next;
        }
        return halls;
    }

    public Book getBook(int position) {
        int add = 0;
        Item current = this.list.head;
        for (int i = 0; i < this.list.getCount(); i++) {
            add += current.data.countBooks();
            if (position < add) {
                return position >= current.data.countBooks() ? current.data.getBook(position - add + current.data.countBooks()) : current.data.getBook(position);
            }
        }
        return null;
    }

    private Book[] mergeArrays(Book[] arr1, Book[] arr2, int n1,
                               int n2) {
        Book[] arr3 = new Book[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i].getPrice() > arr2[j].getPrice())
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < n1)
            arr3[k++] = arr1[i++];
        while (j < n2)
            arr3[k++] = arr2[j++];
        return arr3;
    }

    public Book[] getSortedBooksArray() {
        Book[] result = new Book[0];
        Book[] sorted1;
        Book[] sorted2;
        Item current = this.list.head;
        for (int i = 0; i < this.list.getCount(); i++) {
            if (i + 1 < this.list.getCount()) {
                sorted1 = ScientificLibrary.sortArray(current.data.getBooks());
                sorted2 = ScientificLibrary.sortArray(current.next.data.getBooks());
                result = this.mergeArrays(sorted1, sorted2, current.data.countBooks(),
                        current.next.data.countBooks());
            }
        }
        return result;
    }

    public void printAll() {
        Item current = this.list.head;
        System.out.println("== LIBRARY HALLS DATA ==");
        for (int i = 0; i < this.getHallAmount(); i++) {
            System.out.println(current.data.getName() + ": " +
                    current.data.countBooks());
            current = current.next;
        }
        System.out.println("== DATA ENDS HERE ==");
    }

    public void changeHall(int pos, ScientificLibraryHall newHall) {
        Item current = this.list.head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        current.data = newHall;
    }

    public void changeBook(int pos, Book newBook) {
        int add = 0;
        Item current = this.list.head;
        for (int i = 0; i < this.list.getCount(); i++) {
            add += current.data.countBooks();
            if (pos < add) {
                if (pos >= current.data.countBooks()) {
                    current.data.changeBook(pos - add + current.data.countBooks(),
                            newBook);
                } else {
                    current.data.changeBook(pos, newBook);
                }
                break;
            }
        }
    }

    public void addBook(int pos, Book newBook) {
        int add = 0;
        Item current = this.list.head;
        for (int i = 0; i < this.list.getCount(); i++) {
            add += current.data.countBooks();
            if (pos < add) {
                if (pos >= current.data.countBooks()) {
                    current.data.addBook(pos - add + current.data.countBooks(), newBook);
                } else {
                    current.data.addBook(pos, newBook);
                }
                break;
            }
        }
    }

    public void deleteBook(int pos) {
        int add = 0;
        Item current = this.list.head;
        for (int i = 0; i < this.list.getCount(); i++) {
            add += current.data.countBooks();
            if (pos < add) {
                if (pos >= current.data.countBooks()) {
                    current.data.deleteBook(pos - add + current.data.countBooks());
                } else {
                    current.data.deleteBook(pos);
                }
                break;
            }
        }
    }

    public Book getBestBook() {
        Book best = new Book();
        Item current = this.list.head;
        for (int i = 0; i < this.getHallAmount(); i++) {
            var currentBest = current.data.getBestBook();
            if (currentBest.getPrice() > best.getPrice()) {
                best = currentBest;
            }
            current = current.next;
        }
        return best;
    }
}
