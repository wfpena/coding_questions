class Solution {    
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new customComparator());
        int prevEnd = Integer.MIN_VALUE;
        int count = 0;
        for (int[] i : intervals) {
            if (i[0] < prevEnd) {
                count++;
                // prevEnd = i.end;
            } else {
                prevEnd = i[1];
            }
        }
        return count;
    }
    
    class customComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1]-b[1];
        }
    }
}