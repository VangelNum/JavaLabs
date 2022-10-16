package libraries;

public class ChildrenLibrary {
    private ChildrenLibraryHall[] halls;

    public ChildrenLibrary(int amount, int[] booksAmountArr) {
        this.halls = new ChildrenLibraryHall[amount];
        for (int i = 0; i < amount; i++) {
            this.halls[i] = new ChildrenLibraryHall("Не определено",
                    booksAmountArr[i]);
        }
    }
    public ChildrenLibrary(ChildrenLibraryHall[] halls) {
        this.halls = new ChildrenLibraryHall[halls.length];
        for (int i = 0; i < halls.length; i++) {
            this.halls[i] = new ChildrenLibraryHall(halls[i].getBooks(),
                    halls[i].getTitle());
        }
    }

    public int getAmountOfHalls() {
        return this.halls.length;
    }
    public int getAmountOfBooks(int number) {
        return this.halls[number].getAmount();
    }
    public int getAmountOfAllBooks() {
        int sum = 0;
        for (var hall : this.halls) {
            sum += hall.getAmount();
        }
        return sum;
    }

    public ChildrenLibraryHall[] getHalls() {
        return this.halls;
    }
    public ChildrenLibraryHall getHall(int number) {
        return this.halls[number];
    }
    public Book getBook(int numberBook) {
        int add = 0;
        for (int i = 0; i < this.halls.length; i++) {
            add += this.halls[i].getAmount();
            if (numberBook < add) {
                return numberBook >= this.halls[i].getAmount() ?
                        this.halls[i].getBookNumber(numberBook - add +
                                this.halls[i].getAmount()) :
                        this.halls[i].getBookNumber(numberBook);
            }
        }
        return null;
    }

    private static Book[] sortArray(Book[] arr) {
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getPrice() < arr[j + 1].getPrice()) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        }
        return arr;
    }

    private Book[] mergeArrays(Book[] arr1, Book[] arr2, int n1, int n2) {
        Book[] arr3 = new Book[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i].getPrice() > arr2[j].getPrice())
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < n1)
            arr3[k++] = arr1[i++];
        while (j < n2)
            arr3[k++] = arr2[j++];
        return arr3;
    }

    public Book[] getPriceSortedBooks() {
        Book[] result = new Book[0];
        Book[] sorted1;
        Book[] sorted2;
        for (int i = 0; i < this.halls.length; i++) {
            if (i + 1 < this.halls.length) {
                sorted1 = ChildrenLibrary.sortArray(this.halls[i].getBooks());
                sorted2 = ChildrenLibrary.sortArray(this.halls[i + 1].getBooks());
                result = this.mergeArrays(sorted1, sorted2, this.halls[i].getAmount(),
                        this.halls[i + 1].getAmount());
            }
        }
        return result;
    }
    public void printAllHalls() {
        for (var hall : this.halls) {
            System.out.println(hall.getTitle() + " " + hall.getAmount());
        }
    }
    public void changeHall(int number, ChildrenLibraryHall hall) {
        this.halls[number] = hall;
    }
    public void changeBookInHall(int numberHall, int numberBook, Book book) {
        this.halls[numberHall].changeBook(numberBook, book);
    }
    public void addBookInHall(int numberHall, int numberBook, Book book) {
        this.halls[numberHall].addBook(numberBook, book);
    }

    public void removeBookInHall(int numberHall, int numberBook) {
        this.halls[numberHall].deleteBook(numberBook);
    }
    public Book getBestBook() {
        Book best = new Book();
        for (var hall : this.halls) {
            var currentBest = hall.getBestBook();
            if (currentBest.getPrice() > best.getPrice()) {
                best = currentBest;
            }
        }
        return best;
    }
}

