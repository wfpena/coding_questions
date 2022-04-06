class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[26];
        int[] count = new int[26];
        // System.out.println(Arrays.toString(map));
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)-'a'] == '\0') {
                map[s.charAt(i)-'a'] = t.charAt(i);
            } else if (map[s.charAt(i)-'a'] != t.charAt(i)) {
                return false;
            }
            
        }
        return true;
    }
}