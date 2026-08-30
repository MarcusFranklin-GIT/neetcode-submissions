class KthLargest {
    PriorityQueue<Integer> heap;
    int K;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        K=k;

        for(int num : nums){
            heap.add(num);
            if(heap.size()>k)heap.poll();
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size()>K)heap.poll();

        return heap.peek();
    }
}
