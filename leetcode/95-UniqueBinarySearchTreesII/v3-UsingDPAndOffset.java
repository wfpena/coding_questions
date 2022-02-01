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
    List<TreeNode> response = new ArrayList<>();
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] list = new List[n + 1];
        list[0] = new ArrayList<>();
        list[0].add(null);
        list[1] = new ArrayList<>();
        list[1].add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : list[j-1]) {
                    for (TreeNode right : list[i-j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = cloneTree(right, j);
                        list[i].add(root);
                    }
                }
            }
        }
        return list[n];
    }
    
    private TreeNode cloneTree(TreeNode node, int offset) {
        if (node == null) return null;
        TreeNode target = new TreeNode(node.val + offset);
        target.right = cloneTree(node.right, offset);
        target.left = cloneTree(node.left, offset);
        return target;
    }
}