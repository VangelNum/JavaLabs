package lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;
public class MyCalendar {
    private int day, month, year;
    private Calendar calendar;
    public MyCalendar() {
        day = 1;
        month = 1;
        year = 1980;
        calendar = new GregorianCalendar(year, month, day);
    }
    public MyCalendar(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        calendar = new GregorianCalendar(year, month, day);
    }
    public static MyCalendar getStaticDate(MyCalendar myCalendar) {
        return new MyCalendar(myCalendar.getCalendar().get(Calendar.DAY_OF_MONTH),
                myCalendar.getCalendar().get(Calendar.MONTH),
                myCalendar.getCalendar().get(Calendar.YEAR)
        );
    }
    public void vvod(MyCalendar other){
        day = other.day;
        month = other.month;
        year = other.year;
        calendar = new GregorianCalendar(year, month, day);
    }
    public Calendar getCalendar() {
        return calendar;
    }
    public void plus(int day){
        calendar.add(Calendar.DAY_OF_MONTH, day);
    }
    public void minus(int day){
        calendar.add(Calendar.DAY_OF_MONTH, -day);
    }
    public static void plus(MyCalendar c1, int day){
        c1.getCalendar().add(Calendar.DAY_OF_MONTH, day);
    }
    public static void minus(MyCalendar c1, int day){
        c1.getCalendar().add(Calendar.DAY_OF_MONTH, -day);
    }
    public static int compareTo(MyCalendar mc1, MyCalendar mc2){
        Calendar cal1 = mc1.getCalendar();
        Calendar cal2 = mc2.getCalendar();
        return cal1.compareTo(cal2);
    }
    public static String sravni(MyCalendar mc1,MyCalendar mc2){
        int result = MyCalendar.compareTo(mc1, mc2);
        if (result == -1) return "Дата 1 меньше чем дата 2";
        if (result == 1) return "Дата 1 больше чем дата 2";
        return "Дата 1 и дата 2 равны";
    }
    public static int raz(MyCalendar z1, MyCalendar z2) {
        MyCalendar minCal, maxCal;
        int result = MyCalendar.compareTo(z1, z2);
        if (result == -1) {
            minCal = getStaticDate(z1);
            maxCal = getStaticDate(z2);
        } else if (result == 1) {
            minCal = getStaticDate(z2);
            maxCal = getStaticDate(z1);
        } else return 0;
        int counter = 0;
        while (MyCalendar.compareTo(minCal, maxCal) < 0) {
            minCal.plus(1);
            counter++;
        }
        return counter;
    }
    @Override
    public String toString() {
        return " " +
                " " + calendar.get(Calendar.DAY_OF_MONTH) +
                " " + calendar.get(Calendar.MONTH) +
                " " + calendar.get(Calendar.YEAR) +
                ' ';
    }
}
