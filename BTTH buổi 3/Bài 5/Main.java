abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();
    public abstract String getType();

    @Override
    public String toString() {
        return name + " - " + getType() + " - " + calculateSalary();
    }
}

class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus - penalty;
    }

    @Override
    public String getType() {
        return "Full-time";
    }
}

class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public String getType() {
        return "Part-time";
    }
}

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[] {
                new FullTimeEmployee("Nguyễn Văn A", 1500, 200, 50),
                new PartTimeEmployee("Trần Thị B", 80, 10),
                new FullTimeEmployee("Lê Văn C", 1400, 100, 50)
        };

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
