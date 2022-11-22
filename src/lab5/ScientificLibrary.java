package lab5;

import lab5.exception.HallIndexOutOfBoundsException;

public class ScientificLibrary implements ILibrary {
    private Item2 head;

    public ScientificLibrary(int numberOfHalls, int[] sizeBooksInHall) {
        if (numberOfHalls == 0) {
            head = null;
        } else if (numberOfHalls == 1) {
            head = new Item2("unknown", sizeBooksInHall[0]);
            head.next = head; // зациклили
            head.prev = head;
        } else if (numberOfHalls > 1) {
            head = new Item2("unknown", sizeBooksInHall[0]);
            head.next = head;
            head.prev = head;
            Item2 temp = head;
            Item2 oldTemp;
            Item2 newTemp;
            for (int i = 1; i < numberOfHalls; i++) {
                newTemp = new Item2("unknown", sizeBooksInHall[i]);
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
            numBook += temp.data.numbersOfBooks();
            temp = temp.next;
        }
        return numBook;
    }

    public int getNumHall(IHall hall) {
        int numBook = 0;
        Item2 temp = head;
        for (int i = 0; i < hall.numbersOfBooks(); i++) {
            numBook += temp.data.numbersOfBooks();
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
    public IHall[] getArrayHalls() {
        IHall[] iHall = new IHall[getNumHall()];
        Item2 temp = head;
        for (int i = 0; i < getNumHall(); i++) {
            iHall[i] = getHall(i);
        }
        return iHall;
    }

    public IHall getHall(int i) {
        return new ScientificLibraryHall(getLinkToHall(i).data.getName(), getLinkToHall(i).data.numbersOfBooks());
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
            System.out.println("Name hall: " + item2.data.getName() + ", number of books = " + item2.data.numbersOfBooks());
            item2 = item2.next;
        }
    }

    public void changeHall(int i, IHall newHall) {
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
    public void changeBook(int i, IBook newBook) {
        if (isIndex(i)) getLinkToHall(i).data.changeBook(i, newBook);
    }


    public void addBook(int i, IBook newBook) {
        if (isIndex(i)) getLinkToHall(i).data.addBook(i, newBook);
        else throw new HallIndexOutOfBoundsException(i);
    }


    public void deleteBook(int i) {
        if (isIndex(i)) getLinkToHall(i).data.delBook(i);
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

    public IBook[] getSort() {
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
        return i >= 0 && i < getNumHall();
    }
}