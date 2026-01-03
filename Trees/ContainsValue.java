package Trees;

public class ContainsValue {
    public static boolean contains(Node top,int data){
        if(top==null){
            return false;
        }
        if(top.data==data){
            return true;
        }
        boolean left = contains(top.left, data);
        boolean right = contains(top.right, data);
        return (left || right);
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

        System.out.println(contains(root, 7));
    }
}
