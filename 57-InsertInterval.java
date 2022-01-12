class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 || intervals[0].length < 1) return new int[][] {newInterval};
        List<int[]> ans = new ArrayList<>();
        int start = 0;
        int end = intervals.length-1;
        int target = newInterval[0];
        while (start < end) {
            int mid = (start+end)/2;
            int small = intervals[mid][0];
            int big = intervals[mid][1];
            if (small <= target && target <= big) {
                start = mid;
                break;
            }
            if (target > big) start = mid + 1;
            else end = mid-1;
        }
        for (int i = 0; i < start; i++) {
            ans.add(intervals[i]);
        }
        if (target > intervals[start][1]) {
            ans.add(intervals[start]);
        }
        int smallIdx = start;
        end = intervals.length-1;
        target = newInterval[1];
        while (start < end) {
            int mid = (start+end)/2;
            int small = intervals[mid][0];
            int big = intervals[mid][1];
            if (small <= target && target <= big) {
                start = mid;
                break;
            }
            if (target > big) start = mid + 1;
            else end = mid-1;
        }
        if (target < intervals[start][0]) {
            if (ans.size() == smallIdx+1) {
                ans.add(newInterval);
            } else {
                ans.add(new int[] {Math.min(newInterval[0], intervals[smallIdx][0]), target});
            }
            for (int i = start; i < intervals.length; i++) {
                ans.add(intervals[i]);
            }
        } else {
            if (ans.size() == smallIdx+1) {
                ans.add(new int[]{newInterval[0], Math.max(target, intervals[start][1])});
            } else {
                int a = Math.min(newInterval[0], intervals[smallIdx][0]);
                int b = Math.max(target, intervals[start][1]);
                ans.add(new int[] {a,b});
            }
            for (int i = start+1; i < intervals.length; i++) {
                ans.add(intervals[i]);
            }
        }
        // for (int i = start+skip; i < intervals.length; i++) {
        //     ans.add(intervals[i]);
        // }
        return ans.toArray(new int[ans.size()][2]);
    }
}
