// Task 2: Queue Data Structure (FIFO)
class QueueNode {
    PatientNode patient;
    QueueNode next;

    public QueueNode(PatientNode patient) {
        this.patient = patient;
        this.next = null;
    }
}

public class EmergencyQueue {
    private QueueNode front, rear;

    public void enqueue(PatientNode patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + patient.name + " added to Emergency Queue!");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Emergency Queue is Empty!");
            return;
        }
        System.out.println("Processing Patient: " + front.patient.name);
        front = front.next;
        if (front == null) rear = null;
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode temp = front;
        while (temp != null) {
            System.out.println("ID: " + temp.patient.id + " | Name: " + temp.patient.name + " | Condition: " + temp.patient.condition);
            temp = temp.next;
        }
    }
}
