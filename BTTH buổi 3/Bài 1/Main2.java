class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
        System.out.println("1. Person is created with name: " + name);
    }
}

// Lớp Employee dùng super(name) để gọi constructor của Person
class Employee extends Person {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
        System.out.println("2. Employee is created");
    }

    public Employee() {
        super("Unknown");
        System.out.println("2. Employee is created");
    }
}

// Lớp Manager dùng super() để gọi constructor của Employee
class Manager extends Employee {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
        System.out.println("3. Manager is created");
    }

    public Manager() {
        super();
        System.out.println("3. Manager is created");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}
