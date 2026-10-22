import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    String id;
    String name;
    double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Ten: " + name + " | GPA: " + gpa;
    }
}
