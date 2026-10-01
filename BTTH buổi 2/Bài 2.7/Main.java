public class Main {
    public static void main(String[] args) {
        //Tạo mảng arr
        Product[] arr = new Product[2];
        arr[0] = new Product("P01", "Laptop", 1000.0);
        arr[1] = new Product("P02", "Chuột", 20.0);

        //Khởi tạo kho
        Inventory kho = new Inventory(arr);

        arr[0].setPrice(5000.0);

        kho.printInventory();
    }
}
