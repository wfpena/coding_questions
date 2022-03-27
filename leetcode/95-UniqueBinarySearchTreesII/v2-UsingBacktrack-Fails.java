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
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> l = new ArrayList<>();
            backtrack(i, l, new ArrayList<>(), new boolean[n+1]);
            map.put(i, l);
        }
        // map.forEach((key, value) -> {
        //     System.out.println("key: " + key);
        //     printMatrix(value);
        // });
        
        Map<Integer, List<List<Integer>>> mapRight = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> l = new ArrayList<>();
            backtrackRight(i, n, l, new ArrayList<>(), new boolean[n+1]);
            mapRight.put(i, l);
        }
        
        for (int i = 1; i <=n; i++) {
            List<TreeNode> tmp = new ArrayList<>();
            for (List<Integer> l : map.get(i)) {
            // for (int j = 1; j <= n; j++) {
                TreeNode root = new TreeNode(i);
                TreeNode head = new TreeNode();
                head.right = root;
                for (Integer val : l) {
                    addValueV3(root, val);
                }
                tmp.add(head.right);
            }
            
            // for (TreeNode nd1 : tmp) {
            //     printTree(nd1);
            // }
            
            for (TreeNode node : tmp) {
                for (List<Integer> l : mapRight.get(i)) {
                    node.right = null;
                    for (Integer val : l) {
                        // System.out.println("adding: " + val);
                        addValueV3(node, val);
                        // printTree(node);
                    }
                    list.add(new TreeNode(node.val, node.left, node.right));
                }
            }
            
        }
        
        return list;
    }
    
    private void addValueV3(TreeNode node, int val) {
        if (val > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                addValueV3(node.right, val);
            }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                addValueV3(node.left, val);
            }
        }
    }
    
    private void backtrackRight(int curr, int n, List<List<Integer>> response, List<Integer> tmp, boolean[] used) {
        if (tmp.size() == n-curr) response.add(new ArrayList<>(tmp));        
        for (int i = curr+1; i <= n; i++) {
            if (!used[i]) {
                tmp.add(i);
                used[i] = true;
                backtrackRight(curr, n, response, tmp, used);
                used[i] = false;
                tmp.remove(tmp.size()-1);   
            }
        }
    }
    
    private void backtrack(int n, List<List<Integer>> response, List<Integer> tmp, boolean[] used) {
        if (tmp.size() == n-1) response.add(new ArrayList<>(tmp));        
        for (int i = n-1; i >= 1; i--) {
            if (!used[i]) {
                tmp.add(i);
                used[i] = true;
                backtrack(n, response, tmp, used);
                used[i] = false;
                tmp.remove(tmp.size()-1);   
            }
        }
    }
    
    private void printMatrix(List<List<Integer>> l) {
        for (List<Integer> row : l) {
            System.out.println(Arrays.toString(row.toArray()));
        }
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