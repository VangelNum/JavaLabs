package Select.Individ;

public class Individ {

    private double [] w = {0, 0, 0};

    private  double [] e = {0.0259,0.000772,0.00166};

    private double adapt;
    private double procAdapt;

    public double getProcAdapt() {
        return procAdapt;}
    public double getAdaptive() {
        return adapt;
    }

    public double[] getProfits() {return e;}

    public double[] getWeights() {return w;}

    public  void setProcAdapt(double sumAdapt){procAdapt = adapt / sumAdapt;}

    public Individ(){
        w[0] = Math.random();
        w[1] =  (Math.random()*(1-w[0]));
        w[2] = 1 - w[0] - w[1];
        this.adapt = w[0]*e[0] +  w[1]*e[1] +  w[2]*e[2];
    }
    public Individ(double [] arr){
        for(int i = 0; i < 3; i++){
            w[i] = arr[i];
        }
        this.adapt = w[0]*e[0] +  w[1]*e[1] +  w[2]*e[2];
    }

    public void printW(){
        for(int i = 0;i < 3 ; i++){
            System.out.print(w[i] + " ");
        }
    }

    public void reCountWeights(){
        double sumW = 0;
        for(int i = 0; i < 3; i++){
            sumW += w[i];
        }
        for(int i = 0; i < 3; i++){
            w[i] /= sumW;
        }
    }

}