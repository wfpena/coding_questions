class Trie {
    
    private class Node {
        public Node[] children = new Node[26];
        public boolean isWord = false;
        Node() {
            
        }
    }
    
    Node root = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new Node();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */