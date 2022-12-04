package lab6;

public interface IBook extends Cloneable{
    public String getAvtor();

    public void setAvtor(String avtor);

    public String getTitle();

    public void setTitle(String title);

    public double getCost();

    public void setCost(double cost);

    public int getYear();

    public void setYear(int year);

    public Object clone() throws CloneNotSupportedException;

}
