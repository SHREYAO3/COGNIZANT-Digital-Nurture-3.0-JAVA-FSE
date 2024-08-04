// ProxyPatternTest.java
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display images
        System.out.println("First time display:");
        image1.display(); // Loads image from disk
        image2.display(); // Loads image from disk

        System.out.println("\nSecond time display:");
        image1.display(); // Uses cached image
        image2.display(); // Uses cached image
    }
}
