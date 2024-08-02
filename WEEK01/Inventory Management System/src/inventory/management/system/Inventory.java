/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.management.system;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anuradha
 */
public class Inventory {
     private Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update an existing product
    public void updateProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

}
