class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> layer = new HashSet<>();
        boolean[] used = new boolean[wordList.size()];
        int len = 0;
        layer.add(beginWord);
        while (!layer.isEmpty()) {
            Set<String> nextLayer = new HashSet<>();
            len++;
            for (String j : layer) {
                for (int k = 0; k < wordList.size(); k++) {
                    if (used[k]) continue;
                    String currWord = wordList.get(k);
                    if (diffByOne(j, currWord)) {
                        if (currWord.equals(endWord)) return len+1;
                        nextLayer.add(currWord);
                        used[k] = true;
                    }
                }
            }
            layer = nextLayer;
        }
        return 0;
    }
    
    private boolean diffByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return true;
    }
}