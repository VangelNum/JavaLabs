package lab5;

import lab5.exception.HallIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Objects;

public class ScientificLibrary implements ILibrary, Serializable {
    private Item2 head;

    public ScientificLibrary(int numberOfHalls,int[] sizeBooksInHall){
        if (numberOfHalls == 0) {
            head = null;
        } else if (numberOfHalls == 1) {
            head = new Item2("Undefined",sizeBooksInHall[0]);
            head.next = head; // зациклили
            head.prev = head;
        } else if (numberOfHalls > 1) {
            head = new Item2("Undefined",sizeBooksInHall[0]);
            head.next = head;
            head.prev =head;
            Item2 temp = head;
            Item2 oldTemp = null;
            Item2 newTemp = null;
            for (int i = 1; i < numberOfHalls; i++) {
                newTemp = new Item2("Undefined",sizeBooksInHall[i]);
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
            head.next = head; // зациклили
            head.prev = head;
        } else if (numberOfHalls > 1) {
            head = new Item2(libraryHall[0]);
            head.next = head;
            head.prev =head;
            Item2 temp = head;
            Item2 oldTemp = null;
            Item2 newTemp = null;
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

    public int getCountOfHalls() {
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

    public int getCountOfBooksInLibrary(){
        int numBook = 0;
        Item2 temp = head;
        for (int i = 0; i < getCountOfHalls(); i++) {
            numBook += temp.data.numbersOfBooks();
            temp = temp.next;
        }
        return numBook;
    }
    public int getNumberOfHall(IHall hall){
        int numberBook = 0;
        Item2 temp = head;
        for (int i = 0; i < hall.numbersOfBooks(); i++) {
            numberBook += temp.data.numbersOfBooks();
            temp = temp.next;
        }
        return numberBook;
    }
    // сумма всех книг в библиотеке;
    public double getSumOfPricesInLibrary(){
        Item2 temp = head;
        double allPrice =0;
        for (int i = 0; i < getCountOfHalls(); i++) {
            allPrice += temp.data.getSumOfPrice();
            temp = temp.next;
        }
        return allPrice;
    }
    @Override
    public IHall[] getArrayHalls() {
        IHall[] iHall = new IHall[getCountOfHalls()];
        Item2 temp = head;
        for (int i = 0; i < getCountOfHalls(); i++) {
            iHall[i] = getHall(i);
        }
        return iHall;
    }
    public IHall getHall (int i){
        ScientificLibraryHall hall = new ScientificLibraryHall(getLinkToHall(i).data.getHallName(),getLinkToHall(i).data.numbersOfBooks());
        return hall;
    }
    public IBook getBook (int i){
        IBook Book = new ScientificBook(
                getHall(i).getBookByNumber(i).getAuthor(),
                getHall(i).getBookByNumber(i).getYear());
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
    public boolean addHall(int i, IHall newHall) {
        boolean flag = false;
        Item2 Hall = new Item2(newHall);
        Item2 temp = head;
        if (isEmpty()){
            head = Hall;
            head.next = head;
            head.prev = head;
            flag = true;
        }
        else
        if (getCountOfHalls()==1){
            head.next = Hall;
            head.prev = Hall;
            Hall.next = head;
            Hall.prev = head;
            if (i == 0) head = Hall;
            flag = true;
        } else if (i == 0 || i == getCountOfHalls()) {
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = Hall;
            Hall.prev = temp;
            Hall.next = head;
            head.prev = Hall;
            if (i==0)head = Hall;
            flag = true;
        } else if (!isIndex(i) ) return false;
        else {
            for (int j = 0; j < getCountOfHalls(); j++) {
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
        if (getCountOfHalls()==1){
            head = null;
            head.next=null;
            head.prev=null;
            flag = true;
        } else if (i == 0) {
            second = temp.next;
            temp =temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = second;
            head = second;
            head.prev = temp;
            flag = true;
        } else if (i == getCountOfHalls()-1) {
            temp = temp.next;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = null;
            head.prev = null;
            flag = true;
        }
        else {
            for (int j = 0; j < getCountOfHalls() && isIndex(i); j++) {
                if (j+1 == i) {
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
        for (int i = 0; i < getCountOfHalls(); i++) {
            System.out.println("Name of hall: " + item2.data.getHallName() + ", number of books = " + item2.data.numbersOfBooks());
                    item2 = item2.next;
        }
    }
    public void changeHall(int i, IHall newHall){
        if (!isIndex(i) || isEmpty()) throw new HallIndexOutOfBoundsException();
        Item2 hall = new Item2(newHall);
        Item2 temp = head;
        for (int j = 0; j < getCountOfHalls(); j++) {
            if (j == i){
                temp = hall;
                break;
            }
            temp = temp.next;
        }
    }

    public String getInfoFromHoll() {
        StringBuilder string = new StringBuilder();
        Item2 item_2 = head;
        for (int i = 0; i < getCountOfHalls(); i++) {
            string.append("\nНазвание зала: ").append(item_2.data.getHallName());
            string.append("\nКоличество книг: ").append(item_2.data.numbersOfBooks());
            item_2 = item_2.next;
        }
        return string.toString();
    }

    @Override
    public void changeBook(int i, IBook newBook) {
        if (isIndex(i)) getLinkToHall(i).data.changeBook(i,newBook);
    }
    public void addBook(int i , IBook newBook){
        if (isIndex(i)) getLinkToHall(i).data.addBook(i,newBook);
        else throw new HallIndexOutOfBoundsException(i);
    }
    public void deleteBook (int i){
        if (isIndex(i)) getLinkToHall(i).data.delBook(i);
    }
    public IBook getBestBook(){
        IBook bestBook = new ScientificBook();
        double maxPrice = 0.0;
        for(int i = 0; i < getCountOfHalls(); i++){
            if (getLinkToHall(i).data.getBestBook().getPrice() > maxPrice){
                maxPrice = getLinkToHall(i).data.getBestBook().getPrice();
                bestBook = getLinkToHall(i).data.getBestBook();
            }
        }
        return bestBook;
    }
    public IBook[] getSortBooksByPrice() {
        IBook[] books = new ScientificBook[getCountOfBooksInLibrary()];
        IBook temp;
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
    public boolean isIndex (int i)
    {
        return i>= 0 && i < getCountOfHalls();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nКоличество залов: ").append(getCountOfHalls()).append(" ");
        str.append(getInfoFromHoll());
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfoFromHoll());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        ScientificLibrary MyLibrary = (ScientificLibrary) object;

        if (MyLibrary.getCountOfHalls() == this.getCountOfHalls()
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
            for (int i = 0; i < getCountOfHalls(); i++) {
                ((ScientificLibrary) result).addHall(i, (IHall) getHall(i).clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

}