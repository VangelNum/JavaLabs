package lab5;

public interface ILibrary {
    public int getNumHall();

    public int getNumBooks();

    public double getPriceBooks();

    public IHall[] getArrayHalls();

    public IHall getHall(int index);

    public IBook getBook(int index);

    public IBook[] getSort();

    public void print();

    public void changeHall(int i, IHall newLibraryHall);

    public void changeBook(int i, IBook newBook);

    public void addBook(int i, IBook newBook);

    public void deleteBook(int i);

    public IBook getBestBook();

    public boolean isEmpty();
}
