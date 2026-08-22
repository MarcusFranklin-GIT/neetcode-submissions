class Solution {
    public int characterReplacement(String s, int k) {
        
        int len = s.length();
        int left=0 , right=0;
        int fre[] = new int[26];

        int maxlen = 0;
        int maxfre = 0;
      
        while(right < len){ 
            
            fre[s.charAt(right) - 'A']++;
            maxfre = Math.max(maxfre,fre[s.charAt(right) - 'A']);

            if((right - left + 1) - maxfre > k){
                fre[ s.charAt(left) - 'A']--;
                left++;
            }

            maxlen = Math.max( maxlen , ( right - left + 1));
            right++;            
        }

        return maxlen;
    }
}
