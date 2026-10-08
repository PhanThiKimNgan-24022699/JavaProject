class MathUtils {
    public int sum(int a, int b) {
        return a + b;
    }
}

class AdvancedMath extends MathUtils {
    //ghi đè hàm sum(int, int) của MathUtils
    @Override
    public int sum(int a, int b) {
        return a + b + 10;
    }

    public double sum(double a, double b) {
        return a + b;
    }
}

public class Main3 {
    public static void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5, 5));
    }
}
