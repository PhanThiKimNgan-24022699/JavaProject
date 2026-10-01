public class BankAccount {
    //Thuộc tính (Fields)
    private final String accountNumber; 
    private String ownerName;    
    private double balance;  

    //Hàm khởi tạo (Constructors)
    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (initialBalance < 0) {
            System.out.println("Lỗi: Số dư ban đầu không được âm! Gán mặc định bằng 0.");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    //Phương thức (Methods)

    // Getter cho accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter/Setter cho ownerName
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // deposit(double amount): nạp tiền. Số tiền nạp phải > 0
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Nạp thành công " + amount + " VNĐ. Số dư hiện tại: " + this.balance + " VNĐ.");
        } else {
            System.out.println("Lỗi nạp tiền: Số tiền nạp phải lớn hơn 0!");
        }
    }

    // withdraw(double amount): Rút tiền. Số tiền rút phải > 0 và <= số dư hiện tại
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi rút tiền: Số tiền rút phải lớn hơn 0!");
            return false;
        }
        if (amount > this.balance) {
            System.out.println("Lỗi rút tiền: Số dư không đủ! (Số dư hiện tại: " + this.balance + " VNĐ)");
            return false;
        }

        this.balance -= amount;
        System.out.println("Rút thành công " + amount + " VNĐ. Số dư còn lại: " + this.balance + " VNĐ.");
        return true;
    }

    //Hàm Main
    public static void main(String[] args) {
        System.out.println("KỊCH BẢN THỬ NGHIỆM BẢO VỆ DỮ LIỆU TÀI KHOẢN");

        //Tạo tài khoản với số dư âm
        System.out.println("\n1. Khởi tạo tài khoản với số dư âm (-500):");
        BankAccount acc = new BankAccount("STK123", "Nguyen Van A", -500.0);
        System.out.println("Số dư khởi tạo thành công: " + acc.getBalance());

        //Nạp tiền âm
        System.out.println("\n2. Nạp tiền âm (-200):");
        acc.deposit(-200.0);

        //Nạp tiền hợp lệ
        System.out.println("\n3. Nạp tiền hợp lệ (+1000):");
        acc.deposit(1000.0);

        //Rút quá số dư
        System.out.println("\n4. Rút tiền quá số dư (Rút 1500, trong khi balance = 1000):");
        boolean result1 = acc.withdraw(1500.0);
        System.out.println("Kết quả rút tiền: " + result1);

        //Rút tiền hợp lệ
        System.out.println("\n5. Rút tiền hợp lệ (Rút 400):");
        boolean result2 = acc.withdraw(400.0);
        System.out.println("Kết quả rút tiền: " + result2);
    }
}
