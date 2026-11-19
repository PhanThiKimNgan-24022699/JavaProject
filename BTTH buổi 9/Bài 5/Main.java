import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Logger {
    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

interface Export {
    void exportData(String data);
}

class PdfExport implements Export {
    @Override
    public void exportData(String data) {
        System.out.println("Xuất file PDF với nội dung: " + data);
    }
}

class ExcelExport implements Export {
    @Override
    public void exportData(String data) {
        System.out.println("Xuất file Excel với nội dung: " + data);
    }
}

abstract class ExportCreator {
    public void runExport(String data) {
        Export exporter = createExport();
        exporter.exportData(data);
    }

    protected abstract Export createExport();
}

class PdfExportCreator extends ExportCreator {
    @Override
    protected Export createExport() {
        return new PdfExport();
    }
}

class ExcelExportCreator extends ExportCreator {
    @Override
    protected Export createExport() {
        return new ExcelExport();
    }
}

class OldPlayer {
    void playFile(String name) {
        System.out.println("OldPlayer đang phát tệp: " + name);
    }
}

interface Player {
    void play(String name);
}

class PlayerAdapter implements Player {
    private OldPlayer oldPlayer;

    public PlayerAdapter(OldPlayer oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}

class SystemConfig implements Cloneable {
    private String theme;
    private int timeout;
    private List<String> allowedRoles;

    public SystemConfig(String theme, int timeout, List<String> allowedRoles) {
        this.theme = theme;
        this.timeout = timeout;
        this.allowedRoles = new ArrayList<>(allowedRoles);
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void addRole(String role) {
        this.allowedRoles.add(role);
    }

    @Override
    public SystemConfig clone() {
        try {
            SystemConfig copy = (SystemConfig) super.clone();
            copy.allowedRoles = new ArrayList<>(this.allowedRoles);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "SystemConfig{theme='" + theme + "', timeout=" + timeout + ", roles=" + allowedRoles + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("KIỂM TRA SINGLETON (LOGGER)");
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        log1.log("Hệ thống khởi động.");
        System.out.println("log1 == log2 ? " + (log1 == log2));
        System.out.println("\nKIỂM TRA FACTORY METHOD (EXPORT)");
        ExportCreator pdfCreator = new PdfExportCreator();
        pdfCreator.runExport("Bảng điểm sinh viên UET");

        ExportCreator excelCreator = new ExcelExportCreator();
        excelCreator.runExport("Danh sách lớp INT2204");

        System.out.println("\nKIỂM TRA ADAPTER (PLAYER)");
        OldPlayer legacyPlayer = new OldPlayer();
        Player modernPlayer = new PlayerAdapter(legacyPlayer);
        modernPlayer.play("bai_giang_design_pattern.mp4");

        System.out.println("\nKIỂM TRA PROTOTYPE (CONFIG)");
        SystemConfig defaultConfig = new SystemConfig("Light", 30, Arrays.asList("USER"));
        
        SystemConfig adminConfig = defaultConfig.clone();
        adminConfig.setTheme("Dark");
        adminConfig.setTimeout(120);
        adminConfig.addRole("ADMIN");

        System.out.println("Cấu hình gốc : " + defaultConfig);
        System.out.println("Cấu hình sao : " + adminConfig);
    }
}