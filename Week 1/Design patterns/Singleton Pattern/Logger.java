public class Logger {

    private static Logger instance = new Logger();

    // Private constructor
    private Logger() {
    }

    // Method to return the same object
    public static Logger getInstance() {
        return instance;
    }

    // Log method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
