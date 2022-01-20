/* 
    numTrees will calculate the amount of combinations of trees it can be made with n nodes
        When you do numTrees(i-1):
            * i-1 representes the amount of nodes (n) can be "combined" on the left of the current node i.
        WHen you do numTrees(n-i):
            * n-i represents the amount of nodes it can exist on the right of the current node i
    Multiplying both you get how many different combinations you can make using different 
    combinations of left and right subtrees.

OBS: At the problem's description it says 1 <= n <= 19
    BUT in the recursion when n = 0 it means there are no nodes to place it either on the 
    left or right subtree, in this case the count of different subtrees will STILL be 1
    because that's counting the current node alone.
*/

class Solution {
    public int numTrees(int n) {
        if (n == 1 || n == 0) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i-1) * numTrees(n-i);
        }
        return sum;
    }
}