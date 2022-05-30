class Solution {
    
    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public String toString() {
            // System.out.println("start: " + start + " end: " + end);
            return "start: " + start + " end: " + end;
        }
    }
    
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> mapped = new ArrayList<>();
        for (int[] i : intervals) {
            mapped.add(new Interval(i[0], i[1]));
        }
        Collections.sort(mapped, new customComparator());
        int prevEnd = Integer.MIN_VALUE;
        int count = 0;
        for (Interval i : mapped) {
            // System.out.println(i.toString());
            if (i.start < prevEnd) {
                count++;
                // prevEnd = i.end;
            } else {
                prevEnd = i.end;
            }
        }
        return count;
    }
    
    class customComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end-b.end;
        }
    }
}