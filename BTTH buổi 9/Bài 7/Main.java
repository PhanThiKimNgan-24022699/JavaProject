interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void send(String msg) {
        System.out.println("[EMAIL] Gửi tới " + email + ": " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String msg) {
        if (wrappedNotifier != null) {
            wrappedNotifier.send(msg);
        }
    }
}

class SMSNotifier extends NotifierDecorator {
    private String phoneNumber;

    public SMSNotifier(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("[SMS] Gửi tới số " + phoneNumber + ": " + msg);
    }
}

class FacebookNotifier extends NotifierDecorator {
    private String facebookId;

    public FacebookNotifier(Notifier notifier, String facebookId) {
        super(notifier);
        this.facebookId = facebookId;
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("[FACEBOOK] Gửi tới tài khoản " + facebookId + ": " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier("sinhvien@uet.vnu.edu.vn");

        notifier = new FacebookNotifier(notifier, "fb.com/sinhvien.uet");
        notifier = new SMSNotifier(notifier, "0987654321");

        System.out.println("Bắt đầu gửi thông báo đa kênh");
        notifier.send("Lịch thi cuối kỳ môn Lập trình hướng đối tượng đã được cập nhật!");
    }
}