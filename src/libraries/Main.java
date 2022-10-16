package libraries;

public class Main {
    public static void main(String[] args) {
        var book1 = new Book("А.С.Пушкин", "Дубровский", 194.99, 1841);
        var book2 = new Book("Л.Толстой", "Воскресение", 8230.00, 1899);
        var book3 = new Book("М.Петросян", "Дом,в котором", 1147.00, 2009);
        var book4 = new Book("Лермонтов", "Герой нашего времени", 1800.99, 1975);
        var book5 = new Book("М.Тунсю", "Благословение небожителей", 1250.00, 2022);
        var arr1 = new Book[]{book1, book2, book3};
        var arr2 = new Book[]{book4,book5};
        var hall1 = new ChildrenLibraryHall(arr1, "Зал 1:");
        var hall2 = new ChildrenLibraryHall(arr2, "Зал 2:");
        var halls = new ChildrenLibraryHall[]{hall1, hall2};
        var library = new ChildrenLibrary(halls);
        var library1 = new ChildrenLibrary(halls);
        library.addBookInHall(0, 3, new Book("А.П.Чехов","Дуэль",7691.00,1891));
        System.out.println("Библиотека:");
        library.printAllHalls();
        System.out.println("______________________________________");
        System.out.println("Вывод зала 1:");
        hall1.printAllTitles();
        //изменим книгу:
        library.changeBookInHall(0,3,new Book("Блок","Пламень",999.98,1923));
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

