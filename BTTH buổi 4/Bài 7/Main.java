interface Operation<T> {
    T execute(T a, T b);
}

class Student {
    String id;
    String name;
    double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

class StudentList {
    private Student[] items;
    private int size;

    public StudentList(Student[] initialItems) {
        this.items = initialItems;
        this.size = initialItems.length;
    }

    public void removeIf(java.util.function.Predicate<Student> predicate) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!predicate.test(items[i])) {
                items[newSize++] = items[i];
            }
        }
        size = newSize;
    }

    public void sort(java.util.Comparator<Student> comparator) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (comparator.compare(items[j], items[j + 1]) > 0) {
                    Student temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] studentArray = {
                new Student("S01", "NguyenVanA", 7.5),
                new Student("S02", "TranThiB", 4.5),
                new Student("S03", "LeVanC", 8.0),
                new Student("S04", "PhamVanD", 5.0)
        };

        StudentList students = new StudentList(studentArray);

        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");
        students.printAll();
        System.out.println();

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("After sorting by name:");
        students.printAll();

        //Lambda
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> b != 0 ? a / b : 0.0;
    }
}
