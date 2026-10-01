public class Main {
    public static void main(String[] args) {
        //Tạo tài khoản và thêm 1 giao dịch
        Account acc = new Account("AC123", 5000);
        Transaction t1 = new Transaction("T01", 1000, "2026-10-02");
        acc.addTransaction(t1);

        Transaction[] hackerHistory = acc.getHistory();

        //hacker cố tình gán phần tử đầu tiên bằng null để xóa dữ liệu
        hackerHistory[0] = null;

        acc.printHistory();
    }
}
