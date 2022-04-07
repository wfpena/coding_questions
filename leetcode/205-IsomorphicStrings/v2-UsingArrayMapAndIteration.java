class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[127];
        boolean[] visited = new boolean[127];
        // System.out.println(Arrays.toString(map));
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == '\0' && !visited[t.charAt(i)]) {
                map[s.charAt(i)] = t.charAt(i);
                visited[t.charAt(i)] = true;
            } else if (map[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
            // System.out.println(Arrays.toString(map));
            
        }
        return true;
    }
}