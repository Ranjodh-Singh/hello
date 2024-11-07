// Define the TreeNode structure

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

// Main solution class
class BinaryLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BinaryLeaves binaryLeaves = new BinaryLeaves();
        List<List<Integer>> leaves = binaryLeaves.findLeaves(root);
          // Print the leaves by level
          System.out.println("Leaves of the tree by levels:");
          for (int i = 0; i < leaves.size(); i++) {
              System.out.println("Level " + i + ": " + leaves.get(i));
          }

    }
    
    // Main function to find leaves of a binary tree
    public List<List<Integer>> findLeaves(TreeNode root) {
        // Initialize result list to store leaves by level
        List<List<Integer>> result = new ArrayList<>();
        
        // Call helper function to start the recursive leaf collection process
        collectLeaves(root, result);
        
        // Return the result list containing leaves grouped by level
        return result;
    }
    
    // Recursive helper function to collect leaves at each level
    private int collectLeaves(TreeNode node, List<List<Integer>> result) {
        // Base case: if node is null, return -1 (no height)
            if(node == null){
                return -1;
            }
        // Recursive case: calculate height based on children
        int leftHight = collectLeaves(node.left, result);
        int rightHight =  collectLeaves(node.right, result);
        int currentHeight = Math.max(leftHight, rightHight) + 1;
        if (result.size() == currentHeight) {
            result.add(new ArrayList<>());
        }
        result.get(currentHeight).add(node.val);
        // Ensure result list has enough levels for current height
        
        // Add current node's value to corresponding level in result list
        
        // Return the calculated height for the current node
        return currentHeight; // placeholder return, replace with actual height
    }
}
