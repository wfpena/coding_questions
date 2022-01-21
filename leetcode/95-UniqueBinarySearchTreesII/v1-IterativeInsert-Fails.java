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
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new TreeNode(i));
        }
        for (int i = 2; i <= n; i++) {
            List<TreeNode> tmp = new ArrayList<>();
            // for (int j = 0; j < list.size(); j++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("***************** i: " + i + " j: " + j);
                for (TreeNode nd : list) {
                    TreeNode head = new TreeNode();
                    TreeNode root = new TreeNode(nd.val);
                    head.right = root;
                    System.out.println("before going in: ");
                    printTree(nd);
                    System.out.println("before tmp.size(): " + tmp.size());
                    addValueV2(tmp, head.right, nd, j, head);
                    System.out.println("After");
                    printTree(head.right);
                    System.out.println("after tmp.size(): " + tmp.size());
                }
            }
            System.out.println("printing for i: " + i);
            for (TreeNode nd1 : tmp) {
                printTree(nd1);
            }
            list = new ArrayList<TreeNode>();
            list.addAll(tmp);
        }
        // return map.get(n);
        return list;
    }
    
    private void addValueV2(List<TreeNode> list, TreeNode head, TreeNode node, int val, TreeNode h) {
        if (node.val == val) {
            return;
        }
        if (node.val > val) {
            if (node.left == null) {
                TreeNode newNode = new TreeNode(val);
                head.left = newNode;
                head.right = node.right;
                list.add(h.right);
            } else {
                head.left = new TreeNode(node.left.val);
                head.right = node.right;
                addValueV2(list, head.left, node.left, val, h);
            }
        } else {
            if (node.right == null) {
                TreeNode newNode = new TreeNode(val);
                head.right = newNode;
                head.left = node.left;
                list.add(h.right);
            } else {
                head.right = new TreeNode(node.right.val);
                head.left = node.left;
                addValueV2(list, head.right, node.right, val, h);
            }
        }
    }
    
    private void addValue(List<TreeNode> list, TreeNode head, TreeNode node, int val) {
        if (node.val == val) {
            return;
        }
        if (node.val > val) {
            if (node.left == null) {
                TreeNode newNode = new TreeNode(val);
                node.left = newNode;
                list.add(head);
            } else {
                addValue(list, head, node.left, val);
            }
        } else {
            if (node.right == null) {
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
                list.add(head);
            } else {
                addValue(list, head, node.right, val);
            }
        }
    }
    
    private List<TreeNode> combineTrees(List<TreeNode> left, List<TreeNode> right, int val) {
        List<TreeNode> res = new ArrayList<>();
        // TreeNode root = new TreeNode(val);
        
        if (left.size() < 1) {
            for (TreeNode r : right) {
                if (r.val == val) continue;
                TreeNode root =  new TreeNode(val);
                root.right = r;
                res.add(root);
            }
        } else if (right.size() < 1) {
            for (TreeNode l : left) {
                TreeNode root =  new TreeNode(val);
                root.left = l;
                System.out.println("left size: " + left.size());
                res.add(root);
            }
        } else {
            for (TreeNode l : left) {
                TreeNode root =  new TreeNode(val);
                root.left = l;
                for (TreeNode r : right) {
                    if (r.val == val) continue;
                    root.right = r;
                    res.add(root);
                }
                // printTree(root);
            }
        }
        return res;
    }
    
//     private TreeNode copyTree(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         TreeNode cpy = new TreeNode();
//         TreeNode n1 = new TreeNode();
//         cpy.right = n1;
//         while (!q.isEmpty()) {
//             TreeNode node = q.poll();
//             while (!q.isEmpty() && node == null) {
//                 System.out.print("null, ");
//                 node = q.poll();
//             }
            
//             if (node != null) {
//                 System.out.print(node.val + ", ");
//                 if (node.right != null || node.left != null) {
//                     q.add(node.left);
//                     q.add(node.right);
//                 }
//                 // if (node.left != null) {
//                 //     q.add(node.left);
//                 // }
//                 // if (node.right != null) {
//                 //     q.add(node.right);
//                 // }
//             }
//         }
//         System.out.println("");
//     }
    
    private void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            while (!q.isEmpty() && node == null) {
                System.out.print("null, ");
                node = q.poll();
            }
            
            if (node != null) {
                System.out.print(node.val + ", ");
                if (node.right != null || node.left != null) {
                    q.add(node.left);
                    q.add(node.right);
                }
                // if (node.left != null) {
                //     q.add(node.left);
                // }
                // if (node.right != null) {
                //     q.add(node.right);
                // }
            }
        }
        System.out.println("");
    }
    
    private void helper(TreeNode root, TreeNode node, int min, int max, int count) {
        // System.out.println("count: " + count);
        // if (count == 1) response.add(root);
        for (int i = min; i <= max; i++) {
            if (node.val < i) {
                node.right = new TreeNode(i);
                helper(root, node.right, i+1, max, count-1);
                // node.right = null;
            } else if (node.val > i) {
                node.left = new TreeNode(i);
                helper(root, node.left, min, i-1, count-1);
                // node.left = null;
            }
        }
        response.add(root);
    }
}