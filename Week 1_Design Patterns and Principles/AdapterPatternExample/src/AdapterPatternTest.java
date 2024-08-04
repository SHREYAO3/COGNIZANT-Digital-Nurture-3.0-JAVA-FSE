// AdapterPatternTest.java
public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Create adapters for each payment gateway
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments using the adapters
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
        squareAdapter.processPayment(300.0);
    }
}
