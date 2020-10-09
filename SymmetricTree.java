// Time Complexity: O(N), visiting each node once
// Space Complexity: O(N), bound by the height of the tree
// Does this work on leetcode? Yes!
// I had class on Wednesday nights. Therefore, I watched the video on Thursday and Komola gave a great explaination. Thank you!

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // return both roots of the tree
        return helper(root, root);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        
        // Base Case
        if (left == null && right == null) // This means they are the same
            return true;
        if (left == null || right == null) // If one is null and one is not they are not the same
            return false;
        if(left.val != right.val) // If they do not equal the same value
            return false;
        
        // Return the mirrored trees 
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
