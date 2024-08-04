/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Anuradha
 */
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Add employees
        ems.addEmployee(new Employee(1, "Alice", "Manager", 60000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 50000));
        ems.addEmployee(new Employee(3, "Charlie", "Analyst", 45000));

        // Traverse employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("Search for employee with ID 2:");
        Employee foundEmployee = ems.searchEmployee(2);
        System.out.println(foundEmployee != null ? foundEmployee : "Employee not found");

        // Delete an employee
        System.out.println("Deleting employee with ID 2:");
        ems.deleteEmployee(2);
        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }

}
