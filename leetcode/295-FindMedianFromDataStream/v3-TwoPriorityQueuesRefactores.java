class MedianFinder {
    
    Queue<Integer> left;
    Queue<Integer> right;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // if (left.isEmpty()) {
        //     left.add(num);
        //     return;
        // }
        left.add(num);
        if (left.size() > right.size()+1) {
            right.add(left.poll());
        } else if (!right.isEmpty() && right.peek() <= num) {
            left.poll();
            left.add(right.poll());
            right.add(num);
        }
        // if (!right.isEmpty() && !left.isEmpty()) {
        //     System.out.println(num + " left " + left.peek() + " right: " + right.peek());
        // }
        
    }
    
    public double findMedian() {
        int count = right.size() + left.size();
        if (count == 0) return 0;
        if (count % 2 == 0) return (right.peek()+left.peek())/2.0;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */