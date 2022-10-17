package Select.Individ;

public class Chromosome {
    private String chrom = "";
    private int chlen;
    public Chromosome (double [] arr){
        for(int i = 0; i < 3; i++){
            chrom += createChr(arr[i]);
            chlen = chrom.length();
        }
    }

    public String getChrom(){
        return chrom;
    }
    public String createChr(double w){
        w = w*100;
        long digit;
        String bin = "", stNum;
        int intRem, intPart;
        double  frPart, frRem;
        frPart = w % 1;
        intPart = (int)(w - frPart);
        for (int i = 0; i < 7; i++) {
            intRem = intPart % 2;
            digit = Math.round(intRem);
            stNum = String.valueOf(digit);
            bin = stNum.concat(bin);
            intPart = (intPart - intRem) / 2;
        }
        for (int i = 0; i < 3; i++) {
            frPart *= 2;
            frRem = frPart % 1;
            digit = Math.round(frPart - frRem);
            stNum = String.valueOf(digit);
            bin = bin.concat(stNum);
            frPart = frRem;
        }
        return bin;
    }


    public double decod(String s){
        double w = 0;
        double doublePart = 0;
        String intPart = s.substring(0, 7) , frPart = s.substring(7,10);

        for (int i = 0; i < 7; i++){
            char ch = s.charAt(i);
            int num = Character.getNumericValue(ch);
            w += num*Math.pow(2,6-i);

        }for (int i = 7; i < 10; i++){
            char ch = s.charAt(i);
            int num = Character.getNumericValue(ch);
            w += num*Math.pow(2,6-i);
        }
        return  w;
    }
    public double [] decodWeights(){
        int size = 3;
        double [] arr = new double[size];
        for (int i = 0; i < size; i++){
            String bin = chrom.substring(i*10 , (i+1)* 10);
            arr[i] = decod(bin)/100;
        }
        return arr;
    }
    public void hybritization(String chrom1, String chrom2, String chrom3){
        int index = (int)(Math.random()*((0.5*chlen -0.25*chlen)+1) + 0.25*chlen);
        int index2 = (int)(Math.random()*((0.75*chlen -0.51*chlen)+1) + 0.51*chlen);
        chrom = chrom1.substring(0, index) + chrom2.substring(index, index2) + chrom3.substring(index2,chlen);
    }


    public void mutation(){
        double chance = Math.random();
        if (chance <= 0.005){
            String zero = "0", one = "1";
            int index = (int)(Math.random()*((chlen+1) )-1);
            if (chrom.substring(index) == zero){
                chrom = chrom.substring(0,index) + one + chrom.substring(index + 1, chrom.length());
            }
            else {
                chrom = chrom.substring(0,index) + zero + chrom.substring(index + 1, chrom.length());
            }
        }

    }
}
