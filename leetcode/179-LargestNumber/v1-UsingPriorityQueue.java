class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> q = new PriorityQueue<>((a, b) -> {
            int i = 0;
            int j = 0;
            while (i < b.length() || j < a.length()) {
                if (b.charAt(i) != a.charAt(j)) {
                    return b.charAt(i)-a.charAt(j);
                }
                while (j < a.length() && i < b.length() && b.charAt(i) == a.charAt(j)) {
                    i++;
                    j++;
                }
                if (i < b.length() && j >= a.length()) {
                    j = 0;
                } else if (i >= b.length() && j < a.length()) {
                    i = 0;
                }
            }
            return 0;
        });
        int addZeroes = 0;
        for(int n : nums) {
            if (n == 0) addZeroes++;
            else q.add(n+"");
        }
        if (addZeroes == nums.length) return "0";
        String s = "";
        while (!q.isEmpty()) {
            s += q.poll();
        }
        for (int i = 1; i <= addZeroes; i++) s+="0";
        return s;
    }
}