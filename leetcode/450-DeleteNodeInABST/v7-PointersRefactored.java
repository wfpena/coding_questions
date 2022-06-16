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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.right == null) return root.left;
            TreeNode leftmostRight = root.right;
            while (leftmostRight.left != null) {
                leftmostRight = leftmostRight.left;
            }
            leftmostRight.left = root.left;
            return root.right;
        } else {
            if (root.val > key) root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
            return root;
        }
    }
}