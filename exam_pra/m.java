package exam_pra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

class AVLTree_LinkedList {

    static class Node {
        int value;
        Node parent;
        Node leftchild;
        Node rightchild;
        int height;

        Node(int e) {
            this.value = e;
            this.parent = null;
            this.leftchild = null;
            this.rightchild = null;
            this.height = 1;
        }
    }

    private Node root;

    public AVLTree_LinkedList() {
        this.root = null;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int balancedFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.leftchild) - height(node.rightchild);
    }

    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.leftchild), height(node.rightchild));
        }
    }

    private Node rightRotate(Node y) {
        Node x = y.leftchild;
        Node T2 = x.rightchild;

        x.rightchild = y;
        y.leftchild = T2;

        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else if (y == y.parent.leftchild) {
            y.parent.leftchild = x;
        } else {
            y.parent.rightchild = x;
        }
        y.parent = x;
        if (T2 != null) {
            T2.parent = y;
        }

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.rightchild;
        Node T2 = y.leftchild;

        y.leftchild = x;
        x.rightchild = T2;

        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.leftchild) {
            x.parent.leftchild = y;
        } else {
            x.parent.rightchild = y;
        }
        x.parent = y;
        if (T2 != null) {
            T2.parent = x;
        }

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node rebalance(Node node) {
        updateHeight(node);

        int balance = balancedFactor(node);

        if (balance > 1 && balancedFactor(node.leftchild) >= 0) {
            return rightRotate(node);
        }

        if (balance < -1 && balancedFactor(node.rightchild) <= 0) {
            return leftRotate(node);
        }

        if (balance > 1 && balancedFactor(node.leftchild) < 0) {
            node.leftchild = leftRotate(node.leftchild);
            return rightRotate(node);
        }

        if (balance < -1 && balancedFactor(node.rightchild) > 0) {
            node.rightchild = rightRotate(node.rightchild);
            return leftRotate(node);
        }

        return node;
    }

    private Node insertRecursive(Node node, int e, Node parent) {
        if (node == null) {
            Node newNode = new Node(e);
            newNode.parent = parent;
            return newNode;
        }

        if (e < node.value) {
            node.leftchild = insertRecursive(node.leftchild, e, node);
        } else if (e > node.value) {
            node.rightchild = insertRecursive(node.rightchild, e, node);
        } else {
            return node;
        }

        return rebalance(node);
    }

    public void insert(int e) {
        this.root = insertRecursive(this.root, e, null);
        levelordertraversal(this.root);
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.leftchild != null) {
            current = current.leftchild;
        }
        return current;
    }

    private Node deleteRecursive(Node root, int e) {
        if (root == null) {
            return null;
        }

        if (e < root.value) {
            root.leftchild = deleteRecursive(root.leftchild, e);
        } else if (e > root.value) {
            root.rightchild = deleteRecursive(root.rightchild, e);
        } else {
            if ((root.leftchild == null) || (root.rightchild == null)) {
                Node temp = null;
                if (temp == root.leftchild) {
                    temp = root.rightchild;
                } else {
                    temp = root.leftchild;
                }

                if (temp == null) {
                    root = null;
                } else {*7
                    root = temp;
                    root.parent = (root.parent != null) ? root.parent.parent : null;
                }
            } else {
                Node temp = minValueNode(root.rightchild);
                root.value = temp.value;
                root.rightchild = deleteRecursive(root.rightchild, temp.value);
            }
        }

        if (root == null) {
            return null;
        }

        return rebalance(root);
    }

    public void delete(int e) {
        this.root = deleteRecursive(this.root, e);
        levelordertraversal(this.root);
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean isLeaf(Node node) {
        if (node == null) return false;
        return node.leftchild == null && node.rightchild == null;
    }

    public int depth(Node node) {
        if (node == null) {
            return 0;
        }
        int d = 0;
        Node current = node;
        while (current != this.root) {
            d++;
            current = current.parent;
        }
        return d;
    }

    public void inordertraversal(Node node) {
        if (node != null) {
            inordertraversal(node.leftchild);
            System.out.print(node.value + " ");
            inordertraversal(node.rightchild);
        }
    }

    public void preordertraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preordertraversal(node.leftchild);
            preordertraversal(node.rightchild);
        }
    }

    public void postordertraversal(Node node) {
        if (node != null) {
            postordertraversal(node.leftchild);
            postordertraversal(node.rightchild);
            System.out.print(node.value + " ");
        }
    }

    public void levelordertraversal(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.leftchild != null) {
                queue.add(current.leftchild);
            }
            if (current.rightchild != null) {
                queue.add(current.rightchild);
            }
        }
    }

    public void sorting(ArrayList<Integer> elements) {
        this.root = null;
        for (int e : elements) {
            this.root = insertRecursive(this.root, e, null);
        }
        inordertraversal(this.root);
    }
}

class Main {
    public static void main(String[] args) {
        AVLTree_LinkedList tree = new AVLTree_LinkedList();
        
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            int inputs = scanner.nextInt();
            scanner.nextLine();

            while (inputs > 0) {
                String commandLine = scanner.nextLine();
                String[] operation = commandLine.split("\\s+");

                if (operation[0].equals("TIn")) {
                    tree.inordertraversal(tree.getRoot());
                    System.out.println("");
                } else if (operation[0].equals("TPre")) {
                    tree.preordertraversal(tree.getRoot());
                    System.out.println("");
                } else if (operation[0].equals("TPost")) {
                    tree.postordertraversal(tree.getRoot());
                    System.out.println("");
                } else if (operation[0].equals("I")) {
                    tree.insert(Integer.parseInt(operation[1]));
                    tree.inordertraversal(tree.getRoot());
                    System.out.println("");
                } else if (operation[0].equals("D")) {
                    tree.delete(Integer.parseInt(operation[1]));
                    tree.inordertraversal(tree.getRoot());
                    System.out.println("");
                }
                inputs--;
            }
        } catch (Exception e) {
        }
    }
}