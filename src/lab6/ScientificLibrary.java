package lab6;

import lab6.exception.BookIndexOutOfBoundsException;
import lab6.exception.HallIndexOutOfBoundsException;

import java.util.Objects;

public class ScientificLibrary implements ILibrary {
    private Item2 head;

    public ScientificLibrary(int numberOfHalls, int[] sizeBooksInHall) {
        if (numberOfHalls == 0) {
            head = null;
        } else if (numberOfHalls == 1) {
            head = new Item2("new", sizeBooksInHall[0]);
            head.next = head;
            head.prev = head;
        } else if (numberOfHalls > 1) {
            head = new Item2("new", sizeBooksInHall[0]);
            head.next = head;
            head.prev = head;
            Item2 temp = head;
            Item2 oldTemp;
            Item2 newTemp;
            for (int i = 1; i < numberOfHalls; i++) {
                newTemp = new Item2("new", sizeBooksInHall[i]);
                temp.next = newTemp;
                head.prev = newTemp;
                oldTemp = temp;
                temp = newTemp;
                temp.prev = oldTemp;
            }
            temp.next = head;
        }
    }

    public ScientificLibrary(IHall[] libraryHall) {
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

    public boolean isEmpty() {
        return head == null;
    }

    public int getNumHall() {
        int count = 0;
        if (isEmpty()) {
            return count;
        }
        Item2 temp = head;
        temp = temp.next;
        count++;
        if (temp == head) return count;
        else {
            while (temp != head) {
                temp = temp.next;
                count++;
            }
            return count;
        }
    }

    public int getNumBooks() {
        int numBook = 0;
        Item2 temp = head;
        for (int i = 0; i < getNumHall(); i++) {
            numBook += temp.data.numbersBooks();
            temp = temp.next;
        }
        return numBook;
    }

    public int getNumHall(IHall hall) {
        int numBook = 0;
        System.out.println("1234");
        Item2 temp = head;
        for (int i = 0; i < hall.numbersBooks(); i++) {
            numBook += temp.data.numbersBooks();
            temp = temp.next;
        }
        return numBook;
    }

    public double getPriceBooks() {
        Item2 temp = head;
        double allPrice = 0;
        for (int i = 0; i < getNumHall(); i++) {
            allPrice += temp.data.getSumPrice();
            temp = temp.next;
        }
        return allPrice;
    }

    @Override
    public IHall[] arrHall() {
        IHall[] iHall = new IHall[getNumHall()];
        Item2 temp = head;
        for (int i = 0; i < getNumHall(); i++) {
            iHall[i] = getHall(i);
        }
        return iHall;
    }

    public IHall getHall(int i) {
        return new ScientificLibraryHall(getLinkToHall(i).data.getHallName(), getLinkToHall(i).data.numbersBooks());
    }

    public IBook getBook(int i) {
        return new ScientificBook(
                getHall(i).getBook(i).getAvtor(),
                getHall(i).getBook(i).getYear());
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

    public boolean addHall(int i, IHall newHall) {
        boolean flag = false;
        Item2 Hall = new Item2(newHall);
        Item2 temp = head;
        if (isEmpty()) {
            head = Hall;
            head.next = head;
            head.prev = head;
            flag = true;
        } else if (getNumHall() == 1) {
            head.next = Hall;
            head.prev = Hall;
            Hall.next = head;
            Hall.prev = head;
            if (i == 0) head = Hall;
            flag = true;
        } else if (i == 0 || i == getNumHall()) {
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
        } else if (!isIndex(i)) return false;
        else {
            for (int j = 0; j < getNumHall(); j++) {
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
        Item2 second = null;
        if (getNumHall() == 1) {
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
        } else if (i == getNumHall() - 1) {
            temp = temp.next;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = null;
            head.prev = null;
            flag = true;
        } else {
            for (int j = 0; j < getNumHall() && isIndex(i); j++) {
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

    public void print() {
        Item2 item2 = head;
        for (int i = 0; i < getNumHall(); i++) {
            System.out.println("Name hall: " + item2.data.getHallName() + ", number of books = " + item2.data.numbersBooks());
            item2 = item2.next;
        }
    }

    public String getInfoFromHoll() {
        StringBuilder str = new StringBuilder();
        Item2 item2 = head;
        for (int i = 0; i < getNumHall(); i++) {
            str.append(" Название зала: ").append(item2.data.getHallName());
            str.append("Количество книг: ").append(item2.data.numbersBooks());
            item2 = item2.next;
        }
        return str.toString();
    }

    public void zamenaHoll(int i, IHall newHall) {
        if (!isIndex(i) || isEmpty()) throw new HallIndexOutOfBoundsException(i);
        Item2 hall = new Item2(newHall);
        Item2 temp = head;
        for (int j = 0; j < getNumHall(); j++) {
            if (j == i) {
                temp = hall;
                break;
            }
            temp = temp.next;
        }
    }


    @Override
    public void zamenaBook(int i, IBook newBook) {
        if (isIndex(i)) getLinkToHall(i).data.izmenenie(i, newBook);
    }


    public void add(int i, IBook newBook) {
        if (isIndex(i)) getLinkToHall(i).data.dobavBook(i, newBook);
        else throw new HallIndexOutOfBoundsException(i);
    }


    public void DELETEBook(int i) {
        if (isIndex(i)) getLinkToHall(i).data.delete(i);
    }


    public IBook getBestBook() {
        IBook bestBook = new ScientificBook();
        double maxPrice = 0.0;
        for (int i = 0; i < getNumHall(); i++) {
            if (getLinkToHall(i).data.getBestBook().getCost() > maxPrice) {
                maxPrice = getLinkToHall(i).data.getBestBook().getCost();
                bestBook = getLinkToHall(i).data.getBestBook();
            }
        }
        return bestBook;
    }

    public IBook[] sort() {
        IBook[] books = new ScientificBook[getNumBooks()];
        IBook temp;
        for (int i = 0; i < books.length; i++) {
            books[i] = getBook(i);
        }
        for (int i = 0; i < books.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].getCost() > books[max].getCost()) max = j;
            }
            temp = books[i];
            books[i] = books[max];
            books[max] = temp;
        }
        return books;
    }

    public boolean isIndex(int i) {
        if (i >= 0 && i < getNumHall()) {
            return true;
        }
       throw new BookIndexOutOfBoundsException(i);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Количество залов: ").append(getNumHall()).append(" ");
        str.append(getInfoFromHoll());
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfoFromHoll());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ScientificLibrary MyLibrary = (ScientificLibrary) obj;

        if (MyLibrary.getNumHall() == this.getNumHall()
                && MyLibrary.getInfoFromHoll().equals(this.getInfoFromHoll())
        ) {
            return true;
        } else return false;

    }

    @Override
    public Object clone(){
        Object result = null;
        try {
            result = super.clone();
            ((ScientificLibrary) result).head = null;
            for (int i = 0; i < getNumHall(); i++) {
                ((ScientificLibrary) result).addHall(i, (IHall) getHall(i).clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}