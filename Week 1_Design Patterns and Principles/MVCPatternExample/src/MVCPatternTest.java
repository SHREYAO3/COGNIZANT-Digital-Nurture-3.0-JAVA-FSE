// MVCPatternTest.java
public class MVCPatternTest {
    public static void main(String[] args) {
        // Create the model
        Student student = new Student("John Doe", "12345", "A");

        // Create the view
        StudentView studentView = new StudentView();

        // Create the controller
        StudentController studentController = new StudentController(student, studentView);

        // Update the student details
        studentController.updateView();

        // Change student details
        studentController.setStudentName("Jane Doe");
        studentController.setStudentId("67890");
        studentController.setStudentGrade("B");

        // Display updated student details
        studentController.updateView();
    }
}
