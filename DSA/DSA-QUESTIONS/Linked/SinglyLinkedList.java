package Linked;

public class SinglyLinkedList {
    // Node class (non-static nested for simplicity)
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 3. Insert at specific position (1-based)
    public void insertAtPosition(int data, int position) {
        if (position <= 1 || head == null) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4. Delete at beginning
    public void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
        }
    }

    // 5. Delete at end
    public void deleteAtEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // 6. Delete at specific position (1-based)
    public void deleteAtPosition(int position) {
        if (head == null || position <= 1) {
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // 7. Search for a value
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // 8. Size of the list
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 9. Update first occurrence of a value
    public boolean update(int oldValue, int newValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // 10. Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    // 11. Print the list
    public void printList() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //  Main method to test all operations
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(20);
        list.insertAtPosition(15, 3);
        list.printList();  // List: 5 -> 10 -> 15 -> 20 -> null

        list.deleteAtBeginning();
        list.printList();  // List: 10 -> 15 -> 20 -> null

        list.deleteAtEnd();
        list.printList();  // List: 10 -> 15 -> null

        list.insertAtEnd(25);
        list.insertAtEnd(30);
        list.deleteAtPosition(2);
        list.printList();  // List: 10 -> 25 -> 30 -> null

        System.out.println("Exists 25? " + list.search(25));  // true
        System.out.println("Size: " + list.size());          // 3

        list.update(25, 99);
        list.printList();  // List: 10 -> 99 -> 30 -> null

        list.reverse();
        list.printList();  // List: 30 -> 99 -> 10 -> null
    }
}
