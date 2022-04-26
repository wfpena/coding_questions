class Solution {
    public String removeDuplicateLetters(String s) {
        int[] dp = new int[26];
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            dp[s.charAt(i) - 97]++;
            if (dp[s.charAt(i) - 97] == 1) {
                sb.insert(0, s.charAt(i));
            }
            i--;
        }
        
        return sb.toString();
    }
}
