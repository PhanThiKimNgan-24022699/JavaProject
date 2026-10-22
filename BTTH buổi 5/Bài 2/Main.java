import java.util.*;

class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Message {
    int id;
    String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }
}

class Ticket {
    int id;
    String content;
    String timestamp;

    public Ticket(int id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Customer> customerQueue = new LinkedList<>();

        Stack<Message> messageHistory = new Stack<>();

        System.out.println("HE THONG HO TRO KHAC HANG \n");

        Customer custA = new Customer(1, "Khach hang A");
        Customer custB = new Customer(2, "Khach hang B");

        customerQueue.offer(custA);
        System.out.println("-> " + custA.name + " da toi va vao hang doi.");

        customerQueue.offer(custB);
        System.out.println("-> " + custB.name + " da toi va vao hang doi.");

        System.out.println("\n Dang xu ly Khach hang A");
        Customer processingCust = customerQueue.poll();
        System.out.println("Nhan vien dang ho tro: " + processingCust.name);

        Message msg1 = new Message(101, "Xin chao Khach hang A!");
        Message msg2 = new Message(102, "Toi co the giup gi cho ban?");
        Message msg3 = new Message(103, "San pham nay bi loi roi.");

        messageHistory.push(msg1);
        System.out.println("Go tin nhan 1: " + msg1.content);

        messageHistory.push(msg2);
        System.out.println("Go tin nhan 2: " + msg2.content);

        messageHistory.push(msg3);
        System.out.println("Go tin nhan 3: " + msg3.content);

        System.out.println("\n[Nhan vien bam Undo...]");
        Message undoneMsg = messageHistory.pop();
        System.out.println("Da xoa tin nhan sai: \"" + undoneMsg.content + "\"");

        System.out.println("Tin nhan moi nhat hien tai: \"" + messageHistory.peek().content + "\"");


        System.out.println("\n Dang xu ly Khach hang B");
        processingCust = customerQueue.poll();
        System.out.println("Nhan vien dang ho tro: " + processingCust.name);

        if (customerQueue.isEmpty()) {
            System.out.println("\n-> Hang doi hien tai rong (Khong con khach doi).");
        }
    }
}
