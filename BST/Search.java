package BST;

public class Search {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean SearchPro(Node root, int val) {
        if(root==null){
            return false;
        }
        if (root.data == val) {
            return true;
        }
        if (root.data > val) {
            return SearchPro(root.left, val);
        } else {
            return SearchPro(root.right, val);
        }
    }

    public static void main(String[] args) {
        Node bstRoot = new Node(5);
        bstRoot.left = new Node(3);
        bstRoot.right = new Node(7);
        bstRoot.left.left = new Node(2);
        bstRoot.left.right = new Node(4);
        bstRoot.right.left = new Node(6);
        bstRoot.right.right = new Node(8);

        System.out.println("BST Tree:");
        System.out.println(SearchPro(bstRoot, 7));
        System.out.println(SearchPro(bstRoot, 21));
    }
    public boolean search(Node root,int v){
        if(root==null){
            return false;
        }
        if(root.data == v){
            return true;
        }
        boolean a = search(root.left, v);
        boolean b = search(root.right, v);

        return a || b;
    }
    
}


