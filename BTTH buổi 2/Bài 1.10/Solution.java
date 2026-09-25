//Đảo ngược số nguyên
import java.util.Scanner;

public class Solution {
    public static int reverse(int n) {
        int reversed = 0;

        while (n != 0) {
            int digit = n % 10;

            // Kiểm tra trước khi nhân với 10 và cộng digit
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        // Tạo đối tượng Solution
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = sc.nextInt();

        // Gọi phương thức reverse và in kết quả
        int result = sol.reverse(n);
        System.out.println("Số sau khi đảo ngược: " + result);

        sc.close();
    }
}
