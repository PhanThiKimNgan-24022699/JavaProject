public class Person {
    //Thuộc tính private
    private String name;
    private Person me;

    //Hàm khởi tạo
    public Person(String name) {
        this.name = name;
    }

    //Phương thức Getter / Setter
    public void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return me;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person p = new Person("An");

        // Set tham chiếu me đến chính đối tượng mà p đang trỏ tới
        p.setMe(p);

        System.out.println("Tên đối tượng: " + p.getMe().getName());

        p = null;
    }
}
