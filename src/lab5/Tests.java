package lab5;


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

        hall1.addBook(0, newBook1);
        hall1.addBook(0, newBook2);
        hall1.addBook(0, newBook3);
        hall4.addBook(0,newBook4);
        hall4.addBook(0,newBook3);

        hall2.addBook(0, newChildrenBook1);
        hall2.addBook(0, newChildrenBook2);

        hall3.addBook(0, newChildrenBook3);
        hall3.addBook(0, newChildrenBook4);


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



//        ScientificBook newBook1 = new ScientificBook("1_scientific", "1_scientific", 100, 1000, 1);
//        ScientificBook newBook2 = new ScientificBook("2_scientific", "2_scientific", 200, 2000, 2);
//        ScientificBook newBook3 = new ScientificBook("2_scientific", "2_scientific", 200, 2000, 2);
//        ScientificBook newBook4 = new ScientificBook("4_scientific", "4_scientific", 400, 4000, 4);
//
//        ChildrenBook newChildrenBook1 = new ChildrenBook("1_сhild", "1_сhild", 100, 1000, 1);
//        ChildrenBook newChildrenBook2 = new ChildrenBook("2_сhild", "2_сhild", 200, 2000, 2);
//        ChildrenBook newChildrenBook3 = new ChildrenBook("3_сhild", "3_сhild", 300, 3000, 3);
//        ChildrenBook newChildrenBook4 = new ChildrenBook("4_сhild", "4_сhild", 400, 4000, 4);
//
//
//        ScientificLibraryHall hall1 = new ScientificLibraryHall("Зал№1.Научный", 0);
//        ScientificLibraryHall hall2 = new ScientificLibraryHall("Зал№2Научный", 0);
//        ChildrenLibraryHall hall3 = new ChildrenLibraryHall("Зал№3.Детский", 0);
//        ChildrenLibraryHall hall4 = new ChildrenLibraryHall("Зал№4.Детский", 0);
//
//
//        ScientificLibrary library1 = new ScientificLibrary(new IHall[]{hall1,hall2});
//        ChildrenLibrary library2 = new ChildrenLibrary(new IHall[]{hall3,hall4});
//
////        System.out.println("___ Добавление книг ___");
//
//        hall1.addBook(0, newBook1);
//        hall1.addBook(0, newBook2);
//        hall1.addBook(0, newBook2);
//
//        hall2.addBook(0, newBook3);
//
//        hall3.addBook(0, newChildrenBook1);
//        hall3.addBook(0, newChildrenBook2);
//        hall3.addBook(0, newChildrenBook2);
//
//        hall4.addBook(0, newChildrenBook3);
//
//
//        System.out.println("\n___ Залы ___\n");
//
//        hall1.print();
//        hall2.print();
//        hall3.print();
//        hall4.print();
//
//        System.out.println("\n___ Библиотеки ___");
//
//        System.out.println(library1);
//        System.out.println(library2);
//
//        System.out.println("\n___ 2_scientific == 2_scientific ___\n ");
//
//        if (newBook2.equals(newBook3)) {
//            System.out.println("equals");
//        } else System.out.println("no equals");
//
//        if (newBook2.hashCode() == newBook3.hashCode()) {
//            System.out.println("equals (using hashCode)");
//        } else System.out.println("no equals");
//
//        Book StandardBook = new Book("Example", "History of Example", 10000, 10000);
//
//        Libraries libr = new Libraries();
//        DataOutputStream out1 = new DataOutputStream(new FileOutputStream("out1.bin"));
//        libr.outputLibrary(library1, out1);
//        out1.close();
//
//        DataInputStream in1 = new DataInputStream(new FileInputStream("out1.bin"));
//        ILibrary libr1 = libr.inputLibrary(in1);
//        libr1.print();
//        in1.close();
//
//        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("out2.txt")));
//        libr.writeLibrary(library1, out2);
//        out2.close();
//
//        FileReader in2 = new FileReader(("out2.txt"));
//        libr.readLibrary(in2);
//        in2.close();
//
//        ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("out3.bin"));
//        libr.SerOutLib(library1, out3);
//        out3.close();
//
//        ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("out3.bin"));
//        ILibrary Lib3 = libr.SerInLib(in3, "ChildrenLibrary");
//        Lib3.print();
//        System.out.println("//////////////////////////////////");
//        in3.close();


//        System.out.println("Количество книг: " + hall1.numbersOfBooks());
//        System.out.println();
//
//        hall2.print();
//        System.out.println("Количество книг: " + hall2.numbersOfBooks());
//        System.out.println();
//
//        System.out.println("___ Удаление книг ___");
//
//        hall1.delBook(1);
//        hall2.delBook(0);
//
//        hall1.print();
//        hall2.print();
//
//        ScientificBook newBook3 = new ScientificBook("By T", "Ty", 5000, 2018, 5);
//        ChildrenBook newChildrenBook3 = new ChildrenBook("By Y", "Y", 6000, 2017, 6);
//
//        Book StandardBook = new Book("Илья ", "Папа и наказание сырного сыночка ", 6264, 1860);
//
//
//        System.out.println();
//        System.out.println("___ Замена книг ___");
//        hall1.changeBook(0, newBook3);
//        hall2.changeBook(0, newChildrenBook2);
//
//        hall1.print();
//        hall2.print();
//        System.out.println();
//
//        System.out.println("Сумма цен книг в Зале 1: " + hall1.getSumOfPrice());
//        System.out.println("Сумма цен книг в Зале 2: " + hall2.getSumOfPrice());
//
//        System.out.println("Автор лучшей книги в Зале 1: " + hall1.getBestBook().getAuthor());
//        System.out.println("Автор лучшей книги в Зале 2: " + hall2.getBestBook().getAuthor());
//
//        System.out.println("Ссылка на элемент по номеру " + hall1.getLinkToElement(1));
//
//        System.out.println("check1");
//        System.out.println(StandardBook); //обычная книга

    }

}
