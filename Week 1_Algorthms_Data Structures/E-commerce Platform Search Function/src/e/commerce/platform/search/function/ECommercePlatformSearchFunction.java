/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e.commerce.platform.search.function;

/**
 *
 * @author Anuradha
 */
public class ECommercePlatformSearchFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Apparel"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Bag", "Accessories")
        };

        // Linear search
        Product foundProduct = SearchAlgorithms.linearSearch(products, 3);
        System.out.println("Linear Search: " + (foundProduct != null ? foundProduct : "Product not found"));

        // Binary search
        foundProduct = SearchAlgorithms.binarySearch(products, 3);
        System.out.println("Binary Search: " + (foundProduct != null ? foundProduct : "Product not found"));
    }

    
}
