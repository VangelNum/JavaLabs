package libraries;

public class Main {
    public static void main(String[] args) {
        var book1 = new Book("Антон Чехов", "Палата № 6", 5110.00, 1892);
        var book2 = new Book("Николай Гоголь", "Ревизор", 5531.00, 1899);
        var book3 = new Book("Федор Достоевский", "Идиот", 1147.00, 1868);
        var book4 = new Book("Александр Пушкин", "Капитанская дочка", 4474.00, 1836);
        var book5 = new Book("М.Тунсю", "Благословение небожителей", 1250.00, 2022);
        var arr1 = new Book[]{book1, book2,book3};
        var arr2 = new Book[]{book4,book5};
        var hall1 = new ChildrenLibraryHall(arr1, "Зал 1:");
        var hall2 = new ChildrenLibraryHall(arr2, "Зал 2:");
        var halls = new ChildrenLibraryHall[]{hall1, hall2};
        var library = new ChildrenLibrary(halls);
        library.addBookInHall(0, 3, new Book("Федор Достоевский","Униженные и оскорблённые",4094.00,1891));
        System.out.println("Библиотека:");
        library.printAllHalls();
        System.out.println("______________________________________");
        System.out.println("Вывод зала 1:");
        hall1.printAllTitles();
        //изменим книгу:
        library.changeBookInHall(0,3,new Book("Михаил Шолохов","Тихий Дон",7273.98,1926));
        hall1.deleteBook(1);
        System.out.println("______________________________________");
        System.out.println("Вывод зала после удаления книги:");
        hall1.printAllTitles();
        System.out.println("______________________________________");
        System.out.println("Автор лучший книги: "+ library.getBestBook().getAuthor());
        System.out.println("______________________________________");
        library.getPriceSortedBooks();
        var sortedArr = library.getPriceSortedBooks();
        System.out.println("Сортировка по убыванию цены:");
        for(var book : sortedArr){
            System.out.println(book.getTitle());
        }
    }
}

