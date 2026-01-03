package BST;
public class InsertNode {
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
    public static Node insertpro(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(root.data>data){
            root.left =  insertpro(root.left, data);
        }else{
            root.right = insertpro(root.right, data);
        }
        return root;

    }
}
