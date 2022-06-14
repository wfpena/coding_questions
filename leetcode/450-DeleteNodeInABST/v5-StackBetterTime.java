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
        Stack<TreeNode> stk = new Stack<>();
        TreeNode parentNode = null;
        stk.push(root);
        TreeNode node = null;
        Map<TreeNode, TreeNode> mapParent = new HashMap<>();
        mapParent.put(root, null);
        while (!stk.isEmpty()) {
            node = stk.pop();
            parentNode = mapParent.get(node);
            if (node.val == key) {
                TreeNode newNode = null;
                if (node.left == null) {
                    newNode = node.right;
                } else if (node.right == null) {
                    newNode = node.left;
                } else {
                    TreeNode leftmostRight = node.right;
                    while (leftmostRight.left != null) {
                        leftmostRight = leftmostRight.left;
                    }
                    leftmostRight.left = node.left;
                    newNode = node.right;
                }
                
                if (parentNode == null) {
                    return newNode;
                }
                if (parentNode.right == node) {
                    parentNode.right = newNode;
                } else {
                    parentNode.left = newNode;
                }
                return root;
            }
            if (node.right != null) {
                mapParent.put(node.right, node);
                stk.push(node.right);
            }
            if (node.left != null) {
                mapParent.put(node.left, node);
                stk.push(node.left);
            }
        }
        return root;
    }
}