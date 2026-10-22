import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "students.dat";
        List<Student> studentList = new ArrayList<>();

        System.out.println(" NHAP DANH SACH SINH VIEN (Nhap 'END' o phan ID de dung)");
        while (true) {
            System.out.print("Nhap ID: ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("END")) {
                break;
            }

            System.out.print("Nhap Ten: ");
            String name = sc.nextLine();

            System.out.print("Nhap GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            studentList.add(new Student(id, name, gpa));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Student s : studentList) {
                oos.writeObject(s);
            }
            System.out.println("\n-> Da ghi danh sach sinh vien vao tep " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay tep de ghi!");
        } catch (IOException e) {
            System.out.println("Loi I/O khi ghi tep: " + e.getMessage());
        }

        System.out.println("\n DANH SACH SINH VIEN DOC TU TEP");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
            }
        } catch (EOFException e) {
            System.out.println("-> Da doc het tep!");
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay tep " + fileName);
        } catch (ClassNotFoundException e) {
            System.out.println("Loi: Khong tim thay lop Student!");
        } catch (IOException e) {
            System.out.println("Loi I/O khi doc tep: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
