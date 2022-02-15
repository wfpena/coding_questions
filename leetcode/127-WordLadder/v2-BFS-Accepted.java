class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Integer> layer = new ArrayList<>();
        boolean[] used = new boolean[wordList.size()];
        layer.add(-1);
        for (int i = 0; i < wordList.size(); i++) {
            List<Integer> nextLayer = new ArrayList<>();
            for (int j : layer) {
                String initialWord = beginWord;
                if (j != -1) {
                    used[j] = true;
                    initialWord = wordList.get(j);
                }
                for (int k = 0; k < wordList.size(); k++) {
                    if (k == j || used[k]) continue;
                    if (diffByOne(initialWord, wordList.get(k))) {
                        if (wordList.get(k).equals(endWord)) return i+2;
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

    private void printMatrixCustom(int[][] matrix, String beginWord, List<String> wordList) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String toPrint = matrix[i][j] == Integer.MAX_VALUE ? "inf" : matrix[i][j] + "";
                String word = j == 0 ? beginWord : wordList.get(j-1);
                System.out.print(toPrint + " " + word + ", ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String toPrint = matrix[i][j] == Integer.MAX_VALUE ? "inf." : matrix[i][j] + "";
                System.out.print(toPrint + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}