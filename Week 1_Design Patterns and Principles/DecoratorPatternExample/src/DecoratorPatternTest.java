// DecoratorPatternTest.java
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create the base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the notifier with SMS and Slack functionalities
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification via Email, SMS, and Slack
        slackNotifier.send("This is a test notification.");
    }
}
