class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        int left =0;
        int len =0;

        for(int i=0 ; i<s.length(); i++){
            if(map.get(s.charAt(i))==null || map.get(s.charAt(i)) < left){
                map.put(s.charAt(i),i);
            }else{
                left = map.get(s.charAt(i))+1;
                map.put(s.charAt(i),i);
            }
            len = Math.max(len,i-left+1);
        }
        return len;
    }
}
