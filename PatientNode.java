import java.util.Scanner;

// Binary Search Tree Node for Patient Records
class PatientNode {
    int patientId;
    String name;
    int age;
    String contact;
    String condition;
    PatientNode left, right;

    public PatientNode(int patientId, String name, int age, String contact, String condition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.condition = condition;
        this.left = this.right = null;
    }
}

class PatientBST {
    PatientNode root;

    // Add Patient into BST
    public void insert(int id, String name, int age, String contact, String condition) {
        root = insertRec(root, id, name, age, contact, condition);
    }

    private PatientNode insertRec(PatientNode root, int id, String name, int age, String contact, String condition) {
        if (root == null) return new PatientNode(id, name, age, contact, condition);
        if (id < root.patientId) root.left = insertRec(root.left, id, name, age, contact, condition);
        else if (id > root.patientId) root.right = insertRec(root.right, id, name, age, contact, condition);
        return root;
    }

    // Search Patient in BST
    public PatientNode search(int id) {
        return searchRec(root, id);
    }

    private PatientNode searchRec(PatientNode root, int id) {
        if (root == null || root.patientId == id) return root;
        if (id < root.patientId) return searchRec(root.left, id);
        return searchRec(root.right, id);
    }

    // Display Patients (In-order Traversal)
    public void inorder() {
        if (root == null) {
            System.out.println("No patients found in BST.");
            return;
        }
        inorderRec(root);
    }

    private void inorderRec(PatientNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("ID: " + root.patientId + " | Name: " + root.name + " | Age: " + root.age + " | Contact: " + root.contact + " | Condition: " + root.condition);
            inorderRec(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TASK 1: PATIENT MANAGEMENT (BST) ---");
            System.out.println("1. Add Patient (BST Insert)");
            System.out.println("2. Display All Patients (BST In-order)");
            System.out.println("3. Search Patient (BST Search)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Age: "); int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Contact: "); String contact = sc.nextLine();
                    System.out.print("Enter Condition: "); String cond = sc.nextLine();
                    bst.insert(id, name, age, contact, cond);
                    System.out.println("Patient added to BST successfully!");
                    break;
                case 2:
                    System.out.println("\n--- All Patients (Sorted by ID) ---");
                    bst.inorder();
                    break;
                case 3:
                    System.out.print("Enter Patient ID to Search: ");
                    int sId = sc.nextInt();
                    PatientNode p = bst.search(sId);
                    if (p != null) System.out.println("FOUND: " + p.name + " | Age: " + p.age + " | Condition: " + p.condition);
                    else System.out.println("Patient Not Found!");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
