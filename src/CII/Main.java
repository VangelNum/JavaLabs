package CII;

import CII.Individ;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double allW = 0;
        System.out.println("Input num of cases");
        Scanner scan1 = new Scanner(System.in);
        int n = scan1.nextInt();
        Individ[] population = new Individ[n];

        for (int i = 0; i < n; i++){
            System.out.println("Input three weights");
            population[i] = Individ.caseR();
            allW += Math.abs(population[i].getFunc());
        }
        for (int i = 0; i < n; i++){
            population[i].setProc(allW);
            System.out.println(population[i].getProc());
        }

        System.out.println("Input num of portfolios");
        Scanner scan2 = new Scanner(System.in);
        int numOfPort = scan2.nextInt();
        Individ portfolio [] = new Individ[numOfPort];

        for (int i = 0; i < numOfPort; i++){
            double scale = Math.abs(population[0].getProc());
            double randN = Math.random();
            System.out.println(randN);
            for (int j = 0; j < n; j++){
                if (randN <= scale){
                    portfolio[i] = population[j];
                    System.out.println(j);
                    j = n;
                }
                else {
                    scale += Math.abs(population[j + 1].getFunc());
                }
            }
        }
    }
}
