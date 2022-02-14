class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = helper(beginWord, endWord, new ArrayList<>(), wordList, new boolean[wordList.size()], new int[wordList.size()], -1);
        return result > wordList.size() ? 0 : result;
    }
    
    private int helper(String beginWord, String endWord, List<String> tmp, List<String> wordList, boolean[] used, int[] dp, int curr) {
        if (curr != -1 && dp[curr] != 0) return dp[curr];
        // System.out.println(String.join(",", tmp));
        if (beginWord.equals(endWord)) {
            dp[curr] = 1;
            return 1;
        }
        int min = wordList.size()+10;
        for (int i = 0; i < wordList.size(); i++) {
            if (used[i]) continue;
            if (diffByOne(wordList.get(i), beginWord)) {
                tmp.add(wordList.get(i));
                used[i] = true;
                min = Math.min(1+helper(wordList.get(i), endWord, tmp, wordList, used, dp, i), min);
                used[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
        if (curr != -1) dp[curr] = min;
        return min;
    }
    
    private boolean diffByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return true;
    }

    
    private int diffLetters(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }
}