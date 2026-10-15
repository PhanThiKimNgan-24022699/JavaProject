interface IWifiConnectable {
    void connectWifi();
}

abstract class Device {
    String id;
    String name;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void turnOff() {
        System.out.println(name + " turned off");
    }
}

class Light extends Device {
    public Light(String id, String name) {
        super(id, name);
    }
}

class AC extends Device implements IWifiConnectable {
    public AC(String id, String name) {
        super(id, name);
    }

    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class SmartSpeaker extends Device implements IWifiConnectable {
    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class Curtain extends Device {
    public Curtain(String id, String name) {
        super(id, name);
    }
}

public class Main {
    public static void main(String[] args) {
        Device[] devices = {
                new Light("01", "LivingRoomLight"),
                new AC("02", "BedroomAC"),
                new SmartSpeaker("03", "SmartSpeaker"),
                new Curtain("04", "WindowCurtain")
        };

        System.out.println("Turn Off All Devices:");
        for (Device d : devices) {
            d.turnOff();
        }

        System.out.println();

        System.out.println("Setup Wifi:");
        for (Device d : devices) {
            if (d instanceof IWifiConnectable) {
                ((IWifiConnectable) d).connectWifi();
            }
        }
    }
}
