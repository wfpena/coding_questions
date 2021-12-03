class Solution {
    // private Map<String, String> map = new HashMap<>();
    int maxLen = 0;
    int low = 0;

    public String longestPalindrome(String s) {
        String longest = new String("");
        for (int i = 0 ; i < s.length(); i++) {
            if (maxLen > s.length()/2 && i > (s.length())/2) {
                return s.substring(low, low + maxLen);
            }
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return s.substring(low, low + maxLen);
    }
    
    private void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }
        if (maxLen < right - left) {
            maxLen = right - left - 1;
            low = left + 1;
        }
    }
}