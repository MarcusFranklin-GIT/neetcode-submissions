class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<int[]> fre = new ArrayList<>();

        for(int key : map.keySet()){
            fre.add(new int[]{key,map.get(key)});
        }

        Collections.sort(fre,(a, b) -> Integer.compare(b[1], a[1]));

        int res[] = new int[k];

        for(int i=0;i<k ;i++){
            res[i] = fre.get(i)[0];
        }

        return res;
    }
}
