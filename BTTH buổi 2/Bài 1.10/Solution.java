//Tìm số lớn thứ 2 trong mảng
import java.util.Scanner;

public class Solution {
    public static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max2 = num;
            }
        }

        return (max2 == Integer.MIN_VALUE) ? -1 : max2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = sol.secondLargest(arr);

        System.out.println("Số lớn thứ hai trong mảng là: " + result);

        sc.close();
    }
}
