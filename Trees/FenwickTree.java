import java.util.Scanner;

public class FenwickTree {
    private int[] tree;
    private int n;
    
    // Constructor: Initialize Fenwick Tree with size n
    public FenwickTree(int size) {
        this.n = size;
        this.tree = new int[n + 1]; // 1-indexed
    }
    
    // Constructor: Build from existing array
    public FenwickTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[n + 1];
        
        // Build tree by adding each element
        for (int i = 0; i < n; i++) {
            add(i, arr[i]);
        }
    }
    
    // ADD: Add value to index (0-indexed)
    public void add(int index, int value) {
        index++; // Convert to 1-indexed
        while (index <= n) {
            tree[index] += value;
            index += index & (-index); // Add LSB
        }
    }
    
    // UPDATE: Set value at index (0-indexed)
    public void update(int index, int newValue) {
        int currentValue = query(index, index);
        int diff = newValue - currentValue;
        add(index, diff);
    }
    
    // REMOVE: Remove value from index (set to 0)
    public void remove(int index) {
        update(index, 0);
    }
    
    // PREFIX SUM: Get sum from 0 to index (0-indexed)
    public int prefixSum(int index) {
        index++; // Convert to 1-indexed
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index); // Remove LSB
        }
        return sum;
    }
    
    // RANGE QUERY: Get sum from left to right (inclusive, 0-indexed)
    public int query(int left, int right) {
        if (left > right) return 0;
        if (left == 0) return prefixSum(right);
        return prefixSum(right) - prefixSum(left - 1);
    }
    
    // Get value at specific index
    public int get(int index) {
        return query(index, index);
    }
    
    // Print tree for debugging
    public void printTree() {
        System.out.print("Fenwick Tree: [");
        for (int i = 1; i <= n; i++) {
            System.out.print(tree[i]);
            if (i < n) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ===============================
    // MAIN METHOD (Interactive Demo)
    // ===============================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FenwickTree ft = null;
        
        System.out.println("=== Fenwick Tree (Binary Indexed Tree) Demo ===");
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        ft = new FenwickTree(arr);
        System.out.println("\nFenwick Tree created successfully!");
        ft.printTree();
        
        int choice;
        do {
            System.out.println("\n======= MENU =======");
            System.out.println("1. Add value at index");
            System.out.println("2. Update value at index");
            System.out.println("3. Remove value at index");
            System.out.println("4. Get prefix sum (0 to index)");
            System.out.println("5. Range sum query (l to r)");
            System.out.println("6. Get value at index");
            System.out.println("7. Print Fenwick Tree");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter index (0-based): ");
                    int addIdx = sc.nextInt();
                    System.out.print("Enter value to add: ");
                    int addVal = sc.nextInt();
                    ft.add(addIdx, addVal);
                    System.out.println("Value added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter index (0-based): ");
                    int updIdx = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newVal = sc.nextInt();
                    ft.update(updIdx, newVal);
                    System.out.println("Value updated successfully!");
                    break;
                    
                case 3:
                    System.out.print("Enter index (0-based): ");
                    int remIdx = sc.nextInt();
                    ft.remove(remIdx);
                    System.out.println("Value removed (set to 0)!");
                    break;
                    
                case 4:
                    System.out.print("Enter index (0-based): ");
                    int preIdx = sc.nextInt();
                    System.out.println("Prefix sum (0 to " + preIdx + ") = " + ft.prefixSum(preIdx));
                    break;
                    
                case 5:
                    System.out.print("Enter left index (0-based): ");
                    int l = sc.nextInt();
                    System.out.print("Enter right index (0-based): ");
                    int r = sc.nextInt();
                    System.out.println("Range sum (" + l + " to " + r + ") = " + ft.query(l, r));
                    break;
                    
                case 6:
                    System.out.print("Enter index (0-based): ");
                    int getIdx = sc.nextInt();
                    System.out.println("Value at index " + getIdx + " = " + ft.get(getIdx));
                    break;
                    
                case 7:
                    ft.printTree();
                    break;
                    
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
}