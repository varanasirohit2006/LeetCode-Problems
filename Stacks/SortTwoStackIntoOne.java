package Stacks;
import java.util.*;

public class SortTwoStackIntoOne {
    public static Stack<Integer> mergeRecursive(Stack<Integer> s1, Stack<Integer> s2) {
        // Base Case: If one stack is empty, the merge is simply the other stack.
        if (s1.isEmpty()) {
            return s2;
        }
        if (s2.isEmpty()) {
            return s1;
        }

        // Recursive Step:
        int top1 = s1.peek();
        int top2 = s2.peek();
        Stack<Integer> mergedStack;

        // 1. Find the larger of the two top elements.
        if (top1 > top2) {
            // Pop the larger element and hold it.
            s1.pop();
            // 2. Recursively merge the rest of the stacks.
            mergedStack = mergeRecursive(s1, s2);
            // 3. Push the held larger element back onto the merged result.
            mergedStack.push(top1);
        } else {
            // Pop the larger element and hold it.
            s2.pop();
            // 2. Recursively merge the rest of the stacks.
            mergedStack = mergeRecursive(s1, s2);
            // 3. Push the held larger element back onto the merged result.
            mergedStack.push(top2);
        }
        
        return mergedStack;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(5);
        s1.push(8); // Largest on top

        Stack<Integer> s2 = new Stack<>();
        s2.push(4);
        s2.push(6);
        s2.push(7);
        s2.push(9);
        s2.push(10); // Largest on top
        
        Stack<Integer> res = mergeRecursive(s1, s2);

        System.out.println("Merged and sorted stack (top to bottom):");
        while (!res.isEmpty()) {
            System.out.print(res.pop() + " ");
        }
        // Expected Output: 10 9 8 7 6 5 4 3 2 1 
    }
}