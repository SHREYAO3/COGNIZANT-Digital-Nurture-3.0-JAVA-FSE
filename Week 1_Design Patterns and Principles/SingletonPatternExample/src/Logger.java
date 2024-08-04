// Logger.java
public class Logger {
    // Private static instance of the Logger class
    private static Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Initialize logger (e.g., set up file writer, etc.)
    }

    // Public method to provide access to the instance
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

    // Method to log messages
    public void log(String message) {
        // Implementation for logging messages (e.g., print to console, write to file, etc.)
        System.out.println(message);
    }
}
