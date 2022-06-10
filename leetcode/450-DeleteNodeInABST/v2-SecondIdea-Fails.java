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
        TreeNode node = root;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prevNode = null;
        // stk.push(root);
        while (node != null || !stk.isEmpty()) {
            while (node != null) {
                if (node.right != null) stk.push(node.right);
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            if (!stk.isEmpty() && stk.peek() == node.right) {
                stk.pop();
                stk.push(node);
                node = node.right;
            } else {
                // System.out.println(node.val);
                if (!stk.isEmpty()) {
                    prevNode = stk.peek();
                }
                if (node.val == key) {
                    TreeNode withoutNode = null;
                    if (node.right == null) {
                        withoutNode = node.left;
                    } else if (node.left == null) {
                        withoutNode = node.right;
                    } else {
                        TreeNode leftmostRight = node.right;
                        while (leftmostRight.left != null) {
                            leftmostRight = leftmostRight.left;
                        }
                        leftmostRight.left = node.left;
                        withoutNode = node.right;
                    }
                    if (prevNode == null || node == root) {
                        return withoutNode;
                    }
                    if (prevNode.left == node) {
                        prevNode.left = withoutNode;
                    } else if (prevNode.right == node) {
                        prevNode.right = withoutNode;
                    }
                    return root;
                }
                // if (prevNode != null) {
                //     System.out.println("prevNode: " + prevNode.val);
                // } else {
                //     System.out.println("prevNode: null");
                // }
                node = null;
            }
        }
        return root;
    }
}