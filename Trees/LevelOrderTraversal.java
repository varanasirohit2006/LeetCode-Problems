package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LevelOrderTraversal{
    /**
     * Performs a level order traversal on a binary tree.
     * @param root The root node of the tree.
     * @return A list of lists, where each inner list contains the nodes at a specific level.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // The final list of levels
        List<List<Integer>> result = new ArrayList<>();
        
        // Handle the edge case of an empty tree
        if (root == null) {
            return result;
        }

        // A queue to hold nodes for processing in FIFO (First-In, First-Out) order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root to start the traversal

        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes for the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Remove the node from the front
                currentLevel.add(currentNode.val);   // Add its value to the current level's list

                // Add children of the current node to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // Add the completed level to the final result list
            result.add(currentLevel);
        }

        return result;
    }
}