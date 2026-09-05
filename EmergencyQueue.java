import java.util.Scanner;

// Patient Class
class Patient {
    int id;
    String name;
    String condition;

    public Patient(int id, String name, String condition) {
        this.id = id;
        this.name = name;
        this.condition = condition;
    }
}

// Queue Node
class QueueNode {
    Patient patient;
    QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}

// Queue Implementation (FIFO)
class EmergencyQueue {
    QueueNode front, rear;

    // Enqueue: Add patient to queue
    public void enqueue(int id, String name, String condition) {
        Patient newPatient = new Patient(id, name, condition);
        QueueNode newNode = new QueueNode(newPatient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + name + " added to Emergency Queue!");
    }

    // Dequeue: Process/Treat patient
    public void dequeue() {
        if (front == null) {
            System.out.println("Emergency Queue is Empty!");
            return;
        }
        System.out.println("Processing/Treating Patient: " + front.patient.name + " (ID: " + front.patient.id + ")");
        front = front.next;
        if (front == null) rear = null;
    }

    // Display Queue
    public void display() {
        if (front == null) {
            System.out.println("Emergency Queue is empty.");
            return;
        }
        System.out.println("\n--- Current Emergency Queue (FIFO Order) ---");
        QueueNode temp = front;
        while (temp != null) {
            System.out.println("ID: " + temp.patient.id + " | Name: " + temp.patient.name + " | Condition: " + temp.patient.condition);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmergencyQueue queue = new EmergencyQueue();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TASK 2: EMERGENCY QUEUE (QUEUE) ---");
            System.out.println("1. Add Patient to Emergency Queue (Enqueue)");
            System.out.println("2. Process Patient (Dequeue)");
            System.out.println("3. Display Emergency Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Condition: "); String cond = sc.nextLine();
                    queue.enqueue(id, name, cond);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
