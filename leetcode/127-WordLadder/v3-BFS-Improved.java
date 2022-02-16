class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Integer> layer = new ArrayList<>();
        boolean[] used = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            if (diffByOne(beginWord, wordList.get(i))) {
                if (wordList.get(i).equals(endWord)) return 2;
                layer.add(i);
                used[i] = true;
            }
        }
        for (int i = 2; i <= wordList.size()+1; i++) {
            List<Integer> nextLayer = new ArrayList<>();
            for (int j : layer) {
                for (int k = 0; k < wordList.size(); k++) {
                    if (k == j || used[k]) continue;
                    if (diffByOne(wordList.get(j), wordList.get(k))) {
                        if (wordList.get(k).equals(endWord)) return i+1;
                        nextLayer.add(k);
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