package lab7;

import java.io.*;

public class Libraries implements Serializable {
    public static void outputLibrary(ILibrary lib, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(lib.getClass().getSimpleName());
        dos.writeInt(lib.getNumHall());
        int countBooks = 0;
        for (int i = 0; i < lib.getNumHall(); i++) {
            dos.writeUTF(lib.getHall(i).getHallName());
            countBooks = lib.getHall(i).numbersBooks();
            dos.writeInt(lib.getHall(i).numbersBooks());
            for (int j = 0; j < countBooks; j++) {
                IBook book = lib.getHall(i).getBook(j);
                dos.writeUTF(book.getAvtor());
                dos.writeUTF(book.getTitle());
                dos.writeDouble(book.getCost());
                dos.writeInt(book.getYear());
                if (lib.getClass().getSimpleName().equals("ChildrenLibrary")) {
                    dos.writeInt(((ChildrenBook) book).getVozr());
                }
                if (lib.getClass().getSimpleName().equals("ScientificLibrary")) {
                    dos.writeDouble(((ScientificBook) book).getIndex());
                }
            }
        }
    }

    public static ILibrary inputLibrary(InputStream in) {
        try (DataInputStream data_read = new DataInputStream(in)) {
            ILibrary lib = null;
            IBook[] bookArray = null;
            IHall[] hall = null;
            String nameLib = data_read.readUTF();
            int countHalls = data_read.readInt();
            if (nameLib.equals("ChildrenLibrary")) {
                hall = new ChildrenLibraryHall[countHalls];
            }
            if (nameLib.equals("ScientificLibrary")) {
                hall = new ScientificLibraryHall[countHalls];
            }
            for (int i = 0; i < countHalls; i++) {

                String nameHall = data_read.readUTF();
                int countBooks = data_read.readInt();
                if (nameLib.equals("ChildrenLibrary")) {
                    bookArray = new ChildrenBook[countBooks];
                }
                if (nameLib.equals("ScientificLibrary")) {
                    bookArray = new ScientificBook[countBooks];
                }
                for (int j = 0; j < countBooks; j++) {
                    String author = data_read.readUTF();
                    String title = data_read.readUTF();
                    double cost = data_read.readDouble();
                    int year = data_read.readInt();
                    if (nameLib.equals("ChildrenLibrary")) {
                        int vozr = data_read.readInt();
                        ChildrenBook tempbook = new ChildrenBook(author, title, cost, year, vozr);
                        bookArray[j] = tempbook;
                    }
                    if (nameLib.equals("ScientificLibrary")) {
                        double rating = data_read.readDouble();
                        ScientificBook tempbook = new ScientificBook(author, title, cost, year, rating);
                        bookArray[j] = tempbook;
                    }
                    if (nameLib.equals("ChildrenLibrary")) {
                        hall[i] = new ChildrenLibraryHall(nameHall, (ChildrenBook[]) bookArray);
                    }
                    if (nameLib.equals("ScientificLibrary")) {
                        hall[i] = new ScientificLibraryHall(nameHall, (ScientificBook[]) bookArray);
                    }
                }
            }
            if (nameLib.equals("ChildrenLibrary")) {
                lib = new ChildrenLibrary((ChildrenLibraryHall[]) hall);
            }
            if (nameLib.equals("ScientificLibrary")) {
                lib = new ScientificLibrary((ScientificLibraryHall[]) hall);
            }
            return lib;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeLibrary(ILibrary lib, Writer out) {
        try {
            String nameLib = lib.getClass().getSimpleName();
            out.write(nameLib + " ");
            out.write(lib.getNumHall() + " ");
            int countBooks = 0;
            for (int i = 0; i < lib.getNumHall(); i++) {
                out.write(lib.getHall(i).getHallName() + " ");
                countBooks = lib.getHall(i).numbersBooks();
                out.write(countBooks + " ");
                for (int j = 0; j < countBooks; j++) {
                    IBook tempbook = lib.getHall(i).getBook(j);
                    out.write(tempbook.getAvtor());
                    out.write(" " + tempbook.getTitle());
                    out.write(" " + (int) tempbook.getCost());
                    out.write(" " + tempbook.getYear() );
                    if (nameLib.equals("ChildrenLibrary")) {
                        out.write(" "+((ChildrenBook) tempbook).getVozr() + " ");
                    }
                    if (nameLib.equals("ScientificLibrary")) {
                        out.write((int) ((ScientificBook) tempbook).getIndex() + " ");
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println("???????????? ???????????? ???????????????????? ?? ???????????????????? ??????????!");
        }
    }

    public static ILibrary readLibrary(Reader in) {
        try {
            BufferedReader br = new BufferedReader(in);
            ILibrary lib = null;
            IBook[] tempbookarray = null;
            IHall[] hall = null;
            int hallIndex = 0;
            String nameLib = br.readLine();
            String[] words = nameLib.split(" ");
             int CounWords = words.length;
            nameLib = words[0];
            int countHalls = Integer.parseInt(words[3]);
            if (nameLib.equals("ChildrenLibrary")) {
                hall = new ChildrenLibraryHall[countHalls];
            }
            if (nameLib.equals("ScientificLibrary")) {
                hall = new ScientificLibraryHall[countHalls];
            }

            for (int i = 2; i < CounWords; i++) {
                String nameHall = words[i]; //???????????????? ????????
                i++;
                int countBooks = Integer.parseInt(words[i]); //?????????? ????????
                i++;
                if (nameLib.equals("ChildrenLibrary")) {
                    tempbookarray = new ChildrenBook[countBooks];
                }
                if (nameLib.equals("ScientificLibrary")) {
                    tempbookarray = new ScientificBook[countBooks];
                }
                for (int j = 0; j < countBooks; j++) {
                    String author = words[i];
                    i++;
                    String name = words[i];
                    i++;
                    double cost = Integer.parseInt(words[i]);
                    i++;
                    int year = Integer.parseInt(words[i]);
                    i++;
                    if (nameLib.equals("ChildrenLibrary")) {
                        int minAge = Integer.parseInt(words[i]);
                        i++;
                        ChildrenBook tempbook = new ChildrenBook(author, name, cost, year, minAge);
                        tempbookarray[j] = tempbook;
                    }
                    if (nameLib.equals("ScientificLibrary")) {
                        double rating = Double.parseDouble(words[i]);
                        i++;
                        ScientificBook tempbook = new ScientificBook(author, name, cost, year, rating);
                        tempbookarray[j] = tempbook;
                    }
                }
                if (nameLib.equals("ChildrenLibrary")) {
                    hall[hallIndex] = new ChildrenLibraryHall(nameHall, tempbookarray);
                }
                if (nameLib.equals("ScientificLibrary")) {
                    hall[hallIndex] = new ScientificLibraryHall(nameHall, tempbookarray);
                    hallIndex++;
                }
                i--;
            }
            if (nameLib.equals("ChildrenLibrary")) {
                lib = new ChildrenLibrary((ChildrenLibraryHall[]) hall);
            }
            if (nameLib.equals("ScientificLibrary")) {
                lib = new ScientificLibrary((ScientificLibraryHall[]) hall);
            }
            return lib;
        } catch (IOException e) {
            System.out.println("???????????? ???????????? ???????????????????? ?? ???????????????????? ??????????!");
        }
        return null;
    }

    public static void SerOutLib(ILibrary Library, OutputStream out) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(Library);
            oos.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static ILibrary SerInLib(InputStream in, String NameTypeLib) {
        try (ObjectInputStream ois = new ObjectInputStream(in)) {
            if (NameTypeLib.equals("ChildrenLibrary")) {
                return (ChildrenLibrary) ois.readObject();
            }
            if (NameTypeLib.equals("ScientificLibrary")) {
                return (ScientificLibrary) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
        return null;
    }
}


