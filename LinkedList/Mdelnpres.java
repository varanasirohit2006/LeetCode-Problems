package LinkedList;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Mdelnpres {
    public static Node procedure(Node head, int m, int n) {
        if (head == null) {
            return null;
        }
        Node ptr = head;
        Node curr = head;
        int flag = 0;
        while (ptr != null) {
            int k = m;
            while (k >= 0) {
                if (curr.next == null) {
                    ptr = null;
                    return head;
                }
                curr = curr.next;
                k--;
            }
            flag++;
            curr = curr.next;
            ptr.next = curr;
            ptr = ptr.next;
            if (flag == 1) {
                head = ptr;
            }
            int j = n;
            while (j >= 0) {
                if (curr.next == null) {
                    return head;
                }
                curr = curr.next;
                n--;
            }
            ptr = curr;
        }
        return head;
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
        Node ptr = procedure(h1,3,2);
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

}
