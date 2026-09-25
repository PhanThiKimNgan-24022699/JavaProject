import java.util.Scanner;
public class Solution {
  //ước số chung lớn nhất
  public static int gcd (int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
  public static void main(String[] args) {
        // Tạo đối tượng Solution
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        // Gọi hàm gcd
        int result = sol.gcd(a, b);
        System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + result);

        sc.close();
    }
}
