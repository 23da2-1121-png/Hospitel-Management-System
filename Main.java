import java.util.Scanner;

// Singly Linked List Node for Patient Visit History
class VisitNode {
    int visitId;
    String date;
    String doctorName;
    String diagnosis;
    String treatment;
    VisitNode next;

    public VisitNode(int visitId, String date, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.date = date;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }
}

// Singly Linked List Implementation
class VisitHistoryList {
    VisitNode head;

    // Add Visit Record to Linked List
    public void addVisit(int visitId, String date, String doctorName, String diagnosis, String treatment) {
        VisitNode newNode = new VisitNode(visitId, date, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Visit Record added successfully to Linked List!");
    }

    // Display All Visit Records in Linked List
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history records found in Linked List.");
            return;
        }
        System.out.println("\n--- Patient Visit History (Singly Linked List) ---");
        VisitNode temp = head;
        while (temp != null) {
            System.out.println("Visit ID: " + temp.visitId + " | Date: " + temp.date + " | Doctor: " + temp.doctorName + " | Diagnosis: " + temp.diagnosis + " | Treatment: " + temp.treatment);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VisitHistoryList visitList = new VisitHistoryList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TASK 4: VISIT HISTORY (SINGLY LINKED LIST) ---");
            System.out.println("1. Add Visit Record (Insert at End)");
            System.out.println("2. Display All Visit Records (Traversal)");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Visit ID: "); int vId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Date (e.g., 2026-09-05): "); String date = sc.nextLine();
                    System.out.print("Enter Doctor Name: "); String doc = sc.nextLine();
                    System.out.print("Enter Diagnosis: "); String diag = sc.nextLine();
                    System.out.print("Enter Treatment: "); String treat = sc.nextLine();
                    visitList.addVisit(vId, date, doc, diag, treat);
                    break;
                case 2:
                    visitList.displayVisits();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
