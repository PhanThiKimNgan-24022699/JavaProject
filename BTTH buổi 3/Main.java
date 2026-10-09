interface Payable {
    double getPaymentAmount();
}

class PartTimeStaff implements Payable {
    private String id;
    private String name;
    private double workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, double workingHours, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }

    @Override
    public String toString() {
        return "PartTimeStaff " + name + " - Payment: " + getPaymentAmount();
    }
}

class Invoice implements Payable {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return "Invoice " + itemName + " - Payment: " + getPaymentAmount();
    }
}

public class Main {
    public static void main(String[] args) {
        //tạo mảng đối tượng đa hình qua interface
        Payable[] list = new Payable[] {
                new PartTimeStaff("PT01", "NguyenVanA", 40, 10),
                new Invoice("Laptop", 2, 500),
                new PartTimeStaff("PT02", "TranThiB", 20, 12)
        };

        double totalPayment = 0;

        for (Payable item : list) {
            System.out.println(item);
            totalPayment += item.getPaymentAmount();
        }

        System.out.println("Total Payment = " + totalPayment);
    }
}
