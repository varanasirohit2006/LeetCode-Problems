package Trees;


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class InsertNode {
    public static Node insert(Node top,int data){
        if(top==null){
            return new Node(data);
        }
        if(data < top.data){
            top.left = insert(top.left, data);
        }
        if (data>top.data) {
            top.right =  insert(top.right, data);
        }
        return top;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node root = node4;
        node4.left = node2;
        node2.left = node1;
        node2.right = node3;
        node4.right = node6;
        node6.left = node5;
        node6.right = node7;
        

    }
}
