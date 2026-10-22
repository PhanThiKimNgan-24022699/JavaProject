public class Main {
    public static void useString() {
        long startTime = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 100000; i++) {
            s = s + "Hello";
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay bang String: " + (endTime - startTime) + " ms");
    }

    public static void useStringBuffer() {
        long startTime = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay bang StringBuffer: " + (endTime - startTime) + " ms");
    }

    public static void contentAnalysis(String text) {
        int sentenceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                sentenceCount++;
            }
        }
        System.out.println("So luong cau trong doan van: " + sentenceCount);

        String replacedText = text.replace("Java", "Python");
        System.out.println("Doan van sau khi thay the Java -> Python:\n" + replacedText);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();

        String sampleText = "Java la mot ngon ngu lap trinh pho bien. Ban co thich Java khong? Hay hoc Java ngay hom nay!";
        System.out.println("Van ban goc:\n" + sampleText + "\n");
        contentAnalysis(sampleText);
    }
}
