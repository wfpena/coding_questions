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
        // digits.add(0);
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
        List<Integer>[] dp2 = new List[digits.size()+1];
        dp2[0] = new ArrayList<>();
        dp2[0].add(0);
        dp2[1] = new ArrayList<>();
        // dp2[1].add(digits.get(1));
        dp2[1].addAll(digits);
        for (int len = 2; len <= digits.size(); len++) {
            dp2[len] = new ArrayList<>();
            for (int j = len; j <= digits.size(); j++) {
                char op = mapOp.get(j-2);
                System.out.println(dp2[len-1].get(j-len) + "" + op + "" + digits.get(j-1));
                dp2[len].add(makeOperation(op, dp2[len-1].get(j-len), digits.get(j-1)));
                // dp2[len].add(makeOperation(op, digits.get(j-1), dp2[len-1].get(j-len)));
            }
            System.out.println("len: " + len);
            for (Integer n : dp2[len]) {
                System.out.print(n + ", ");
            }
            System.out.println("");
        }
        
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