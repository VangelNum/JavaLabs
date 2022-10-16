package lab2;

public class Complex {
    private int re;
    private int im;

    public Complex(int i, int i1) {
        this.re = i;
        this.im = i1;
    }
    public Complex(int i) {
        this(i, 0);
    }
    public Complex(double v, double v1) {
        this(0, 0);
    }
    public Complex(Complex k) {
        this(k.re, k.im);
    }
    public static Complex del(Complex c1, Complex c2) {
        return new Complex((c1.re * c2.re + c1.im * c2.im) / (Math.pow(c2.re, 2) + Math.pow(c2.im, 2)), (c2.re * c1.im * c1.re * c2.im) / (Math.pow(c2.re, 2) + Math.pow(c2.im, 2)));
    }
    public void plus(Complex other) {
        re += other.re;
        im += other.im;
    }

    public static Complex plus(Complex c1, Complex c2) {
        return new Complex(c1.re + c2.re, c1.im + c2.im);
    }
    public void minus(Complex other) {
        re -= other.re;
        im -= other.im;
    }
    public static Complex minus(Complex c1, Complex c2) {
        return new Complex(c1.re - c2.re, c1.im - c2.im);
    }

    public void mult(Complex other) {
        this.re = this.re * other.re - this.im * other.im;
        this.im = this.re * other.im + other.re * this.im;
    }
    public static Complex mult(Complex c1, Complex c2) {
        return new Complex(c1.re * c2.re - c1.im * c2.im, c1.re * c1.im + c2.im * c1.re);
    }
    public void X(double x) {
        re *= x;
        im *= x;
    }
    public boolean sravn (Complex other){
        return (re == other.re) && (im==other.im);
    }
    public void division(Complex other) {
        this.re = (int) ((other.re * other.re + this.im * other.im) / (Math.pow(other.re, 2) + Math.pow(other.im, 2)));
        this.im = (int) ((other.re * this.im-this.re * other.im) / (Math.pow(other.re, 2) + Math.pow(other.im, 2)));
    }

    public Complex conjugate() {
        return new Complex(this.re, -1 * this.im);
    }

    public static Complex sop(Complex c1) {
        return new Complex(c1.re, -1 * c1.im);
    }

    public void print() {
        if (im < 0) {
            System.out.println(re + " " + im + "i");
        }
        if (im > 0) {
            System.out.println(re + " + " + im + "i");
        }
    }

}