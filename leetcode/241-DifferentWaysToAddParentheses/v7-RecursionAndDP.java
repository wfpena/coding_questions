class Solution {    
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> digits = new ArrayList<>();
        Map<Integer, Character> mapOp = new HashMap<>();
        int i = 0;
        while (i < expression.length()) {
            StringBuilder sb = new StringBuilder();
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
                i++;
            }
            digits.add(Integer.parseInt(sb.toString()));
            if (i < expression.length()) {
                mapOp.put(digits.size()-1, expression.charAt(i));
            }
            i++;
        }
        int size = digits.size();
        List<Integer>[][] dp = new List[size][size];
        return helper(0, digits, size-1, mapOp, dp);
    }
    
    private List<Integer> helper(int start, List<Integer> digits, int end, Map<Integer, Character> mapOp, List<Integer>[][] dp) {
        if (dp[start][end] != null) return dp[start][end];
        dp[start][end] = new ArrayList<>();
        if (start == end) {
            dp[start][end].add(digits.get(start));
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {
            List<Integer> left = helper(start, digits, i, mapOp, dp);
            List<Integer> right = helper(i+1, digits, end, mapOp, dp);
            for (Integer l : left) {                
                for (Integer r : right) {
                    int num = makeOperation(mapOp.get(i), l, r);
                    dp[start][end].add(num);
                }
            }
        }
        return dp[start][end];
    }
    
    
    private int makeOperation(char op, int a, int b) {
        if (op == '+') return a+b;
        else if (op == '-') return a-b;
        return a*b;
        
    }
}