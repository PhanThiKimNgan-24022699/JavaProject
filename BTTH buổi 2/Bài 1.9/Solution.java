//Tính tổng chữ số
import java.util.Scanner;

public class Solution {
    public static int sumOfDigits(int n) {
        // Lấy giá trị tuyệt đối để xử lý cả số âm
        n = Math.abs(n);

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = sc.nextInt();

        int result = sol.sumOfDigits(n);

        System.out.println("Tổng các chữ số của " + n + " là: " + result);

        sc.close();
    }
}
