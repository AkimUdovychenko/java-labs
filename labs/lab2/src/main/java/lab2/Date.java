package lab2;

public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public void setMonth(int month) { this.month = (month >= 1 && month <= 12) ? month : 1; }
    public int getMonth() { return month; }

    public void setDay(int day) { this.day = (day >= 1 && day <= 31) ? day : 1; }
    public int getDay() { return day; }

    public void setYear(int year) { this.year = (year >= 1) ? year : 2000; }
    public int getYear() { return year; }

    public void displayDate() { System.out.println(month + "/" + day + "/" + year); }
}
