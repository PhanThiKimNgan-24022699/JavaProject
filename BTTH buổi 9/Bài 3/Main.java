interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Hiển thị nút bấm (Button) phong cách Windows.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Hiển thị ô đánh dấu (Checkbox) phong cách Windows.");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Hiển thị nút bấm (Button) phong cách Mac.");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Hiển thị ô đánh dấu (Checkbox) phong cách Mac.");
    }
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }
}

public class Main {
    private static UIFactory configureFactory(String osConfig) {
        if (osConfig.equalsIgnoreCase("win")) {
            return new WindowsFactory();
        } else if (osConfig.equalsIgnoreCase("mac")) {
            return new MacFactory();
        } else {
            throw new IllegalArgumentException("Hệ điều hành không được hỗ trợ: " + osConfig);
        }
    }

    public static void main(String[] args) {
        String config = (args.length > 0) ? args[0] : "mac";
        System.out.println(" Cấu hình hệ thống: " + config.toUpperCase() );
        UIFactory factory = configureFactory(config);
        
        Application app = new Application(factory);
        app.renderUI();
    }
}
