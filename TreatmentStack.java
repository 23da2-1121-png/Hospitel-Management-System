import java.util.Scanner;

// Stack Node
class StackNode {
    String treatmentRecord;
    StackNode next;

    public StackNode(String treatmentRecord) {
        this.treatmentRecord = treatmentRecord;
        this.next = null;
    }
}

// Stack Implementation (LIFO)
class TreatmentStack {
    StackNode top;

    // Push: Add treatment record
    public void push(String record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record added to Stack!");
    }

    // Pop: Remove latest treatment record
    public void pop() {
        if (top == null) {
            System.out.println("Treatment Stack is Empty!");
            return;
        }
        System.out.println("Removed Latest Treatment Record: " + top.treatmentRecord);
        top = top.next;
    }

    // Display Stack
    public void display() {
        if (top == null) {
            System.out.println("Treatment History (Stack) is empty.");
            return;
        }
        System.out.println("\n--- Treatment History (LIFO Order - Most Recent First) ---");
        StackNode temp = top;
        while (temp != null) {
            System.out.println("-> " + temp.treatmentRecord);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TreatmentStack stack = new TreatmentStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TASK 3: TREATMENT HISTORY (STACK) ---");
            System.out.println("1. Add Treatment Record (Push)");
            System.out.println("2. Remove Recent Treatment Record (Pop)");
            System.out.println("3. Display Treatment History");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Treatment Details (e.g., Patient ilfa - Surgery Given): ");
                    String record = sc.nextLine();
                    stack.push(record);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
