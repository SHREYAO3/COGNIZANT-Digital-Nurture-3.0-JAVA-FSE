// ObserverPatternTest.java
public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Simulate stock price changes
        stockMarket.setStockPrice(100.00);
        stockMarket.setStockPrice(105.50);

        // Deregister an observer and simulate another stock price change
        stockMarket.deregisterObserver(webApp);
        stockMarket.setStockPrice(98.75);
    }
}
