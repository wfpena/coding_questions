class MedianFinder {
    
    Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> right = new PriorityQueue<>();
    
    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (left.isEmpty() || left.peek() > num) {
            left.add(num);
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }
        } else {
            right.add(num);
            if (right.size() > left.size()) {
                left.add(right.poll());
            }
        }
    }
    
    public double findMedian() {
        if (right.size() == left.size()) return (right.peek()+left.peek())/2.0;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */