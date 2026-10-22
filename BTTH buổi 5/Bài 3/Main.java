interface IWorkable {
    void work();
}

abstract class Employee implements IWorkable {
    String id, name;
    double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();
}

class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculatePay() {
        return baseSalary;
    }

    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}

class Technician extends Employee {
    int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new OfficeWorker("E01", "NguyenVanA", 5000000),
                new Technician("E02", "TranThiB", 5000000, 30),
                new OfficeWorker("E03", "LeVanC", 4500000)
        };

        double totalPay = 0;

        for (Employee emp : employees) {
            double pay = emp.calculatePay();
            totalPay += pay;

            System.out.println(emp.name + " - Pay: " + pay);
            emp.work();
            System.out.println();
        }
        System.out.printf("Total Pay = %.1f\n", totalPay);
    }
}
