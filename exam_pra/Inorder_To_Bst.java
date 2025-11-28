package exam_pra;//inorder to bst
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Inorder_To_Bst {
    public static void pro(int arr[]){
        int i  = 0;
        int j = arr.length;
        recu(arr,i,j);

    }
    public static Node recu(int arr[],int a,int b){
        if(a>b){
            return null;
        }
        int mid = (a+b)/2;
        Node root = new Node(arr[mid]);
        root.left = recu(arr, a, mid);
        root.right = recu(arr, mid, b);
        return root;
    }
    public static void main(String[] args) {
        
    }
}
