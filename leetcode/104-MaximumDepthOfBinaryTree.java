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
    public int maxDepth(TreeNode root) {
        return checkDepth(root, 0);
    }
    
    private int checkDepth(TreeNode node, int currDepth) {
        if (node == null) return currDepth;
        return Math.max(checkDepth(node.left, currDepth+1), checkDepth(node.right, currDepth+1));
    }
}