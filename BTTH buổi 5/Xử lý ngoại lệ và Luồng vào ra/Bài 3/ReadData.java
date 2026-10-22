import java.io.*
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap ten tep can doc (vd: numbers.dat): ");
            String fileName = sc.nextLine();

            DataInputStream dis = new DataInputStream(new FileInputStream(fileName));

            System.out.println("Cac so nguyen doc duoc tu tep:");

            try {
                while (true) {
                    int number = dis.readInt();
                    System.out.print(number + " ");
                }
            } catch (EOFException e) {
                System.out.println("\n-> Da doc het du lieu trong tep!");
            }

            dis.close();

        } catch (IOException e) {
            System.out.println("Loi khi doc tep: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
