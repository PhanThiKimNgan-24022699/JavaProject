import java.util.Scanner;

abstract class Room {
    protected int nights;

    public Room(int nights) {
        this.nights = nights;
    }

    public abstract double calculateTotal();
}

class StandardRoom extends Room {
    public StandardRoom(int nights) {
        super(nights);
    }

    @Override
    public double calculateTotal() {
        if (nights <= 3) {
            return nights * 500000;
        } else {
            //3 đêm đầu giá 500,000; các đêm sau giảm 20% còn 400,000
            return (3 * 500000) + ((nights - 3) * 400000);
        }
    }
}

class VIPRoom extends Room {
    public VIPRoom(int nights) {
        super(nights);
    }

    @Override
    public double calculateTotal() {
        return nights * 2000000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vòng lặp liên tục đọc từng dòng Test Case
        while (scanner.hasNext()) {
            String type = scanner.next();
            if (!scanner.hasNextInt()) {
                break; // Thoát nếu không có số đằng sau
            }
            int nights = scanner.nextInt();

            Room room = null;
            if (type.equalsIgnoreCase("S")) {
                room = new StandardRoom(nights);
            } else if (type.equalsIgnoreCase("V")) {
                room = new VIPRoom(nights);
            }

            if (room != null) {
                System.out.println((long) room.calculateTotal());
            }
        }
        scanner.close();
    }
}
