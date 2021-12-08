class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> resp = new ArrayList<>();
        if (digits.length() == 0) return resp;
        helper(digits.toCharArray(), 0, resp, new StringBuilder());
        return resp;
    }
    
    private void helper(char[] digits, int idx, List<String> resp, StringBuilder tmp) {
        if (idx > digits.length) return;
        if (digits.length == tmp.length()) {
            resp.add(tmp.toString());
            return;
        }
        int d = digits[idx] - '0';
        int offset = d >= 7 ? (d == 9 ? 4: 3) : 2;
        int after = d > 7 ? 1 : 0;
        // System.out.println(d);
        for (int i = ((d-2)*3)+after; i <= ((d-2)*3)+offset; i++) {
            tmp.append((char)(i + 'a'));
            // tmp.append(Integer.toString(i));
            helper(digits, idx+1, resp, tmp);
            tmp.deleteCharAt(tmp.length()-1);
        }

        // if (d < 7) {
        //     for (int i = (d-2)*3; i <= ((d-2)*3)+offset; i++) {
        //         tmp.append((char)(i + 'a'));
        //         // tmp.append(Integer.toString(i));
        //         helper(digits, idx+1, resp, tmp);
        //         tmp.deleteCharAt(tmp.length()-1);
        //     }
        // } else if (d == 7) {
        //     for (int i = (d-2)*3; i <= ((d-2)*3)+3; i++) {
        //         tmp.append((char)(i + 'a'));
        //         // tmp.append(Integer.toString(i));
        //         helper(digits, idx+1, resp, tmp);
        //         tmp.deleteCharAt(tmp.length()-1);
        //     }
        // } else if (d == 8) {
        //     for (int i = ((d-2)*3)+1; i <= ((d-2)*3)+3; i++) {
        //         tmp.append((char)(i + 'a'));
        //         // tmp.append(Integer.toString(i));
        //         helper(digits, idx+1, resp, tmp);
        //         tmp.deleteCharAt(tmp.length()-1);
        //     }
        // } else {
        //     for (int i = ((d-2)*3)+1; i <= ((d-2)*3)+4; i++) {
        //         tmp.append((char)(i + 'a'));
        //         // tmp.append(Integer.toString(i));
        //         helper(digits, idx+1, resp, tmp);
        //         tmp.deleteCharAt(tmp.length()-1);
        //     }
        // }
    }
}