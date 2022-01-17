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
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return makeTree(preorder, inorder, 0, 0, preorder.length);
    }
    
    private TreeNode makeTree(int[] preorder, int[] inorder, int idx, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd || idx >= inorder.length) return null;
        TreeNode node = new TreeNode(preorder[idx]);
        node.left = makeTree(preorder, inorder, idx+1, inorderStart, map.get(preorder[idx])-1);
        node.right = makeTree(preorder, inorder, idx+map.get(preorder[idx]) - inorderStart + 1, map.get(preorder[idx])+1, inorderEnd);
        return node;
    }
}