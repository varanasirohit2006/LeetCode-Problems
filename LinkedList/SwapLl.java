package LinkedList;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class SwapLl {
    public static Node procedure(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node ptr = head;
        Node curr = ptr.next;
        ptr.next = procedure(ptr.next.next);
        curr.next = ptr;

        return curr;
    }

    public static void main(String[] args) {
        Node h1 = new Node(5);
        Node h2 = new Node(6);
        Node h3 = new Node(7);
        Node h4 = new Node(8);
        Node h5 = new Node(9);
        Node h6 = new Node(10);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = null;
        Node ptr = procedure(h1);
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }

}