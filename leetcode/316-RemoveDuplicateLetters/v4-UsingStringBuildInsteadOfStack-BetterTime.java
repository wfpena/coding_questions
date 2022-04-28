class Solution {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            letters[c-'a']++;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (letters[curr-'a'] <= 0) continue;
            if (sb.length() == 0) {
                sb.append(curr);
                letters[curr-'a']--;
                count[curr-'a']++;
                continue;
            }
            
            while (sb.length() > 0 && sb.charAt(sb.length()-1) > curr && letters[sb.charAt(sb.length()-1)-'a'] > 0 && count[curr-'a'] == 0) {
                count[sb.charAt(sb.length()-1)-'a']--;
                sb.deleteCharAt(sb.length()-1);
            }
            if (count[curr-'a'] == 0) {
                sb.append(curr);
                count[curr-'a']++;
            }
            // System.out.println(sb.toString());
            letters[curr-'a']--;
        }
        return sb.toString();
    }
}
