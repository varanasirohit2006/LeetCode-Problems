package Trees;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Perfect_Binary_Tree {
    public static boolean procedure(Node root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.right==null){
            return false;
        }
        if(root.left==null && root.right!=null){
            return false;
        } 
        return procedure(root.left) && procedure(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);     
        root.left = new Node(20);          
        root.right = new Node(30);         
        root.left.left = new Node(40);   
        root.left.right = new Node(50);  
        root.right.left = new Node(60);   
        root.right.left.right = new Node(70);  
        System.out.println(procedure(root));
    }
}
