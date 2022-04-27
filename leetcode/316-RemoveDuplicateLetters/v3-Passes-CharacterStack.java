class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int i = 0;
        boolean[] visited = new boolean[26];
        while (i < s.length()) {
            count[s.charAt(i) - 97]++;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        
        for (Character c : s.toCharArray()) {
            count[c - 97]--;
            if (visited[c - 97]) continue;
            
            while (!stk.isEmpty() && stk.peek()>c && count[stk.peek()-97] > 0) {
                visited[stk.pop()-97] = false;
            }
            stk.push(c);
            visited[c-97]=true;
        }
        
        while(!stk.isEmpty()) {
            // sb.append(stk.pop());
            sb.insert(0, stk.pop());
        }
        
        return sb.toString();
    }
}
