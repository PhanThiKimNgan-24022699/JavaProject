//Kiểm tra số nguyên tố
import java.util.Scanner;
public class Solution {
  public static boolean isPrime(int n) {
    // Các số nhỏ hơn 2 không phải số nguyên tố
        if (n < 2) return false;

        // Kiểm tra chia hết cho các số từ 2 đến sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
  }
  public static void main(String[] args) {
        // Tạo đối tượng Solution
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = sc.nextInt();

        // Gọi hàm isPrime
        if (sol.isPrime(n)) {
            System.out.println(n + " là số nguyên tố.");
        } else {
            System.out.println(n + " không phải là số nguyên tố.");
        }

        sc.close();
  }
}
