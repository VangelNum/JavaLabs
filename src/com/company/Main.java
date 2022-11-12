package com.company;

import com.company.children.Book;
import com.company.science.ScientificLibrary;
import com.company.science.ScientificLibraryHall;

public class Main {
    public static void main(String[] args) {
        var book1 = new Book("A", "A", 11000.0, 1999);
        var book2 = new Book("B", "B", 1100.0, 2000);
        var book3 = new Book("C", "C", 1200.0, 2001);
        var book4 = new Book("D", "D", 1300.0, 2002);
        var book5 = new Book("E", "E", 1400.0, 2003);
        var book6 = new Book("F", "F", 1500.0, 2004);
        var book7 = new Book("G", "G", 1600.0, 2005);
        var book8 = new Book("H", "H", 1700.0, 2006);
        var hall = new ScientificLibraryHall("test", new Book[]{book1, book2, book3, book4});

        var hall1 = new ScientificLibraryHall("test1", new Book[]{book5, book6, book7,
                book8});
        var library = new ScientificLibrary(2, new int[]{1, 2});
//
//        library.changeHall(0, hall);
//        library.changeHall(1, hall1);
//        library.printAll();
//        hall.changeBook(1, new Book("CHANGED", "CHANGED", 5000, 2021));
//        hall.printAllTitles();
//        hall1.addBook(1, new Book("ADDED", "ADDED", 5000, 2021));
//        hall1.printAllTitles();
//        library.printAll();
//        library.addBook(3, new Book("INSERTED", "INSERTED", 5000, 2021));
//        hall.printAllTitles();
//        library.printAll();
//        System.out.println("BEST BOOK AUTHOR: " + library.getBestBook().getAuthor());
//        var sortedArr = library.getSortedBooksArray();
//        for (int i = 0; i < sortedArr.length; i++) {
//            System.out.print(sortedArr[i].getTitle() + " ");
//        }
//        System.out.println();
    }
}