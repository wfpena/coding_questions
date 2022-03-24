class Solution {
    public String largestNumber(int[] nums) {
        // PriorityQueue<String> q = new PriorityQueue<>((a, b) -> {
        //     int i = 0;
        //     int j = 0;
        //     while (i < b.length() || j < a.length()) {
        //         if (b.charAt(i) != a.charAt(j)) {
        //             return b.charAt(i)-a.charAt(j);
        //         }
        //         while (j < a.length() && i < b.length() && b.charAt(i) == a.charAt(j)) {
        //             i++;
        //             j++;
        //         }
        //         if (i < b.length() && j >= a.length()) {
        //             j = 0;
        //         } else if (i >= b.length() && j < a.length()) {
        //             i = 0;
        //         }
        //     }
        //     return 0;
        // });
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(str, (a, b) -> {
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
        
        String res = "";
        for (String s : str) {
            if (res.equals("0") && s.equals("0")) continue;
            res += s;
        }
        return res;
//         for(int n : nums) {
//             if (n == 0) addZeroes++;
//             else q.add(n+"");
//         }

//         int addZeroes = 0;
//         for(int n : nums) {
//             if (n == 0) addZeroes++;
//             else q.add(n+"");
//         }
//         if (addZeroes == nums.length) return "0";
//         String s = "";
//         while (!q.isEmpty()) {
//             s += q.poll();
//         }
//         for (int i = 1; i <= addZeroes; i++) s+="0";
//         return s;
    }
}