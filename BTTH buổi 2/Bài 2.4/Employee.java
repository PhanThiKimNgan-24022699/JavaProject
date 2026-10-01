public class Employee {
    private String name;
    private MyDate birthday;

    // Constructor
    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = (birthday != null) ? new MyDate(birthday) : null;
    }

    // Copy Constructor cho Employee
    public Employee(Employee other) {
        if (other != null) {
            this.name = other.name;
            this.birthday = (other.birthday != null) ? new MyDate(other.birthday) : null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | Ngày sinh: " + birthday);
    }
}
