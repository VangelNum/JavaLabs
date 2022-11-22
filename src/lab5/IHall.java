package lab5;

public interface IHall {
    public void setBooks(IBook[] books);

    public String getName();

    public void setName(String name);

    public int numbersOfBooks();

    public void print();

    public double getSumPrice();

    public IBook getBook(int i);

    public IBook getBestBook();

    public void changeBook(int i, IBook book);

    public void addBook(int i, IBook book);

    public void delBook(int i);
}