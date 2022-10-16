package lab2;

public class Lab {
    public static void main(String[] args) {
        Complex z1 = new Complex(3, -1);
        Complex z2 = new Complex(-2, 3);
        z1.mult(z2);
        z1.X(5);
        z1.print();
       System.out.println(new Complex(3,-1));
    }
}