package ProjectV6;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dateset {

    private int day;
    private int month;
    private int year;
    // private Dateset date;

    public Dateset() {

    }

    public Dateset(int newYear, int newMonth, int newDay) {
        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
        dateSet(newYear, newMonth, newDay);

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate dateSet(int aYear, int aMonth, int aDay) {
        LocalDate date = LocalDate.of(aYear, aMonth, aDay);
        return date;
    }

    /*
     * This part recieves start time and end time of the treatment, the calculates
     * the difference and return it
     */
    public LocalTime Duration(LocalTime start, LocalTime End) {
        LocalTime diff = End.minusNanos(start.toNanoOfDay());
        return diff;
    }
}
