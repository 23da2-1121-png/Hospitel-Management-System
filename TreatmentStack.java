// Task 3: Stack Data Structure (LIFO)
class StackNode {
    String record;
    StackNode next;

    public StackNode(String record) {
        this.record = record;
        this.next = null;
    }
}

public class TreatmentStack {
    private StackNode top;

    public void push(String record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record added!");
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.println("Removed: " + top.record);
        top = top.next;
    }

    public void display() {
        if (top == null) {
            System.out.println("Treatment history is empty.");
            return;
        }
        StackNode temp = top;
        while (temp != null) {
            System.out.println("-> " + temp.record);
            temp = temp.next;
        }
    }
}
