package Select.Individ;

public class Population {

    private int size;
    private double allAdapt = 0;
    private  Individ [] population ;
    private  Individ [] parents ;
    private  Individ [] childern ;

    public double getAllAdapt() {return allAdapt;}
    public int getSize() { return size; }
    public Individ[] getPopulation() {return population;}
    public Individ [] getChildern() { return childern;}


    public Population(int size){
        this.size = size;
        this.population = new Individ[size];
        for(int i = 0; i < size; i++){
            population[i] = new Individ();
            allAdapt += population[i].getAdaptive();
        }
        for(int i = 0; i < size; i++){
            population[i].setProcAdapt(allAdapt);
        }
    }

    public Population(Individ[] oldPop){
        this.size = oldPop.length;
        this.population = new Individ[size];
        this.population = oldPop;
        for(int i = 0; i < size; i++){
            allAdapt += population[i].getAdaptive();
        }
        for(int i = 0; i < size; i++){
            population[i].setProcAdapt(allAdapt);
        }
    }

    public  boolean isInArr(int index,int size,  int [] arr){
        for(int i= 0; i < size; i++){
            if(arr[i] == index){
                return false;
            }
        }
        return true;
    }
    public void parentPullGen(){
        int parSize = (int)(Math.random()*((0.5*size-0.25*size)+1) + 0.25*size);
        this.parents = new Individ[parSize];
        int[] arr = new int[parSize];
        for(int p = 0; p < parSize; p++){
            boolean flag = false;
            double randNum = Math.random();
            // System.out.println(randNum);
            double sum = 0;
            for(int i = 0; i  < size; i ++){
                sum += population[i].getProcAdapt();
                if(sum >= randNum & isInArr(i, p, arr)){
                    parents[p] = population[i];
                    arr[p]= i;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                p--;
            }
        }
    }

    public void crossing(){
        int pl = parents.length;
        this.childern = new Individ[size];
        for(int i = 0; i < size; i++){
            int randPar1 = (int)(Math.random()*((pl)));
            int randPar2 = (int)(Math.random()*((pl)));
            while (randPar1 == randPar2){
                randPar2 = (int)(Math.random()*((pl)));
            }
            Chromosome ch1 = new Chromosome(parents[randPar1].getWeights());
            Chromosome ch2 = new Chromosome(parents[randPar2].getWeights());
            Chromosome ch3 = new Chromosome(parents[randPar2].getWeights());
            ch3.hybritization(ch1.getChrom(), ch2.getChrom());
            ch3.mutation();
            childern[i] = new Individ(ch3.decodWeights());
            childern[i].reCountWeights();
        }
    }

    public  void outPar(){
        for(int i = 0; i < parents.length; i++){
            System.out.print(i + " ");
            parents[i].printW();
            System.out.println();
        }
    }

    public  void outPop(){
        for(int i = 0; i < size; i++){
            System.out.print(i + " ");
            population[i].printW();
            System.out.println();
        }
    }

    public void outChrom(){
        for(int i = 0; i < size; i++){
            Chromosome ch = new Chromosome(population[i].getWeights());
            System.out.println(i + " " + ch.getChrom());
        }
    }


}
