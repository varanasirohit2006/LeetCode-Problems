package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}



public class RightView {
    public static ArrayList<Integer> Rv(Node top){
        ArrayList<Integer> list =  new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (top == null) {
            return list;
        }
        q.add(top);
        while (!q.isEmpty()) {
            int k  = q.size();
            for(int j=0;j<k;j++){
                Node node = q.poll();
                if(j==k-1){
                    list.add(node.data);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }

        }
        return list;
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
        ArrayList<Integer> list2 = Rv(root);
        for(int x:list2){
            System.out.println(x);
        }

    }


}

