class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> {
           return a[0]-b[0]; 
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
                intervals[i][0] = Math.min(intervals[i-1][0], intervals[i][0]);
            } else {
                merged.add(intervals[i-1]);
            }
        }
        if (merged.size() == 0 || merged.get(merged.size()-1)[1] < intervals[intervals.length-1][1]) {
            merged.add(intervals[intervals.length-1]);
        }
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}