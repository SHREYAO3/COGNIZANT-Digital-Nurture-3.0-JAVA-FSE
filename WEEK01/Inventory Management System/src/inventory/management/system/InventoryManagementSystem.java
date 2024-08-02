
package inventory.management.system;

/**
 *
 * @author Anuradha
 */
public class InventoryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        Product product1 = new Product(1, "Product1", 10, 100.0);
        Product product2 = new Product(2, "Product2", 20, 200.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Display products
        System.out.println("Products after adding:");
        inventory.displayProducts();

        // Update a product
        Product updatedProduct1 = new Product(1, "UpdatedProduct1", 15, 150.0);
        inventory.updateProduct(updatedProduct1);

        // Display products after update
        System.out.println("Products after updating:");
        inventory.displayProducts();

        // Delete a product
        inventory.deleteProduct(2);

        // Display products after deletion
        System.out.println("Products after deleting:");
        inventory.displayProducts();
    }

    
}
