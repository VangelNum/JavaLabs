package lab6;

public interface ILibrary extends Cloneable {
    public int getNumHall();

    public int getNumBooks();

    public double getPriceBooks();

    public IHall[] arrHall();

    public IHall getHall(int index);

    public IBook getBook(int index);

    public IBook[] sort();

    public void print();

    public void zamenaHoll(int i, IHall newLibraryHall);

    public void zamenaBook(int i, IBook newBook);

    public void add(int i, IBook newBook);

    public void DELETEBook(int i);

    public IBook getBestBook();

    public boolean isEmpty();
    public Object clone() throws CloneNotSupportedException;

}
