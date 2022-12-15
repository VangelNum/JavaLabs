package lab6;

import lab6.exception.BookIndexOutOfBoundsException;

import java.util.Objects;

public class ScientificLibraryHall implements IHall {
    private Item head;
    String hallName;

    public String getHallName() {
        return hallName;
    }

    public void setName(String newhallName) {
        hallName = newhallName;
    }

    public ScientificLibraryHall(String hallName, int numberOfBooks) {
        this.hallName = hallName;
        if (numberOfBooks == 0) {
            head = null;
        } else if (numberOfBooks == 1) {
            head = new Item();
            head.next = head;
        } else if (numberOfBooks > 1) {
            head = new Item();
            head.next = head;
            Item temp = head;
            Item newTemp = null;
            for (int i = 1; i < numberOfBooks; i++) {
                newTemp = new Item();
                temp.next = newTemp;
                temp = newTemp;
            }
            temp.next = head;
        }
    }

    public ScientificLibraryHall(String hallName, IBook[] hall) {
        if (hall == null) throw new NullPointerException("Array is null");
        setName(hallName);
        setBooks(hall);
        int numberOfBooks = hall.length;
        if (numberOfBooks == 0) {
            head = null;
        } else if (numberOfBooks == 1) {
            head = new Item(hall[0]);
            head.next = head;
        } else {
            head = new Item(hall[0]);
            head.next = head;
            Item temp = head;
            Item newTemp = null;
            for (int i = 1; i < numberOfBooks; i++) {
                newTemp = new Item(hall[i]);
                temp.next = newTemp;
                temp = newTemp;
            }
            temp.next = head;
        }
    }


    @Override
    public void dobavBook(int i, IBook newBook) {
        Item newBooks = new Item(newBook);
        Item temp = head;
        if (isEmpty() && i == 0) {
            head = newBooks;
            head.next = head;
        } else if (getNumberOfElements() == 1) {
            head.next = newBooks;
            newBooks.next = head;
            head = newBooks;
        } else if (i == 0) {
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            newBooks.next = temp.next;
            temp.next = newBooks;
            head = newBooks;
        } else {
            for (int j = 0; j < getNumberOfElements(); j++) {
                if (j + 1 == i) {
                    newBooks.next = temp.next;
                    temp.next = newBooks;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    @Override
    public void delete(int i) {
        if (!isIndex(i) || isEmpty()) throw new BookIndexOutOfBoundsException(i);
        Item temp = head;
        Item second = null;
        if (getNumberOfElements() == 1) {
            head = null;
            head.next = null;
        } else if (i == 0) {
            second = temp.next;
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = second;
            head = second;
        } else if (i == getNumberOfElements()) {
            temp = temp.next;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            for (int j = 0; j < getNumberOfElements(); j++) {
                if (j + 1 == i) {
                    Item first = temp;
                    temp = temp.next;
                    first.next = temp.next;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    @Override
    public void izmenenie(int i, IBook newBook) {
        if (isEmpty() || getNumberOfElements() <= i) throw new BookIndexOutOfBoundsException(i);
        int j = 0;
        Item temp = head;
        if (j == i) {
            temp.data = newBook;
        }
        j++;
        temp = temp.next;
        while (temp != head) {
            if (j == i) {
                temp.data = newBook;
            }
            j++;
            temp = temp.next;
        }
    }


    public boolean isEmpty() {
        return head == null;
    }


    public int getNumberOfElements() {
        int count = 0;
        if (isEmpty()) {
            return count;
        }
        Item temp = head;
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


    public Item getLink(int i) {
        if (!isIndex(i) || isEmpty()) return null;
        Item element = null;
        if (isEmpty()) return null;
        else if (i == 0) return head;
        else if (i == 1 && head.next != head) {
            return head.next;
        } else if (head.next == head) return null;
        else {
            Item temp = head;
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



    @Override
    public void print() {
        System.out.println(getHallName());
        Item temp = head;
        for (int i = 0; i < getNumberOfElements(); i++) {
            System.out.println(temp.data.getTitle());
            temp = temp.next;
        }
    }

    public String printAllBooks() {
        StringBuilder str = new StringBuilder();
        Item temp = head;
        for (int i = 0; i < getNumberOfElements(); i++) {
            str.append("Автор: ").append(temp.data.getAvtor());
            str.append(" Название книги: ").append(temp.data.getTitle());
            str.append(" Индекс цитируемости: ").append(temp.data.getYear());
            str.append(" Цена: ").append(temp.data.getCost());
            str.append(" ");
            temp = temp.next;
        }
        return str.toString();
    }


    public double getSumPrice() {
        Item temp = head;
        double sum = 0;
        for (int i = 0; i < getNumberOfElements(); i++) {
            sum += temp.data.getCost();
            temp = temp.next;
        }
        return sum;
    }

    @Override
    public IBook getBook(int i) {
        return getLink(i).data;
    }

    public IBook getBestBook() {
        if (isEmpty()) throw new BookIndexOutOfBoundsException("Hall is empty");
        int max = 0;
        for (int i = 1; i < numbersBooks(); i++) {
            if (getBook(i).getCost() > getBook(max).getCost()) max = i;
        }
        return getBook(max);
    }

    public boolean isIndex(int i) {
        if (i >= 0 && i < getNumberOfElements()) {
            return true;
        } else throw new BookIndexOutOfBoundsException();
    }

    public void setBooks(IBook[] books) {
        for (int i = 0; i < books.length; i++) {
            dobavBook(i, books[i]);
        }
    }

    public int numbersBooks() {
        return getNumberOfElements();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Тип зала: ").append(getHallName());
        str.append(" Количество книг: ").append(getNumberOfElements());
        str.append(" Информация по каждой книге: ").append(printAllBooks());
        return str.toString();
    }


    @Override
    public int hashCode() {
        return Objects.hash(head, hallName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ScientificLibraryHall MyHall = (ScientificLibraryHall) obj;

        if (MyHall.getNumberOfElements() == this.getNumberOfElements()
                && MyHall.printAllBooks().equals(this.printAllBooks())
        ) {
            return true;
        } else return false;

    }

    @Override
    public Object clone() {
        Object result = null;
        try {
            result = super.clone();
            ((ScientificLibraryHall) result).head = null;


            for (int i = 0; i < getNumberOfElements(); i++) {
                ((ScientificLibraryHall) result).dobavBook(i, (IBook) getBook(i).clone());
            }
        }catch (Exception e){}
        return result;
    }

}
