import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap ten tep de ghi : ");
            String fileName = sc.nextLine();

            System.out.print("Nhap so luong so nguyen n = ");
            int n = sc.nextInt();

            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));

            for (int i = 0; i < n; i++) {
                System.out.print("Nhap so thu " + (i + 1) + ": ");
                int number = sc.nextInt();
                dos.writeInt(number); 
            }

            dos.close(); 
            System.out.println("Da ghi du lieu vao tep " + fileName + " thanh cong!");

        } catch (IOException e) {
            System.out.println("Loi khi ghi tep: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
