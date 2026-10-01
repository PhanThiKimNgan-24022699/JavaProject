//Kiểm tra số Palindrome
import java.util.Scanner;

public class Solution {
    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }

        int original = n;
        int reversed = 0;

        // Đảo ngược số n
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        // So sánh số sau khi đảo ngược với số ban đầu
        return original == reversed;
    }

    public static void main(String[] args) {
        // Tạo đối tượng Solution
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên n cần kiểm tra: ");
        int n = sc.nextInt();

        if (sol.isPalindrome(n)) {
            System.out.println(n + " là số Palindrome.");
        } else {
            System.out.println(n + " không phải là số Palindrome.");
        }

        sc.close();
    }
}
