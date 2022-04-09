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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while (!stk.isEmpty() || node != null) {
            while (node != null) {
                if (node.right != null) stk.push(node.right);
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            if (node.right != null && !stk.isEmpty() && stk.peek() == node.right) {
                stk.pop();
                stk.push(node);
                node = node.right;
            } else {
                res.add(node.val);
                node = null;
            }
        }
        return res;
    }
}