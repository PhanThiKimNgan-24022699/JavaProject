interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
    @Override
    public void show() { //bắt buộc phải thêm từ khóa 'public'
        System.out.println("Show Data");
    }
}

public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        manager.show();
    }
}
