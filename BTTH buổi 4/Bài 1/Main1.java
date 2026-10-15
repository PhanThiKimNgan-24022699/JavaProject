class Person {
    protected String name;
    public Person() {
        System.out.println("1. Person is created");
    }
}

//Employee kế thừa Person
class Employee extends Person {
    private double salary;
    public Employee() {
        System.out.println("2. Employee is created");
    }
}

// Lớp Manager kế thừa Employee
class Manager extends Employee {
    private String department;

    public Manager() {
        System.out.println("3. Manager is created");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}
