package lab4.Job2;

import lab4.Job1.Item;
import lab4.Job1.ScientificLibrary;
import lab4.Job1.ScientificLibraryHall;

public class ScientificLibrary2 {
    private Item2 head;

    public ScientificLibrary2(int numberOfHalls, int[] sizeOfBooksInHoll) {
        if (numberOfHalls == 0) {
            head = null;
        } else if (numberOfHalls == 1) {
            head = new Item2("Новый зал", sizeOfBooksInHoll[0]);
            head.next = head;
            head.prev = head;
        } else if (numberOfHalls > 1) {
            head = new Item2("Новый зал", sizeOfBooksInHoll[0]);
            head.next = head;
            head.prev = head;
            Item2 temp = head;
            Item2 oldtemp;
            Item2 newtemp;
            for (int i = 1; i < numberOfHalls; i++) {
                newtemp = new Item2("Новый зал", sizeOfBooksInHoll[i]);
                temp.next = newtemp;
                head.prev = newtemp;
                oldtemp = temp;
                temp = newtemp;
                temp.prev = oldtemp;
            }
            temp.next = head;
        }
    }

    public ScientificLibrary2(ScientificLibraryHall[] libraryHall) {
        int numberOfHalls = libraryHall.length;

        if (numberOfHalls == 0) {
            head = null;
        } else if (numberOfHalls == 1) {
            head = new Item2(libraryHall[0]);
            head.next = head;
            head.prev = head;
        } else {
            head = new Item2(libraryHall[0]);
            head.next = head;
            head.prev = head;
            Item2 temp = head;
            Item2 oldTemp;
            Item2 newTemp;

            for (int i = 1; i < numberOfHalls; i++) {
                newTemp = new Item2(libraryHall[i]);
                temp.next = newTemp;
                head.prev = newTemp;
                oldTemp = temp;
                temp = newTemp;
                temp.prev = oldTemp;
            }
            temp.next = head;
        }
    }

    public int getNumberOfHall() {
        int countofbook = 0;
        if (isEmpty()) {
            return countofbook;
        }

        Item2 temp = head;
        temp = temp.next;
        countofbook++;
        if (temp == head) return countofbook;

        else {
            while (temp != head) {
                temp = temp.next;
                countofbook++;
            }
            return countofbook;
        }
    }


    public int getNumberOfBooksInHall() {
        int countofbooks = 0;
        Item2 temp = head;
        for (int i = 0; i < getNumberOfHall(); i++) {
            countofbooks += temp.data.getnumberofbook();
            temp = temp.next;
        }
        return countofbooks;
    }

    public int getNumberOfElementsHall(ScientificLibraryHall hall) {
        int numBook = 0;
        Item2 temp = head;
        for (int i = 0; i < hall.getnumberofbook(); i++) {
            numBook += temp.data.getnumberofbook();
            temp = temp.next;
        }
        return numBook;
    }

    public double getPriceAllBook() {
        Item2 temp = head;
        double allPrice = 0;
        for (int i = 0; i < getNumberOfHall(); i++) {
            allPrice += temp.data.getPrice();
            temp = temp.next;
        }
        return allPrice;
    }

    public ScientificLibraryHall getHall(int i) {
        return new ScientificLibraryHall(getLinkToHall(i).data.getHallName(), getLinkToHall(i).data.getnumberofbook());
    }

    public ScientificLibrary getBook(int i) {
        ScientificLibrary Book = new ScientificLibrary(getHall(i).getLinkToElement(i).data.getAuthor(), getHall(i).getLinkToElement(i).data.getYear());
        return Book;
    }

    public Item2 getLinkToHall(int i) {
        if (!isIndex(i) || isEmpty()) return null;
        Item2 element = null;
        if (isEmpty()) return null;
        else if (i == 0) return head;
        else if (i == 1 && head.next != head) {
            return head.next;
        } else if (head.next == head) return null;
        else {
            Item2 temp = head;
            temp = temp.next;
            for (int j = 1; j < i && temp != head; j++) {
                if (j + 1 == i) {
                    element = temp.next;
                    break;
                }
                temp = temp.next;
                if (temp == head) return null;
            }
        }
        return element;
    }

