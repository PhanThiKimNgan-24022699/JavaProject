public class Student {
    //Encapsulation
    private String id;
    private String name;
    private String email;
    private double gpa;

    //Các Constructor:

    //Không tham số
    public Student() {
        this.id = "N/A";
        this.name = "Chưa xác định";
        this.email = "N/A";
        this.gpa = 0.0;
    }

    //Có tham số (id, name)
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.email = "N/A";
        this.gpa = 0.0;
    }

    //Copy constructor (Tạo sinh viên mới sao chép thông tin từ 1 sinh viên khác)
    public Student(Student other) {
        if (other != null) {
            this.id = other.id;
            this.name = other.name;
            this.email = other.email;
            this.gpa = other.gpa;
        }
    }

    //Validation

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Lỗi: GPA (" + gpa + ") không hợp lệ! GPA phải từ 0.0 đến 4.0. Giữ nguyên giá trị cũ: " + this.gpa);
        }
    }

    //in thông tin sinh viên
    public void displayInfo() {
        System.out.println("Mã SV: " + id + " | Tên: " + name + " | Email: " + email + " | GPA: " + gpa);
    }

    public static void main(String[] args) {
        
        //Cách 1: Dùng constructor không tham số
        Student sv1 = new Student();
        sv1.setId("23020001");
        sv1.setName("Nguyen Van A");
        sv1.setEmail("a.nguyen@vnu.edu.vn");
        sv1.setGpa(3.2);

        //Cách 2: Dùng constructor 2 tham số (id, name)
        Student sv2 = new Student("23020002", "Tran Thi B");
        sv2.setEmail("b.tran@vnu.edu.vn");
        sv2.setGpa(3.8);

        //Cách 3: Dùng Copy constructor (sao chép thông tin từ sv2)
        Student sv3 = new Student(sv2);

        System.out.println("Thông tin 3 sinh viên vừa tạo");
        System.out.print("SV1: "); sv1.displayInfo();
        System.out.print("SV2: "); sv2.displayInfo();
        System.out.print("SV3 (Copy từ SV2): "); sv3.displayInfo();

        //Thử gán GPA < 0 và GPA > 4.0 để kiểm tra validation
        System.out.println("\n Kiểm tra logic Validation GPA ");
        System.out.println("1. Thử gán GPA = -1.5 cho SV1:");
        sv1.setGpa(-1.5);

        System.out.println("\n2. Thử gán GPA = 4.5 cho SV2:");
        sv2.setGpa(4.5);

        System.out.println("\n Thông tin sinh viên sau khi thử gán GPA sai ");
        System.out.print("SV1: "); sv1.displayInfo();
        System.out.print("SV2: "); sv2.displayInfo();
    }
}
