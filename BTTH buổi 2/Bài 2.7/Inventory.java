public class Inventory {
    private Product[] items;

    public Inventory(Product[] initialItems) {
        this.items = initialItems;
    }

    public void printInventory() {
        System.out.println(" Danh sách sản phẩm trong kho ");
        for (Product item : items) {
            System.out.println(item);
        }
    }
}
