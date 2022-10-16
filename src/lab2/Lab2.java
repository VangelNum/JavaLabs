package lab2;

public class Lab2 {
    public static void main(String[] args) {
        vector3D z1 = new vector3D (1,2,3);
        vector3D z2 = new vector3D (3,2,1);
        System.out.println("Текущие вектора " + z1 + " " + z2);
        vector3D plus = vector3D.plus(z1,z2);
        System.out.println("Cложение векторов = " + plus);
        vector3D minus = vector3D.minus(z1,z2);
        System.out.println("Вычитание векторов = " + minus);
        double scalar = vector3D.scalar(z1,z2);
        System.out.println("Скaлярное произведение векторов = " + scalar);
    }
}