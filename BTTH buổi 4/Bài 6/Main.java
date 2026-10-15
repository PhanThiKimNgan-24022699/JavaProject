abstract class Product {
    protected String name;
    protected double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double getFinalPrice();
    public abstract String getType();

    @Override
    public String toString() {
        return name + " - " + getType() + " - " + getFinalPrice();
    }
}

class Electronics extends Product {
    private double insuranceFee;

    public Electronics(String name, double basePrice, double insuranceFee) {
        super(name, basePrice);
        this.insuranceFee = insuranceFee;
    }

    @Override
    public double getFinalPrice() {
        //giá gốc + 10% VAT + phí bảo hành
        return basePrice + (basePrice * 0.10) + insuranceFee;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}

class Food extends Product {
    private String expireDate; // Ngày hết hạn

    public Food(String name, double basePrice, String expireDate) {
        super(name, basePrice);
        this.expireDate = expireDate;
    }

    @Override
    public double getFinalPrice() {

        if (name.equalsIgnoreCase("Bread")) {
            return basePrice * 0.8; //giảm 20%
        }
        return basePrice;
    }

    @Override
    public String getType() {
        return "Food";
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[] {
                new Electronics("Laptop", 1000, 50),
                new Food("Milk", 30, "2025-03-15"),
                new Food("Bread", 20, "2025-03-05")
        };

        double total = 0;

        for (Product p : products) {
            System.out.println(p);
            total += p.getFinalPrice();
        }

        System.out.println("Total = " + total);
    }
}
