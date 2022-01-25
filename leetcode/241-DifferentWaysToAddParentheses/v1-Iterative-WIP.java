class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        List<Integer> digits = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        Map<Integer, Character> mapOp = new HashMap<>();
        // for (int i = 0; i < expression.length(); i++) {
        int i = 0;
        mapOp.put(0, '+');
        digits.add(0);
        while (i < expression.length()) {
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                Character c = expression.charAt(i);
                // System.out.println(c + "");
                carry = (carry*10) + Integer.parseInt(c+"");
                i++;
            }
            digits.add(carry);
            carry = 0;
            if (i < expression.length()) {
                operations.add(expression.charAt(i));
                mapOp.put(digits.size()-1, expression.charAt(i));
            }
            i++;
        }
        i = 0;
        // for (Integer n : digits) {
        //     System.out.print(n + "");
        //     if (i < operations.size()) {
        //         System.out.print(operations.get(i) + " ");
        //         i++;
        //     }
        // }
        mapOp.forEach((key, value) -> {
            System.out.println("key: " + key + " val: " + value);
        });

        int[][] dp = new int[digits.size()][digits.size()];
        List<Integer>[] dp2 = new List[digits.size()];
        for (int idx = 0; idx < digits.size(); idx++) {
            dp[idx][0] = digits.get(idx);
            dp2[idx] = new ArrayList<>();
            dp2[idx].add(digits.get(idx));
            for (int j = 1; j < idx; j++) {
                char op = mapOp.get(idx-1);
                dp[idx][j] = makeOperation(op, dp[idx-1][j-1], digits.get(idx));
                dp2[idx].add(makeOperation(op, dp[idx-1][j-1], digits.get(idx)));
            }
        }
        
        // for (int idx = digits.size(); idx > 0; idx--) {
        //     dp[idx][0] = digits.get(idx);
        //     for (int j = 1; j < idx; j++) {
        //         char op = mapOp.get(idx-1);
        //         dp[idx][j] = makeOperation(op, dp[idx-1][j-1], digits.get(idx));
        //     }
        // }

        printMatrix(dp);
        return result;
    }
    
    
    private int makeOperation(char op, int a, int b) {
        if (op == '+') return a+b;
        else if (op == '-') return a-b;
        return a*b;
        
    }
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}