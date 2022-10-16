package CII;
import java.util.Scanner;

public class Individ {
    private double w1, w2, w3;
    private double proc, func;

    public double getFunc() {
        return func;
    }

    public double getProc() {
        return proc;
    }

    public void setProc(double sum) {
        this.proc = func/sum;
    }

    public Individ(double w1, double w2, double w3, double func) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.func = func;
    }

    public double getW1() {
        return w1;
    }

    public void setW1(double w1) {
        this.w1 = w1;
    }

    public double getW2() {
        return w2;
    }

    public void setW2(double w2) {
        this.w2 = w2;
    }

    public double getW3() {
        return w3;
    }

    public void setW3(double w3) {
        this.w3 = w3;
    }

    public  double Weight(){
        double E1 = -0.36, E2 =-0.2, E3 = 0.17;
        this.func = (w1*E1 + w2* E2 + w3* E3);
        return func;
    }

    public static Individ caseR (){
        double E1 = -0.36, E2 = -0.2, E3 = 0.17;
        Scanner scan = new Scanner(System.in);
        double w1 = scan.nextDouble();
        double w2 = scan.nextDouble();
        double w3 = scan.nextDouble();
        double func = E1*w1 + E2*w2 + E3*w3;
        return new Individ(w1, w2, w3, func);
    }
}