import java.util.ArrayList;

import Select.Individ.Chromosome;
import Select.Individ.Individ;
import Select.Individ.Population;

class Main {
    public static void main(String[] args) {

        Population population = new Population(50);
        double lastAdapt = 0;
        population.parentPullGen();
        population.crossing();
        int stability = 0;

        for (int i = 0; i < 1000; i++) {
            lastAdapt = population.getAllAdapt();
            population = new Population(population.getChildern());
            population.parentPullGen();
            population.crossing();
            System.out.println(population.getAllAdapt());
            if (lastAdapt == population.getAllAdapt()) {
                stability++;
            } else {
                stability = 0;
            }
            if (stability == 15) {
                Population population1 = new Population(population.getChildern());
                population1.outPop();
                break;
            }
        }
    }
}
