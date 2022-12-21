package lab5;

import java.io.Serializable;

public interface IBook extends Cloneable, Serializable {
    public String getAuthor();
    public String getName();
    public double getPrice();
    public int getYear();

    public void setAuthor(String author);
    public void setName(String name);
    public void setPrice(double price);
    public void setYear(int year);

    public Object clone() throws CloneNotSupportedException;
}
