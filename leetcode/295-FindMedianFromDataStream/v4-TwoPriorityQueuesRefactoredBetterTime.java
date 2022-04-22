class MedianFinder {
    
    Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> right = new PriorityQueue<>();
    
    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (right.isEmpty() || right.peek() < num) {
            right.add(num);
            if (right.size() > left.size() + 1) {
                left.add(right.poll());
            }
        } else {
            left.add(num);
            if (left.size() > right.size()) {
                right.add(left.poll());
            }
        }
        
        // if (!right.isEmpty() && !left.isEmpty()) {
        //     System.out.println(num + " left " + left.peek() + " right: " + right.peek());
        // }
        
    }
    
    public double findMedian() {
        if (right.size() == left.size()) return (right.peek()+left.peek())/2.0;
        return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */