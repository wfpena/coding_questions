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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        int sumLeft = helper(node.left);
        int sumRight = helper(node.right);
        if (sumLeft < 0) sumLeft = 0;
        if (sumRight < 0) sumRight = 0;
        max = Math.max(max, sumLeft + sumRight + node.val);
        return node.val + Math.max(sumLeft, sumRight);
    }
}