abstract class Product {
    String id;
    String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Food extends Product {
    String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return name + " - " + expiryDate;
    }
}

class Electronic extends Product {
    int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    public String toString() {
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}

class Warehouse<T extends Product> {
    private T[] items;
    private int count = 0;

    public Warehouse(T[] storage) {
        this.items = storage;
    }

    //nhập kho
    public void addItem(T item) {
        if (count < items.length) {
            items[count] = item;
            count++;
        }
    }

    //kiểm kê
    public void inventory() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Warehouse<Food> foodWarehouse = new Warehouse<>(new Food[10]);
        foodWarehouse.addItem(new Food("P01", "Gao", "2026-12-31"));
        foodWarehouse.addItem(new Food("P03", "Sua", "2026-06-01"));
        foodWarehouse.addItem(new Food("P05", "BanhMi", "2026-03-25"));

        Warehouse<Electronic> electronicWarehouse = new Warehouse<>(new Electronic[10]);
        electronicWarehouse.addItem(new Electronic("P02", "Tivi", 24));
        electronicWarehouse.addItem(new Electronic("P04", "TuLanh", 36));

        System.out.println("Kho Thực phẩm:");
        foodWarehouse.inventory();

        System.out.println(); 

        System.out.println("Kho Điện tử:");
        electronicWarehouse.inventory();
    }
}
