class Solution {
    public String removeDuplicateLetters(String s) {
        int[] dp = new int[26];
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            dp[c[i] - 97]++;
            if (dp[c[i] - 97] == 1) {
                sb.append(c[i]);
            }
            i++;
        }
        return sb.toString();
    }
}