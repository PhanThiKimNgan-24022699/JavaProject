public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int count; 
  
    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.history = new Transaction[100]; //Khởi tạo mảng chứa tối đa 100 giao dịch
        this.count = 0;
    }

    public void addTransaction(Transaction t) {
        if (count < history.length) {
            history[count] = t;
            count++;
        }
    }

    public Transaction[] getHistory() {
        Transaction[] copy = new Transaction[count];
        for (int i = 0; i < count; i++) {
            copy[i] = history[i];
        }
        return copy;
    }

    public void printHistory() {
        System.out.println("LỊCH SỬ GIAO DỊCH GỐC TRONG NGÂN HÀNG");
        for (int i = 0; i < count; i++) {
            System.out.println(history[i]);
        }
    }
}
