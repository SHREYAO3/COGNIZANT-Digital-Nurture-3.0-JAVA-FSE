/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorting.customer.orders;
import java.util.Arrays;
/**
 *
 * @author Anuradha
 */
public class SortingCustomerOrders {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 100.0),
            new Order(3, "Charlie", 150.0),
            new Order(4, "David", 200.0),
            new Order(5, "Eve", 300.0)
        };

        // Bubble Sort
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        SortingAlgorithms.bubbleSort(bubbleSortedOrders);
        System.out.println("Bubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Quick Sort
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        SortingAlgorithms.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Quick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }

    
}
