class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int len = s.length();

        boolean dp[] = new boolean[len];
        
        Set<String> set = new HashSet<>(wordDict);

        return check(0,s,dp,set);
    }
    public boolean check(int ind,String s , boolean[] dp , Set<String> set){
        if(ind == s.length()) return true;

        if(dp[ind] == true)return false;

        for(int start = ind ;start < s.length() ; start++){

            String str = s.substring(ind,start+1);

            if(set.contains(str)){
                if(check(start+1,s,dp,set))return true;
                dp[start] = true;
            }
        }
        return false;
    }
}
