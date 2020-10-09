// Time Complexity: O(n^2), because we are copying over the pathNodes to a new list to be added to the final list
// Space Complexity: O(n)
// Does this work on leetcode? : Yes. 

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
    List<List<Integer>> output;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        output = new ArrayList<List<Integer>>();
        helper(0, new ArrayList<Integer>(), root, sum);
        return output;
    }
    private void helper(int curr_sum, List<Integer> curr_path, TreeNode node, int target) {
        
        // Base Case
        if (node == null)
            return;
        
        // For both leaf and no-leaf nodes
        curr_path.add(node.val);
        curr_sum +=node.val;
        
        // Add the output: Only if its leaf
        if(node.left == null && node.right == null && target == curr_sum) {
            output.add(new ArrayList<>(curr_path));
        } else {
            helper(curr_sum, curr_path, node.left, target);
            helper(curr_sum, curr_path, node.right, target);
        }
        // We need to pop the node once we are done processing ALL of it's subtrees
        curr_path.remove(curr_path.size()-1);
    }
}
