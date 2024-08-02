/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task.management.system;

/**
 *
 * @author Anuradha
 */
public class TaskManagementSystem {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Design system architecture", "Pending"));
        taskList.addTask(new Task(2, "Implement user authentication", "In Progress"));
        taskList.addTask(new Task(3, "Develop REST API", "Pending"));
        taskList.addTask(new Task(4, "Write unit tests", "Completed"));

        // Traverse tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("\nSearch for task with ID 2:");
        Task foundTask = taskList.searchTask(2);
        System.out.println(foundTask != null ? foundTask : "Task not found");

        // Delete a task
        System.out.println("\nDeleting task with ID 2:");
        taskList.deleteTask(2);
        System.out.println("All Tasks after deletion:");
        taskList.traverseTasks();
    }

    
}
