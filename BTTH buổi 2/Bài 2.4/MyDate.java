public class MyDate {
    private int day;
    private int month;
    private int year;

    //Constructor
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Copy Constructor cho MyDate
    public MyDate(MyDate other) {
        if (other != null) {
            this.day = other.day;
            this.month = other.month;
            this.year = other.year;
        }
    }

    // Getter & Setter
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
