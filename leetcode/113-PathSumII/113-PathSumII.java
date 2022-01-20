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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> response = new ArrayList<>();
        if (root != null) helper(root, response, new ArrayList<>(), targetSum);
        return response;
    }
    
    private void helper(TreeNode node, List<List<Integer>> response, List<Integer> tmp, int targetSum) {
        targetSum -= node.val;
        tmp.add(node.val);
        if (targetSum == 0 && node.left == null && node.right == null) {
            response.add(new ArrayList<>(tmp));
            return;
        }
        if (node.left != null && node.right != null) {
            int listSize = tmp.size();
            helper(node.left, response, tmp, targetSum);
            tmp.subList(listSize, tmp.size()).clear();
            helper(node.right, response, tmp, targetSum);
        } else if (node.left != null) {
            helper(node.left, response, tmp, targetSum);
        } else if(node.right != null) {
            helper(node.right, response, tmp, targetSum);
        }
    }
}