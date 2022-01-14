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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> response = new ArrayList<>();
        if (root == null) return response;
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        TreeNode node = null;
        int height = 1;
        int prevHeight = height;
        response.add(level);
        while (!q.isEmpty()) {
            node = q.poll();
            count--;
            if (height != prevHeight) {
                prevHeight = height;
                level = new ArrayList<>();
                level.add(node.val);
                response.add(level);
            } else {
                response.get(height-1).add(node.val);
            }
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            if (count == 0) {
                count = q.size();
                height++;
            }
        }
        return response;
    }
}