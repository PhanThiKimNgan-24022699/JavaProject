public class Main {
    public static void main(String[] args) {
        // Tạo emp1
        MyDate date1 = new MyDate(1, 1, 2000);
        Employee emp1 = new Employee("Nguyen Van A", date1);

        //Tạo emp2
        Employee emp2 = new Employee(emp1);

        System.out.println("Bắt đầu");
        System.out.print("emp1: "); emp1.displayInfo();
        System.out.print("emp2: "); emp2.displayInfo();

        emp1.getBirthday().setDate(2, 2, 2022);

        System.out.println("\nSau khi thay đổi ngày sinh của emp1 thành 2/2/2022");
        System.out.print("emp1: "); emp1.displayInfo();
        System.out.print("emp2: "); emp2.displayInfo();
    }
}
