package lab4.Job1;

public class ScientificLibraryHall {

    private Item head;
    String hallName;

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallName() {
        return hallName;
    }


    public ScientificLibraryHall(String hallName, ScientificLibrary[] hall) {
        this.hallName = hallName;

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
            Item newTemp;

            for (int i = 1; i < numberOfBooks; i++) {
                newTemp = new Item(hall[i]);
                temp.next = newTemp;
                temp = newTemp;
            }
            temp.next = head;
        }
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
            Item newTemp;

            for (int i = 1; i < numberOfBooks; i++) {
                newTemp = new Item();
                temp.next = newTemp;
                temp = newTemp;
            }
            temp.next = head;
        }

    }

    public int getnumberofbook() {
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

    public Item getLinkToElement(int i) {
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


    public void changeBook(int indexOfElement, ScientificLibrary newValue) {
        if (isEmpty()) return;
        Item temp = getLinkToElement(indexOfElement);
        temp.data.setAuthor(newValue.getAuthor());
        temp.data.setName(newValue.getName());
        temp.data.setPrice(newValue.getPrice());
        temp.data.setYear(newValue.getYear());
        temp.data.setIndex(newValue.getIndex());
    }

    public boolean addBook(int i, ScientificLibrary newBook) {
        if (isEmpty()) return true;
        boolean flag = false;
        Item newBooks = new Item(newBook);
        Item temp = head;

      if (isEmpty()) {
            head = newBooks;
            head.next = head;
            flag = true;
        } else if (i == 0) {
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            newBooks.next = temp.next;
            temp.next = newBooks;
            head = newBooks;
            flag = true;
        } else {
            for (int j = 0; j < getnumberofbook(); j++) {
                if (j + 1 == i) {
                    newBooks.next = temp.next;
                    temp.next = newBooks;
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
        }
        return flag;
    }

    public boolean deleteBook(int i) {
        if (isEmpty()) return true;

        boolean flag = false;
        Item temp = head;
        Item second;
        if (i == 0) {
            second = temp.next;
            temp = temp.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = second;
            head = second;
            flag = true;
        } else {
            for (int j = 0; j < getnumberofbook(); j++) {
                if (j + 1 == i) {
                    Item first = temp;
                    temp = temp.next;
                    first.next = temp.next;
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
        }
        return flag;

    }

    public void printAllBooks() {

        System.out.println(getHallName());
        Item temp = head;
        for (int i = 0; i < getnumberofbook(); i++) {
            System.out.println(temp.data.getName());
            temp = temp.next;
        }
    }

    public double getPrice() {
        Item temp = head;
        double sum = 0;
        for (int i = 0; i < getnumberofbook(); i++) {
            sum += temp.data.getPrice();
            temp = temp.next;
        }
        return sum;
    }

    public Item getBestBook() {
        Item temp = head;
        Item BestBook = temp;
        double price = temp.data.getPrice();
        temp = temp.next;
        for (int i = 1; i < getnumberofbook(); i++) {
            if (temp.data.getPrice() >= price) {
                price = temp.data.getPrice();
                BestBook = temp;
            }
            temp = temp.next;
        }
        return BestBook;
    }


    public boolean isEmpty() {
        return head == null;
    }

}