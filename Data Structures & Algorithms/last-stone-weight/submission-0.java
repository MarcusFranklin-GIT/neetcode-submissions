class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : stones){
            res.add(num);
        }

        while(res.size() > 1){
            int stone1 = res.poll();
            int stone2 = res.poll();

            if(stone1-stone2 >0)res.add(stone1-stone2);
        }

        return res.isEmpty() ? 0 : res.peek();
    }
}