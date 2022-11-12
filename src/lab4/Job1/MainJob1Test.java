package lab4.Job1;


public class MainJob1Test {
    public static void main(String[] args) {
        ScientificLibrary newBook = new ScientificLibrary();
        ScientificLibrary Book = new ScientificLibrary("Me", "Best Book",2019.0,2000,0);
        ScientificLibraryHall hall = new ScientificLibraryHall("New Holl", 5);

        System.out.println("NumberOfElements: " + hall.getnumberofbook());
        
        System.out.println("add where i=0: " + hall.addBook(0, newBook));
        System.out.println("add where i=1: " + hall.addBook(1, newBook));
        System.out.println("add where i=2: " + hall.addBook(2, newBook));
        System.out.println("add where i=3: " + hall.addBook(3, newBook));
        System.out.println("add where i=4: " + hall.addBook(4, newBook));
        System.out.println("NumberOfElements after add = " + hall.getnumberofbook());
        
        System.out.println("delete where i=0: " + hall.deleteBook(0));
        System.out.println("delete where i=1: " + hall.deleteBook(1));
        System.out.println("delete where i=2: " + hall.deleteBook(2));
        System.out.println("NumberOfElements after delete = " + hall.getnumberofbook());

        hall.changeBook(2, Book);

        hall.printAllBooks();

        System.out.println("price of all books: " + hall.getPrice());


    }
}
