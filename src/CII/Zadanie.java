package CII;

public class Zadanie {

    static double e1 = 0.004726;
    static double e2 = 0.165911;
    static double e3 = 5.92154;

    static double w1 = 0;
    static double w2 = 0;
    static double w3 = 0;
    static double adaptive = 0;
    static double allapdative = 0;

    int[] x;
    int[] hromo;
    int[] Population;

    public Zadanie() {
        w1 = Math.random();
        w2 = (Math.random() * (1 - w1));
        w3 = 1 - w1 - w2;
        adaptive = w1 * e1 + w2 * e2 + w3 * e3;
    }

    public static void binary(int[] arr) {
    }

    public static void Individ(String[] arr) {
        w1 = Math.random();
        w2 = (Math.random() * (1 - w1));
        w3 = 1 - w1 - w2;
        adaptive = w1 * e1 + w2 * e2 + w3 * e3;
        allapdative = allapdative + adaptive;
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 127);
        }

        String[] binaryarr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            binaryarr[i] = Integer.toBinaryString(arr[i]);
        }
        for (int i = 0; i < binaryarr.length; i++) {
            StringBuilder sb = new StringBuilder(binaryarr[i]);
            int sizeofstring = binaryarr[i].length();
            while (sizeofstring != 7) {
                sb.insert(0, "0");
                sizeofstring++;
            }
            binaryarr[i] = String.valueOf(sb);
            System.out.println(binaryarr[i]);
        }

        for (int i = 0; i < binaryarr.length;i++) {
            w1 = Math.random();
            w2 = (Math.random() * (1 - w1));
            w3 = 1 - w1 - w2;
            adaptive = w1 * e1 + w2 * e2 + w3 * e3;
            allapdative = allapdative + adaptive;
        }
    }
}
