class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.add(num);

        if(!maxheap.isEmpty() && !minheap.isEmpty() && maxheap.peek()>minheap.peek()){
            int val1 = maxheap.poll();
            int val2 = minheap.poll();

            minheap.add(val1);
            maxheap.add(val2); 
        }

        if (maxheap.size() - minheap.size() > 1) {
            minheap.offer(maxheap.poll());
        } else if (minheap.size() > maxheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        
        if(minheap.size() == maxheap.size()){
            return (double)(minheap.peek() + maxheap.peek())/2.0;
        }else{
            return (double) maxheap.peek();
        }
    }
}
