import java.io.*;
import java.util.Scanner;

public class Main {
    public static void validateConfig(String key, String value) throws InvalidConfigException {
        if (key.equalsIgnoreCase("port")) {
            try {
                int port = Integer.parseInt(value);
                if (port < 1 || port > 65535) {
                    throw new InvalidConfigException("Port phai nam trong khoang tu 1 den 65535! (Gia tri hien tai: " + value + ")");
                }
            } catch (NumberFormatException e) {
                throw new InvalidConfigException("Port phai la mot so nguyen hop le!");
            }
        }

        if (key.equalsIgnoreCase("max_connections")) {
            try {
                int maxConn = Integer.parseInt(value);
                if (maxConn <= 0) {
                    throw new InvalidConfigException("max_connections phai lon hon 0!");
                }
            } catch (NumberFormatException e) {
                throw new InvalidConfigException("max_connections phai la mot so nguyen!");
            }
        }

        if (key.equalsIgnoreCase("timeout")) {
            try {
                int timeout = Integer.parseInt(value);
                if (timeout < 0) {
                    throw new InvalidConfigException("timeout khong duoc la so am!");
                }
            } catch (NumberFormatException e) {
                throw new InvalidConfigException("timeout phai la mot so nguyen!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten tep cau hinh (vd: config.txt): ");
        String fileName = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            System.out.println("\nBAT DAU KIEM TRA TEP CAU HINH");

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("=");
                if (parts.length != 2) {
                    System.out.println("Loi tai dong " + lineNumber + ": Dinh dang khong hop le (can dang key=value)");
                    continue;
                }

                String key = parts[0].trim();
                String value = parts[1].trim();

                try {
                    validateConfig(key, value);
                    System.out.println("Dong " + lineNumber + " [" + key + " = " + value + "] -> HOAN HAO!");
                } catch (InvalidConfigException e) {
                    System.out.println("Loi tai dong " + lineNumber + " (" + key + "): " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay tep cau hinh '" + fileName + "'!");
        } catch (IOException e) {
            System.out.println("Loi doc tep: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
