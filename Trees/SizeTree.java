package Trees;
public class SizeTree {
    public static int procedure(Node root){
        if(root==null){
            return 0;
        }
        int left  = procedure(root.left);
        int right = procedure(root.right);
        return left+right+1;
    }
}
