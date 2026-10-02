public class SmartLight {
    //Thuộc tính (Fields)
    private String id;
    private String name;
    private int brightness;

    // Constructor 1
    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    // Constructor 2
    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    // Getter cơ bản
    public String getId() { return id; }
    public String getName() { return name; }
    public int getBrightness() { return brightness; }

    //Phương thức (Methods)
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    //Nạp chồng (Overloading)
    public void setBrightness(String preset) {
        if (preset.equals("MAX")) {
            this.setBrightness(100);
        } else if (preset.equals("MIN")) {
            this.setBrightness(10);
        } else if (preset.equals("ECO")) {
            this.setBrightness(30);
        }
    }

    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }

    public static void main(String[] args) {
        CentralHub hub = new CentralHub();

        //Tạo bóng đèn l1
        SmartLight l1 = new SmartLight("L01", "Đèn phòng khách", 80);

        //Tạo bóng đèn l2
        SmartLight l2 = new SmartLight("L02", "Đèn phòng ngủ");

        l2.setBrightness("ECO");

        l1.connectToHub(hub);
        l2.connectToHub(hub);

        System.out.println("Độ sáng " + l1.getName() + ": " + l1.getBrightness()); // 80
        System.out.println("Độ sáng " + l2.getName() + ": " + l2.getBrightness()); // 30
    }
}
