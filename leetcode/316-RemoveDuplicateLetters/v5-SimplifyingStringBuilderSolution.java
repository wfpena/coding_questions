class Solution {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            letters[c-'a']++;
        }
        
        int[] count = new int[26];
        sb.append(s.charAt(0));
        letters[s.charAt(0)-'a']--;
        count[s.charAt(0)-'a']++;
        for (int i = 1; i < s.length(); i++) {
            // char curr = s.charAt(i);
            if (letters[s.charAt(i)-'a'] <= 0) continue;
            // if (sb.length() == 0) {
            //     sb.append(curr);
            //     letters[curr-'a']--;
            //     count[curr-'a']++;
            //     continue;
            // }
            
            while (sb.length() > 0 && sb.charAt(sb.length()-1) > s.charAt(i) && letters[sb.charAt(sb.length()-1)-'a'] > 0 && count[s.charAt(i)-'a'] == 0) {
                count[sb.charAt(sb.length()-1)-'a']--;
                sb.deleteCharAt(sb.length()-1);
            }
            if (count[s.charAt(i)-'a'] == 0) {
                sb.append(s.charAt(i));
                count[s.charAt(i)-'a']++;
            }
            // System.out.println(sb.toString());
            letters[s.charAt(i)-'a']--;
        }
        return sb.toString();
    }
}
