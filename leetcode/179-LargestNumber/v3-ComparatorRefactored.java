class Solution {
    public String largestNumber(int[] nums) {
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
        if (str[0].equals("0")) return "0";
        String res = "";
        for (String s : str) {
            res += s;
        }
        return res;
    }
}