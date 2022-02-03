class Solution {
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
        System.out.println("Starting interval: (" + start + ", " + end + ")");
        List<Integer> list = new ArrayList<>();
        if (start > end) {
            System.out.println("Returning 0 (ZERO): (" + start + ", " + end + ").");
            list.add(0);
            return list;
        }
        if (start == end) {
            list.add(digits.get(start));
            System.out.println("st: " + start + " end: " + end);
            for (Integer n : list) {
                System.out.print(n + ", ");
            }
            System.out.println("");
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<Integer> left = helper(start, i-1, digits, mapOp);
            List<Integer> right = helper(i+1, end, digits, mapOp);
            List<Integer> tmp = new ArrayList<>();
            for (Integer l : left) {
                
                char op = '+';
                if (i > 0 && l != 0) {
                    op = mapOp.get(i-1);
                }
                int num = makeOperation(op, l, digits.get(i));
                System.out.println("[LEFT] Making operation for i = " + i + " and interval (" + start + ", " + end + ")");
                System.out.println(l + " " + op + " " + digits.get(i) + " = " + num);
                for (Integer r : right) {
                    if (i == digits.size()-1) {
                        System.out.println("******************************** i: " + i + " and interval (" + start + ", " + end + ")" + " r: " + r);
                        // list.add(num);
                        continue;
                    }
                    op = mapOp.get(i);
                    // System.out.println("[RIGHT] Making operation for i = " + i + " and interval (" + start + ", " + end + ")");
                    // System.out.println(num + " " + op + " " + r  + " = " + makeOperation(op, num, r));
                    list.add(makeOperation(op, num, r));
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