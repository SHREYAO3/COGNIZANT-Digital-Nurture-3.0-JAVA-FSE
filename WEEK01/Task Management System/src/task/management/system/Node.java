/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task.management.system;

/**
 *
 * @author Anuradha
 */
public class Node {
     Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

}