    public boolean addHall(int i, ScientificLibraryHall newHall) {
        boolean flag = false;
        Item2 Hall = new Item2(newHall);
        Item2 temp = head;


        if (isEmpty()) {
            head = Hall;
            head.next = head;
            head.prev = head;
            flag = true;
        } else if (getNumberOfHall() == 1) {
            head.next = Hall;
            head.prev = Hall;
            Hall.next = head;
            Hall.prev = head;
            if (i == 0) head = Hall;
            flag = true;
        } else if (i == 0 || i == getNumberOfHall()) {
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = Hall;
            Hall.prev = temp;
            Hall.next = head;
            head.prev = Hall;
            if (i == 0) head = Hall;
            flag = true;
        } else {
            for (int j = 0; j < getNumberOfHall(); j++) {
                if (j + 1 == i) {
                    Hall.next = temp.next;
                    Hall.prev = temp;
                    temp.next = Hall;
                    temp = temp.next;
                    temp.prev = Hall;
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
        }

        return flag;
    }

    public boolean deleteHall(int i) {
        if (isEmpty()) return false;

        boolean flag = false;
        Item2 temp = head;
        Item2 second;
        if (getNumberOfHall() == 1) {
            head = null;
            head.next = null;
            head.prev = null;
            flag = true;
        } else if (i == 0) {
            second = temp.next;
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = second;
            head = second;
            head.prev = temp;
            flag = true;
        } else if (i == getNumberOfHall() - 1) {
            temp = temp.next;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = null;
            head.prev = null;
            flag = true;
        } else {
            for (int j = 0; j < getNumberOfHall() && isIndex(i); j++) {
                if (j + 1 == i) {
                    Item2 first = temp;
                    temp = temp.next;
                    first.next = temp.next;
                    temp = temp.next;
                    temp.prev = first;
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
        }
        return flag;

    }

    public void printHall() {
        Item2 item2 = head;
        for (int i = 0; i < getNumberOfHall(); i++) {
            System.out.println("Name hall: " + item2.data.getHallName() + ", кол-во книг: " + item2.data.getnumberofbook());
            item2 = item2.next;
        }
    }

    public boolean changeHall(int i, ScientificLibraryHall newHall) {
        if (!isIndex(i) || isEmpty()) return false;
        boolean flag = false;
        Item2 hall = new Item2(newHall);
        Item2 temp = head;
        for (int j = 0; j < getNumberOfHall(); j++) {
            if (j == i) {
                temp = hall;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;

    }

    public void changeBookInHall(int i, ScientificLibrary newBook) {
        if (isIndex(i)) getLinkToHall(i).data.changeBook(i, newBook);
    }

    public void addBookInHall(int i, ScientificLibrary newBook) {
        if (isIndex(i)) getLinkToHall(i).data.addBook(i, newBook);
    }

    public void deleteBookInHall(int i) {
        if (isIndex(i)) getLinkToHall(i).data.deleteBook(i);
    }

    public Item getBestBook() {
        Item bestBook = new Item();
        double maxPrice = 0.0;
        for (int i = 0; i < getNumberOfHall(); i++) {
            if (getLinkToHall(i).data.getBestBook().data.getPrice() > maxPrice) {
                maxPrice = getLinkToHall(i).data.getBestBook().data.getPrice();
                bestBook = getLinkToHall(i).data.getBestBook();
            }
        }

        return bestBook;
    }

    public ScientificLibrary[] SortBooks() {
        ScientificLibrary[] books = new ScientificLibrary[getNumberOfBooksInHall()];
        ScientificLibrary temp;
        for (int i = 0; i < books.length; i++) {
            books[i] = getBook(i);
        }
        for (int i = 0; i < books.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].getPrice() > books[max].getPrice()) max = j;
            }
            temp = books[i];
            books[i] = books[max];
            books[max] = temp;
        }
        return books;
    }

    public boolean isIndex(int i) {
        return i >= 0 && i < getNumberOfHall();
    }

    public boolean isEmpty() {
        return head == null;
    }

}

