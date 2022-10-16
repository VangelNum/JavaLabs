package lab2;

public class vector3D {
    private double x;
    private double y;
    private double z;

    public vector3D(double i1, double i2, double i3) {
        x = i1;
        y = i2;
        z = i3;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static void multiplication(vector3D vector3D, double scalar) {
        vector3D.setX(vector3D.getX() * scalar);
        vector3D.setY(vector3D.getY() * scalar);
        vector3D.setZ(vector3D.getZ() * scalar);
    }

    public void plus(vector3D other) {
        x += other.x;
        y += other.y;
        z += other.z;
    }

    public void minus(vector3D other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
    }

    public double scalar(vector3D other) {
        return (x * other.x + y * other.y + z * other.z);
    }

    public void multiplication(double scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
    }

    public double length(vector3D i, vector3D i1, vector3D i2) {
        return Math.sqrt((x * x) + y * y + z * z);
    }

    public static String equals(vector3D v1, vector3D v2) {
        if (length(v1) < length(v2)) {
            return "Первый вектор меньше второго";
        } else if (length(v1) > length(v2)) {
            return "Первый вектор больше второго";
        }
        return "Первый и второй векторы равны";
    }

    public static vector3D plus(vector3D v1, vector3D v2) {
        return new vector3D(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static double length(vector3D v1) {
        return Math.sqrt((v1.x * v1.x) + v1.y * v1.y + v1.z * v1.z);
    }

    public static vector3D minus(vector3D v1, vector3D v2) {
        return new vector3D(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static double scalar(vector3D v1, vector3D v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public String toString() {
        return "vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + y +
                '}';
    }
}
