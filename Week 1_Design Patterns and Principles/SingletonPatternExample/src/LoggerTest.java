// LoggerTest.java
public class LoggerTest {
    public static void main(String[] args) {
        // Get the Logger instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using both instances
        logger1.log("Message from logger1");
        logger2.log("Message from logger2");

        // Verify that both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
