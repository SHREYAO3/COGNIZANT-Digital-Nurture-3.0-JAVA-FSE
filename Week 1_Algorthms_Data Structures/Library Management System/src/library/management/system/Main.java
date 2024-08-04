/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

/**
 *
 * @author Anuradha
 */
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);

        // Add books
        library.addBook(new Book(1, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(2, "Clean Code", "Robert C. Martin"));
        library.addBook(new Book(3, "Java Concurrency in Practice", "Brian Goetz"));

        // Linear search for a book
        System.out.println("Linear Search for 'Clean Code':");
        Book foundBookLinear = library.linearSearchByTitle("Clean Code");
        System.out.println(foundBookLinear != null ? foundBookLinear : "Book not found");

        // Binary search for a book (assuming the list is sorted)
        System.out.println("Binary Search for 'Effective Java':");
        Book foundBookBinary = library.binarySearchByTitle("Effective Java");
        System.out.println(foundBookBinary != null ? foundBookBinary : "Book not found");
    }

}
