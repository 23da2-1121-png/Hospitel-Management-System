// Task 1 & Task 4 Nodes (BST & Linked List Data Model)
public class PatientNode {
    public int id;
    public String name;
    public int age;
    public String contact;
    public String condition;

    // Binary Search Tree Links (Task 1)
    public PatientNode left, right;

    // Singly Linked List Link (Task 4)
    public PatientNode next;

    // Constructor
    public PatientNode(int id, String name, int age, String contact, String condition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.condition = condition;
        this.left = this.right = this.next = null;
    }
}
