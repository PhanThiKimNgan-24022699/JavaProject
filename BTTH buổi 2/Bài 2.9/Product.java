import java.util.Scanner;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private double discount;

    private static double taxRate = 0.1;
    private static double totalRevenue = 0.0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    //Cập nhật mức thuế VAT mới
    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    //Tính giá cuối cùng của sản phẩm
    public double calculateFinalPrice() {
        return (price - discount) * (1 + taxRate);
    }

    //Cập nhật mức giảm giá riêng
    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    //Bán hàng
    public void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            double realMoney = amount * calculateFinalPrice();
            totalRevenue += realMoney;
            System.out.println("Bán thành công " + amount + " sản phẩm " + name);
        } else {
            System.err.println("Lỗi: Không đủ hàng trong kho!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập thông tin sản phẩm 1
        System.out.println(" Nhập sản phẩm 1 ");
        System.out.print("Tên: ");
        String name1 = sc.next();
        System.out.print("Giá: ");
        double price1 = sc.nextDouble();
        System.out.print("Số lượng: ");
        int quantity1 = sc.nextInt();
        System.out.print("Giảm giá: ");
        double discount1 = sc.nextDouble();

        Product p1 = new Product(name1, price1, quantity1, discount1);

        //Nhập thông tin sản phẩm 2
        System.out.println("\n Nhập sản phẩm 2 ");
        System.out.print("Tên: ");
        String name2 = sc.next();
        System.out.print("Giá: ");
        double price2 = sc.nextDouble();
        System.out.print("Số lượng: ");
        int quantity2 = sc.nextInt();
        System.out.print("Giảm giá: ");
        double discount2 = sc.nextDouble();

        Product p2 = new Product(name2, price2, quantity2, discount2);

        p1.sell(2);

        sc.close();
    }
}
