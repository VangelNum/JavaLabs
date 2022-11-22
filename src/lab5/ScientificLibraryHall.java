package lab5;

import lab5.exception.BookIndexOutOfBoundsException;

public class ScientificLibraryHall implements IHall {
    private Item head;
    String hallName;

    public String getName() {
        return hallName;
    }

    public void setName(String newhallName) {
        hallName = newhallName;
    }

    //---------------конструкторы-----------------------------//
    //--------------------------------------------------------//
    public ScientificLibraryHall(String hallName, int numberOfBooks) {
        setName(hallName);
        if (numberOfBooks == 0) {
            head = null;
        } else if (numberOfBooks == 1) {
            head = new Item();
            head.next = head; // зациклили
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
        if (hall == null) throw new NullPointerException("Array is null in second constructor");
        setName(hallName);
        setBooks(hall);
        int numberOfBooks = hall.length;
        if (numberOfBooks == 0) {
            head = null;
        } else if (numberOfBooks == 1) {
            head = new Item(hall[0]);
            head.next = head; // зациклили
        } else if (numberOfBooks > 1) {
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

    //------------------методы--------------------------------//
//--------------------------------------------------------//
// isEmpty() – пустой список или нет
    public boolean isEmpty() {
        return head == null;
    }

    // возвращающий количество элементов
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

    // возвращающий ссылку на элемент по номеру (возвращает null, если элемент не найден)
    public Item getLinkToElement(int i) {
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

    // добавление элемента по заданному номеру возвращает (true/false).
    // При добавлении первого элемента, список замыкается в кольцо.
    @Override
    public void addBook(int i, IBook newBook) {
        // if (isEmpty()) throw new BookIndexOutOfBoundsException(i);
        // if (isIndex(i)) throw new BookIndexOutOfBoundsException(i);
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

    // удаление элемента по заданному номеру возвращает (true/false).
    // При удалении последнего элемента (кроме головы) список должен размыкаться
    // (ссылку на следующий элемент головы установить равной null).
    @Override
    public void delBook(int i) {
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

    // замена книги
    @Override
    public void changeBook(int i, IBook newBook) {
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

    // вывод имени всех книг
    @Override
    public void print() {
        System.out.println(getName());
        Item temp = head;
        for (int i = 0; i < getNumberOfElements(); i++) {
            System.out.println(temp.data.getTitle());
            temp = temp.next;
        }
    }
    public void printAllBooks() {
        System.out.println(getName());
        Item temp = head;
        for (int i = 0; i < getNumberOfElements(); i++) {
            System.out.println(temp.data.getTitle());
            temp = temp.next;
        }
    }

    // общая стоимость
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
        return getLinkToElement(i).data;
    }

    // получение лучшей книги
    public IBook getBestBook() {
        if (isEmpty()) throw new BookIndexOutOfBoundsException("Hall is empty");
        int max = 0;
        for (int i = 1; i < numbersOfBooks(); i++) {
            if (getBook(i).getCost() > getBook(max).getCost()) max = i;
        }
        return getBook(max);
    }

    // ---------------помощь-------------------
    public boolean isIndex(int i) {
        return i >= 0 && i < getNumberOfElements();
    }

    public void setBooks(IBook[] books) {
        for (int i = 0; i < books.length; i++) {
            addBook(i, books[i]);
        }
    }

    public int numbersOfBooks() {
        return getNumberOfElements();
    }
}
