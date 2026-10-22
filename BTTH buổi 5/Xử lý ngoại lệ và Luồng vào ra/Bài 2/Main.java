import java.io.*;

public class Main {
    public static void main(String[] args) {
        String sourcePath = "input.txt";
        String destPath = "output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }

            System.out.println("Sao chep thanh cong! Tong so dong: " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found. hoac Cannot create destination file.");

        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Loi khi dong tep.");
            }
        }
    }
}
