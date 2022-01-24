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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();;
        List<List<Integer>> response = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int count = 1;
        response.add(new ArrayList<>());
        TreeNode node = null;
        q.add(root);
        while (!q.isEmpty()) {
            node = q.poll();
            count--;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            response.get(0).add(node.val);
            if (count == 0  && !q.isEmpty()) {
                count = q.size();
                response.add(0, new ArrayList<>());
            }
        }
        return response;
    }
}