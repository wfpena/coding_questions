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
        TreeNode prevNode = root;
        while (node != null || !stk.isEmpty()) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            if (node.val == key) {
                // System.out.println("prevNode.val: " + prevNode.val);
                // TreeNode prevNode = stk.pop();
                if (prevNode.left == node) {
                    if (node.right != null) {
                        TreeNode rightNode = node.right;
                        while (rightNode.left != null) {
                            rightNode = rightNode.left;
                        }
                        rightNode.left = node.left;
                        prevNode.left = rightNode;
                    } else {
                        prevNode.left = node.left;
                    }
                } else {
                    // System.out.println("node.val: " + node.val);
                    if (node.left != null) {
                        TreeNode leftNode = node.left;
                        while (leftNode.right != null) {
                            leftNode = leftNode.right;
                        }
                        leftNode.right = node.right;
                        prevNode.right = leftNode;
                    } else {
                        // System.out.println("prevNode.val: " + prevNode.val);
                        prevNode.right = node.right;
                    }
                }
                return root;
            }
            // System.out.println(node.val);
            // if (node.right != null) {
            //     stk.push(node.right);
            // }
            prevNode = node;
            node = node.right;
            // node = null;
            // if (node.left != null) {
            //     stk.push(node.left);
            // }
        }
        return root;
    }
}