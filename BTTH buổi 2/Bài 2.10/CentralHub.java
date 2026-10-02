public class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.println("Đã kết nối đèn: " + light.getName() + " (ID: " + light.getId() + ")");
    }
}
