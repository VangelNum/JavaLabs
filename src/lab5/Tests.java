package lab5;


public class Tests {
    public static void main(String[] args) {
        ScientificBook newBook1 = new ScientificBook("Иван Тургенев", "Отцы и дети", 6264, 1860, 1);
        ScientificBook newBook2 = new ScientificBook("Федор Достоевский", "Идиот", 7192, 1868, 2);

        ChildrenBook newChildrenBook1 = new ChildrenBook("Николай Гоголь", "Ревизор", 5542, 1836, 3);
        ChildrenBook newChildrenBook2 = new ChildrenBook("Антон Чехов", "Палата № 6", 5123, 1892, 4);

        ScientificLibraryHall hall1 = new ScientificLibraryHall("Зал 1", 0);
        ChildrenLibraryHall hall2 = new ChildrenLibraryHall("Зал 2 Детский", 0);

        System.out.println("Добавление книг");

        hall1.addBook(0, newBook1);
        hall1.addBook(0, newBook2);

        hall2.addBook(0, newChildrenBook1);
        hall2.addBook(0, newChildrenBook2);

        hall1.print();
        System.out.println("Количество книг: " + hall1.numbersOfBooks());
        System.out.println();

        hall2.print();
        System.out.println("Количество книг: " + hall2.numbersOfBooks());
        System.out.println();

        System.out.println("Удаление книг");

        hall1.delBook(0);
        hall2.delBook(0);

        hall1.print();
        hall2.print();

        ScientificBook newBook3 = new ScientificBook("Михаил Булгаков", "Собачье сердце", 9695, 1925, 3);
        ChildrenBook newChildrenBook3 = new ChildrenBook("Николай Гоголь", "Мёртвые души", 7536, 1842, 10);

        hall1.changeBook(0, newBook3);
        hall2.changeBook(0, newChildrenBook3);

        System.out.println();
        System.out.println("Замена книг");

        hall1.print();
        hall2.print();
        System.out.println();

        System.out.println("Сумма цен книг в Зале 1: " + hall1.getSumPrice());
        System.out.println("Сумма цен книг в Зале 2: " + hall2.getSumPrice());

        System.out.println("Автор лучшей книги в Зале 1: " + hall1.getBestBook().getAvtor());
        System.out.println("Автор лучшей книги в Зале 2: " + hall2.getBestBook().getAvtor());

        System.out.println("Ссылка на элемент по номеру " + hall1.getLinkToElement(0));


    }

}
