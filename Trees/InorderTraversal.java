class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}


public class InorderTraversal{
    public static void inOrder(Node top){
        if(top==null){
            return ;
        }
        inOrder(top.left);
        System.out.print(top.data);
        System.out.print(" ");
        inOrder(top.right);
        
    }
    public static void postOrder(Node top){
        if(top==null){
            return ;
        }
        postOrder(top.left);
        postOrder(top.right);
        System.out.print(top.data);
        System.out.print(" ");
        
    }
    public static void preOrder(Node top){
        if(top==null){
            return ;
        }
        System.out.print(top.data);
        System.out.print(" ");
        preOrder(top.left);
        preOrder(top.right);
        
    }
    public static int height(Node top){
        if(top==null){
            return 0;
        }
        int left = 1 + height(top.left);
        int right = 1 + height(top.right);
        return Math.max(left,right);
    }
    public static Node leftview(Node top){
        if(top==null){
            return;
        }
        leftview(top.left);
        System.out.println(top.data);
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        Node h6 = new Node(6);
        Node h7 = new Node(7);
        Node h8 = new Node(8);
        Node h9 = new Node(9);
        h1.right =h3;
        h1.left = h2;
        h2.left = h4;
        h2.right = h5;
        h3.left = h6;
        h3.right = h7;
        h4.left = h8;
        h4.right = h9;
        h5.left = null;
        h5.right = null;
        h6.left = null;
        h6.right = null;
        h7.left = null;
        h7.right = null;
        h8.left = null;
        h8.right = null;
        h9.left = null;
        h9.right = null;
        inOrder(h1);
        System.out.println("");
        preOrder(h1);
        System.out.println("");
        postOrder(h1);
        System.out.println("");
        System.out.println(height(h1));
    }
}