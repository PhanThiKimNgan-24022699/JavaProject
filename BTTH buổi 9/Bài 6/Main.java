class ArrayUtils {

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public int compareTo(Student o) {
        if (this.gpa > o.gpa) return 1;
        if (this.gpa < o.gpa) return -1;
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {5, 1, 3, 2};
        ArrayUtils.sort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        String[] words = {"Java", "C++", "Python"};
        ArrayUtils.sort(words);
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        Student[] students = {
                new Student("A", 3.2),
                new Student("B", 2.5)
        };
        ArrayUtils.sort(students);
    }
}
