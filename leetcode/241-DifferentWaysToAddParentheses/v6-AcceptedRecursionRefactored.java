class Solution {    
    public List<Integer> diffWaysToCompute(String expression) {
        int carry = 0;
        List<Integer> digits = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        Map<Integer, Character> mapOp = new HashMap<>();
        int i = 0;
        while (i < expression.length()) {
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                Character c = expression.charAt(i);
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
        return helper(0, digits.size()-1, digits, mapOp);
    }
    
    private List<Integer> helper(int start, int end, List<Integer> digits, Map<Integer, Character> mapOp) {
        List<Integer> list = new ArrayList<>();
        if (start == end) {
            list.add(digits.get(start));
            return list;
        }
        for (int i = start; i < end; i++) {
            List<Integer> left = helper(start, i, digits, mapOp);
            List<Integer> right = helper(i+1, end, digits, mapOp);
            for (Integer l : left) {                
                for (Integer r : right) {
                    int num = makeOperation(mapOp.get(i), l, r);
                    list.add(num);
                }
            }
            
            
        }
        return list;
        
    }
    
    
    private int makeOperation(char op, int a, int b) {
        if (op == '+') return a+b;
        else if (op == '-') return a-b;
        return a*b;
        
    }
}