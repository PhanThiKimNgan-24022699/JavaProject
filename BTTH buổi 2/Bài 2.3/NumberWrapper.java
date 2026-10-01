public class NumberWrapper {
    private int value;

    // Constructor
    public NumberWrapper(int value) {
        this.value = value;
    }

    // Getter và Setter
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public static void swap(NumberWrapper a, NumberWrapper b) {
        NumberWrapper temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        //Tạo 2 đối tượng n1 (value=5) và n2 (value=10)
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);

        System.out.println("Trước khi gọi swap:");
        System.out.println("n1 = " + n1.getValue() + ", n2 = " + n2.getValue());

        swap(n1, n2);

        System.out.println("\nSau khi gọi swap:");
        System.out.println("n1 = " + n1.getValue() + ", n2 = " + n2.getValue());
    }
}
