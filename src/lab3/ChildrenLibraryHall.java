package lab3;

public class ChildrenLibraryHall {
    private Book[] books;
    private String title;

    public ChildrenLibraryHall(String title, int amount) {
        this.title = title;
        this.books = new Book[amount];
        for (int i = 0; i < amount; i++) {
            this.books[i] = new Book();
        }
    }

    public ChildrenLibraryHall(Book[] books,String title) {
        this.books = new Book[books.length];
        System.arraycopy(books, 0, this.books, 0, books.length);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Book[] getBooks() {
        var result = new Book[this.books.length];
        System.arraycopy(this.books, 0, result, 0, books.length);
        return result;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getAmount() {
        return this.books.length;
    }

    public void printAllTitles() {
        for (var book : this.books) {
            System.out.println(book.getTitle());
        }
    }
    public double getTotalPrice() {
        double sum = 0.0;
        for (var book : this.books) {
            sum += book.getPrice();
        }
        return sum;
    }
    public Book getBookNumber(int number) {
        if (number < 0 || number > this.books.length) {
            return null;
        }
        return this.books[number];
    }
    public void changeBook(int number, Book newBook) {
        this.books[number] = newBook;
    }

    public void addBook(int number, Book newBook) {
        if (number == this.books.length) {
            var old = this.books;
            this.books = new Book[number + 1];
            this.books[number] = newBook;
            for (int i = 0; i < number; i++) {
                this.books[i] = old[i];
            }
        } else {
            var old = this.books;
            Book current = old[number];
            this.books = new Book[old.length + 1];
            this.books[number] = newBook;
            for (int i = 0; i < number; i++) {
                this.books[i] = old[i];
            }


            for (int i = number + 1; i < this.books.length; i++) {
                this.books[i] = current;
                current = i + 1 < this.books.length ? old[i] : null;
            }
        }
    }
    public void deleteBook(int number) {
        var newBooks = new Book[this.books.length - 1];
        for (int i = 0, k = 0; i < this.books.length; i++) {
            if (i == number) {
                continue;
            }
            newBooks[k++] = this.books[i];
        }
        this.books = newBooks;
    }
    public Book getBestBook() {
        Book best = new Book();
        for (var book : books) {
            if (best.getPrice() <= book.getPrice()) {
                best = book;
            }
        }
        return best;
    }
}

