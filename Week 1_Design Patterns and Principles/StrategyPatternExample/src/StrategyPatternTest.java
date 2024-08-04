// StrategyPatternTest.java
public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234 5678 9012 3456", "John Doe", "123", "12/25");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(100.00);

        // Paying with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.00);
    }
}
