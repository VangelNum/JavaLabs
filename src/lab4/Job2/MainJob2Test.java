package lab4.Job2;


import lab4.Job1.ScientificLibrary;
import lab4.Job1.ScientificLibraryHall;

public class MainJob2Test {
    public static void main(String[] args) {

        ScientificLibrary[] Books = new ScientificLibrary[4];
        Books[0] = new ScientificLibrary("Михаил Булгаков", "Собачье сердце", 9695, 1925, 0);
        Books[1] = new ScientificLibrary("Николай Гоголь", "Мёртвые души", 7536, 1842, 1);
        Books[2] = new ScientificLibrary("Виктор Гюго", "Отверженные", 5475, 1862, 2);
        Books[3] = new ScientificLibrary("Лев Толстой", "Война и мир", 9618, 1865, 3);

        ScientificLibraryHall hall1 = new ScientificLibraryHall("Зал 1", Books);
        System.out.println("Изначальный массив книг");
        hall1.printAllBooks();

        ScientificLibrary newBook1 = new ScientificLibrary("Иван Тургенев", "Отцы и дети", 6264, 1860, 4);
        ScientificLibrary newBook2 = new ScientificLibrary("Федор Достоевский", "Идиот", 7192, 1868, 12);
        ScientificLibrary newBook3 = new ScientificLibrary("Николай Гоголь", "Ревизор", 5542, 1836, 10);
        ScientificLibrary newBook4 = new ScientificLibrary("Антон Чехов", "Палата № 6", 5123, 1892, 10);

        System.out.println();
        hall1.addBook(0, newBook1);
        System.out.println("После добавления книги");
        hall1.printAllBooks();
        System.out.println();
        int[] arr = {1, 1};

        ScientificLibrary2 library = new ScientificLibrary2(2, arr);

        library.addBookInHall(0, newBook3);

        hall1.changeBook(0, newBook4);
        System.out.println("После замены книги");
        hall1.printAllBooks();
        System.out.println();

        ScientificLibrary[] Books1 = new ScientificLibrary[4];
        Books1[0] = newBook1;
        Books1[1] = newBook2;
        Books1[2] = newBook3;
        Books1[3] = newBook4;

        ScientificLibraryHall hall2 = new ScientificLibraryHall("Зал 2", Books1);

        library.changeHall(1, hall2);
        hall2.printAllBooks();
        System.out.println();

        hall1.deleteBook(2);
        hall2.deleteBook(0);
        System.out.println("После удаления книги");
        hall1.printAllBooks();
        System.out.println();
        hall2.printAllBooks();
        System.out.println();

        System.out.println("Лучшая книга");
        System.out.println(library.getBestBook().data.getAuthor() +" "+ library.getBestBook().data.getName());
    }
}
