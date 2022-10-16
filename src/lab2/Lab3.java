package lab2;

public class Lab3 {
    public static void main(String[] args) {
        MyCalendar c1 = new MyCalendar(28, 9, 2022);
        MyCalendar c2 = new MyCalendar(1, 1, 2007);
        System.out.println("Дата " + c1 );
        MyCalendar.plus(c1,200);
        System.out.println("Дата после прибавления дней: " + c1 );
        System.out.println("Вторая дата: " + c2 );
        System.out.println("Разница в днях между датами: " + MyCalendar.raz(c1, c2));
        MyCalendar.minus(c1,300);
        System.out.println("Дата после вычетания дней: " + c1 );
        System.out.println(MyCalendar.sravni(c1,c2));
    }
}
