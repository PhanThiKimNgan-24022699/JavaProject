class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

interface ReportFormatter {
    String format(Report report);
}

class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "{\n" +
               "  \"title\": \"" + report.getTitle() + "\",\n" +
               "  \"content\": \"" + report.getContent() + "\"\n" +
               "}";
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "<report>\n" +
               "  <title>" + report.getTitle() + "</title>\n" +
               "  <content>" + report.getContent() + "</content>\n" +
               "</report>";
    }
}

class ReportService {
    private ReportFormatter formatter;

    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);
    }
}

public class Main {
    public static void main(String[] args) {
        Report report = new Report("Báo cáo thực hành buổi 9", "Áp dụng nguyên lý SOLID và Design Pattern.");

        ReportService jsonService = new ReportService(new JsonFormatter());
        System.out.println("ĐỊNH DẠNG JSON");
        System.out.println(jsonService.export(report));

        ReportService xmlService = new ReportService(new XmlFormatter());
        System.out.println("\nĐỊNH DẠNG XML");
        System.out.println(xmlService.export(report));
    }
}