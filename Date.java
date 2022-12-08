package project;
// class declaration
public class Date {
    //data members
    int month;
    int day;
    int year;

    // public Date() {
    // }

    // constrcutor with parameters
    public Date(int month, int day, int year) {
        this.month = Integer.valueOf(month);
        this.day = Integer.valueOf(day);
        this.year = Integer.valueOf(year);
    }// end constructor with parameters

    // method to return month 
    public int getMonth() {
        return month;
    }// end method getMonth

    // method to set month
    public void setMonth(int month) {
        this.month = month;
    }// end method setMonth

    // method to return day
    public int getDay() {
        return day;
    }// end method getDay

    // method to set day
    public void setDay(int day) {
        this.day = day;
    }// end method to setDay

    // method to return year
    public int getYear() {
        return year;
    }// end method getYear

    // method to set year
    public void setYear(int year) {
        this.year = year;
    }// end method setYear

    //override method toString
    @Override
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }// end method toString

}// end class Date
