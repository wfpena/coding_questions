class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() + s2.length() + s3.length() == 0) return true;
        boolean[][] dp = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i-1]&&(s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0]&&(s2.charAt(i-1) == s3.charAt(i-1));
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j-1] && (s1.charAt(j-1) == s3.charAt(i+j-1))
                    || dp[i-1][j] && (s2.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}


// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if (s1.length() + s2.length() != s3.length()) return false;
//         if (s1.length() + s2.length() + s3.length() == 0) return true;
//         int[] freq = new int[26];
//         // for (int i = 0; i < s3.length(); i++) {
//         //     freq[s3.charAt(i)-'a']++;
//         // }
//         // for (Character c : s3.toCharArray()) {
//         //     freq[c-'a']++;
//         // }
//         // for (Character c : (s1+s2).toCharArray()) {
//         //     freq[c-'a']--;
//         //     if (freq[c-'a'] < 0) return false;
//         // }
//         // return true;
//         return helper(s1, s2, s3, 0, 0);
//     }
    
//     private boolean helper(String s1, String s2, String s3, int i, int j) {
//         System.out.println(i + " " + j + " " + (s3.length() - 1));
//         // System.out.println("012345".substring(1, 6) + "vv");
//         if (i >= s1.length()) {
//             // System.out.println("AQUI!");
//             // System.out.println(s2.substring(j, s2.length()));
//             // System.out.println(s3.substring(i+j+1, s3.length()));
//             return s2.substring(j, s2.length()).equals(s3.substring(i+j, s3.length()));
//         }
//         if (j >= s2.length()) {
//             return s1.substring(i, s1.length()).equals(s3.substring(i+j, s3.length()));
//         }
//         if (s1.charAt(i) != s3.charAt(i+j) && s2.charAt(j) != s3.charAt(i+j)) return false;
//         if (i + j == s3.length() - 1) {
//             // System.out.println("HERERE");
//             return true;
//         }

//         boolean res = false;
//         if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
//             res = helper(s1, s2, s3, i+1, j);
//         }
//         if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
//             res = res || helper(s1, s2, s3, i, j+1);
//         }
//         return res;
//     }
// }