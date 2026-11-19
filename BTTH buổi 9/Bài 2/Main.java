interface Notification {
    void send(String msg);
}

class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[EMAIL] Đang gửi email với nội dung: " + msg);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[SMS] Đang gửi tin nhắn với nội dung: " + msg);
    }
}

abstract class NotificationApp {
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }

    protected abstract Notification createNotification();
}

class EmailApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationApp app1 = new EmailApp();
        app1.notifyUser("Chào mừng bạn đến với hệ thống UET!");

        NotificationApp app2 = new SmsApp();
        app2.notifyUser("Mã xác thực OTP của bạn là: 839201");
    }
}
