package project;

public class Date {
    int month;
    int day;
    int year;

    // public Date() {
    // }

    public Date(int month, int day, int year) {
        // String[] date = aDate.split("/");
        // this.day = Integer.valueOf(date[0]);
        // this.month = Integer.valueOf(date[1]);
        // this.year = Integer.valueOf(date[2]);
        this.month = Integer.valueOf(month);
        this.day = Integer.valueOf(day);
        this.year = Integer.valueOf(year);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

}
