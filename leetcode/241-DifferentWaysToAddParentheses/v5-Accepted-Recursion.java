class Solution {
    private class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        List<Integer> digits = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        Map<Integer, Character> mapOp = new HashMap<>();
        // for (int i = 0; i < expression.length(); i++) {
        int i = 0;
        mapOp.put(-1, '+');
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
        mapOp.put(digits.size(), '+');
        return helper(0, digits.size()-1, digits, mapOp);
    }
    
    private List<Integer> helper(int start, int end, List<Integer> digits, Map<Integer, Character> mapOp) {
        // System.out.println("Starting interval: (" + start + ", " + end + ")");
        List<Integer> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        // if (end - start == 1) {
        //     list.add(makeOperation(mapOp.get(start), digits.get(start), digits.get(end)));
        //     return list;
        // }
        if (start == end) {
            list.add(digits.get(start));
            return list;
        }
        for (int i = start; i < end; i++) {
            List<Integer> left = helper(start, i, digits, mapOp);
            List<Integer> right = helper(i+1, end, digits, mapOp);
            // List<Integer> right = new ArrayList<>();
            // right.add(null);
            for (Integer l : left) {                
                for (Integer r : right) {
                    // int num = digits.get(i);
                    // if (i == start) {
                    //     char op = mapOp.get(i);
                    //     num = makeOperation(op, digits.get(i), r);
                    // } else if (i == end) {
                    //     char op = mapOp.get(i-1);
                    //     num = makeOperation(op, l, digits.get(i));
                    // } else {
                    //     num = makeOperation(mapOp.get(i), digits.get(i), r);
                    //     num = makeOperation(mapOp.get(i-1), l, num);
                    //     // num = makeOperation(mapOp.get(i-1), l, r);
                    // }
                    // int num = makeOperation(mapOp.get(i-1), l, r);
                    // System.out.println(l + " " + mapOp.get(i-1) + " " + digits.get(i) + " = " + num);
                    int num = makeOperation(mapOp.get(i), l, r);
                    // System.out.println(l + " " + mapOp.get(i-1) + " " + r + " = " + num);
                    list.add(num);
                }
            }
            
            
        }
        System.out.println("START: " + start + " END: " + end);
        for (Integer n : list) {
            System.out.print(n + ", ");
        }
        System.out.println("");
        return list;
        
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