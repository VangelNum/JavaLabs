package lab7;


import java.io.*;

public class Tests {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        ScientificBook newBook1 = new ScientificBook("IvanTurgenev", "FatherAndChildren", 6264, 1860, 1);
        ScientificBook newBook2 = new ScientificBook("FedorDostoevskiy", "Idiot", 7192, 1868, 2);
        ScientificBook newBook3 = new ScientificBook("MihailBulgakov", "Doghearth", 9695, 1925, 3);
        ScientificBook newBook4 = new ScientificBook("ViktorGugo", "Outcasts", 5475, 1862, 4);

        ChildrenBook newChildrenBook1 = new ChildrenBook("NikolayGogol", "Auditor", 5542, 1836, 5);
        ChildrenBook newChildrenBook2 = new ChildrenBook("AntonChehov", "Ward№6", 5123, 1892, 6);
        ChildrenBook newChildrenBook3 = new ChildrenBook("GogolNikolay", "DeadSouls", 7536, 1842, 7);
        ChildrenBook newChildrenBook4 = new ChildrenBook("LevTolstoi", "WarAndPeace", 9618, 1865, 8);

        ScientificLibraryHall hall1 = new ScientificLibraryHall("Hall1Scientific", 0);
        ScientificLibraryHall hall4 = new ScientificLibraryHall("Hall2Scientific", 0);
        ChildrenLibraryHall hall2 = new ChildrenLibraryHall("Hall3Children", 0);
        ChildrenLibraryHall hall3 = new ChildrenLibraryHall("Hall4Children", 0);

        ChildrenLibrary library1 = new ChildrenLibrary(new IHall[]{hall2,hall3});
        ScientificLibrary library2 = new ScientificLibrary(new IHall[]{hall1,hall4});

        hall1.dobavBook(0, newBook1);
        hall1.dobavBook(0, newBook2);
        hall1.dobavBook(0, newBook3);
        hall4.dobavBook(0,newBook4);
        hall4.dobavBook(0,newBook3);

        hall2.dobavBook(0, newChildrenBook1);
        hall2.dobavBook(0, newChildrenBook2);

        hall3.dobavBook(0, newChildrenBook3);
        hall3.dobavBook(0, newChildrenBook4);


        Libraries libr = new Libraries();
        DataOutputStream out1 = new DataOutputStream(new FileOutputStream("out1.bin"));
        libr.outputLibrary(library1, out1);
        out1.close();

        DataInputStream in1 = new DataInputStream(new FileInputStream("out1.bin"));
        ILibrary libr1 = libr.inputLibrary(in1);
        libr1.print();
        in1.close();

        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("out2.txt")));
        libr.writeLibrary(library1, out2);
        out2.close();

        FileReader in2 = new FileReader(("out2.txt"));
        libr.readLibrary(in2);
        in2.close();

        ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("out3.bin"));
        libr.SerOutLib(library1, out3);
        out3.close();

        ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("out3.bin"));
        ILibrary Lib3 = libr.SerInLib(in3, "ChildrenLibrary");
        Lib3.print();
        System.out.println("//////////////////////////////////");
        in3.close();





        //System.out.println("Добавление книг");
//
//        Book StandardBook = new Book("Владик", "Папа и сыр", 6264, 1860);
//        Book StandardBook2 = new Book("Влад", "Питон", 10000, 2022);
//        Book StandardBook3 = new Book("Влад", "Питон", 10000, 2022);
//        Book StandardBook4 = new Book("Илья", "Кириллов хороший человек", 5000, 2022);

//        System.out.println("check1");
//        System.out.println(StandardBook); //обычная книга
//        System.out.println("check2");
//        System.out.println(newChildrenBook1); //детская книга
//        System.out.println("check3");
//        System.out.println(newBook1); // научная книга
//
//        System.out.println("check4");
//        System.out.println(hall2); //Детский зал
//        System.out.println("check5");
//        System.out.println(hall1);  // Научный зал
//
//        System.out.println("check6");
//        System.out.println(library1); // детская библиотека
//        System.out.println("check7");
//        System.out.println(library2); //научная библиотека

//
//        if (StandardBook2.equals(StandardBook3)) {
//            System.out.println("YEP");
//        } else System.out.println("NO");

//        if (StandardBook2.hashCode() == StandardBook3.hashCode()) {
//            System.out.println("YEP");
//        } else System.out.println("NO");



//
//        Book clone = (Book) StandardBook4.clone();
//
//        System.out.println("library1 " + hall1);
//        ScientificLibraryHall clone2 = (ScientificLibraryHall) hall1.clone();
//
//
//        clone2.dobavBook(0,newBook1);
//
//        System.out.println("library1 " + hall1);
//
//        System.out.println("clone2 " + clone2);
//
//
//        if (clone2.equals(hall1)) {
//            System.out.println("YEEES");
//        } else System.out.println("NOOO");
//
//
//        System.out.println(clone + " Клон");
//
//        hall1.print();
//        System.out.println("Количество книг: " + hall1.numbersBooks());
//        System.out.println();
//
//        hall2.print();
//        System.out.println("Количество книг: " + hall2.numbersBooks());
//        System.out.println();
//
//        System.out.println("Удаление книг");
//
//        hall1.delete(0);
//        hall2.delete(0);
//
//        hall1.print();
//        hall2.print();
//
//
//        hall1.izmenenie(0, newBook3);
//        hall2.izmenenie(0, newChildrenBook3);
//
//        System.out.println();
//        System.out.println("Замена книг");
//
//        hall1.print();
//        hall2.print();
//        System.out.println();
//
//        System.out.println("Сумма цен книг в Зале 1: " + hall1.getSumPrice());
//        System.out.println("Сумма цен книг в Зале 2: " + hall2.getSumPrice());
//
//        System.out.println("Автор лучшей книги в Зале 1: " + hall1.getBestBook().getAvtor());
//        System.out.println("Автор лучшей книги в Зале 2: " + hall2.getBestBook().getAvtor());
//
//        System.out.println("Ссылка на элемент по номеру " + hall1.getLink(0));


    }

}
