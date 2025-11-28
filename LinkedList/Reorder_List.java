package LinkedList;

import java.util.Stack;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data =data;
        this.next =null;
    }
}

public class Reorder_List {
    public static Node procedure(Node root){
        Stack<Node> s = new Stack<>();
        if(root==null){
            return null;
        }
        if(root.next == null){
            return root;
        }
        Node ptr1 = findmid(root);
        ptr1 = ptr1.next;
        while(ptr1!=null){
            s.push(ptr1);
            ptr1 = ptr1.next;
        }
        ptr1 = findmid(root);
        ptr1.next = null;
        Node ptr = root;
        while (!s.isEmpty() && ptr != null) {
            Node top = s.pop();
            Node next = ptr.next;
            ptr.next = top;
            top.next = next;
            ptr = next;
        }
        return root;
    }
    public static Node findmid(Node root){
        Node fast = root;
        Node slow = root;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }return slow;
    }
    public static void traverse(Node root){
        Node ptr = root;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
    public static void main(String[] args) {
        Node h1 =  new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next = new Node(5);
        h1.next.next.next.next = null;
        Node t1 = procedure(h1);
        traverse(t1);
        
    }
}
