class Logger {
    private static Logger instance;
    
    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}

public class Main {
    private static void processTask() {
        Logger taskLogger = Logger.getInstance();
        taskLogger.logInfo("Processing data...");
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger instances equal: " + (logger1 == logger2));

        logger1.logInfo("Application started");
        processTask();
        logger2.logError("Something went wrong");
    }
}