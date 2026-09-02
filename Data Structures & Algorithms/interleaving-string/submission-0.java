class Solution {

    int len1;
    int len2;
    int len3;
    boolean memo[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        len1 = s1.length();
        len2 = s2.length();
        len3 = s3.length();

        if(len1 + len2 != len3) return false;

        memo= new boolean[len1][len2];

        return helper(s1,s2,s3,0,0,0);
    }
    public boolean helper(String s1,String s2,String s3,int ind1,int ind2,int ind3){
        if(ind3 == len3)return true;

        if(ind1 < len1 && ind2 < len2 && s1.charAt(ind1) == s3.charAt(ind3) && s2.charAt(ind2) == s3.charAt(ind3) && memo[ind1][ind2] !=true){
            if(helper(s1,s2,s3,ind1+1,ind2,ind3+1)) return true;

            memo[ind1][ind2]=true;
            return helper(s1,s2,s3,ind1,ind2+1,ind3+1);

        }

        if(ind1 < len1 && s1.charAt(ind1) == s3.charAt(ind3)){
            return helper(s1,s2,s3,ind1+1,ind2,ind3+1);
        }
        if(ind2 < len2 && s2.charAt(ind2) == s3.charAt(ind3)){
            return helper(s1,s2,s3,ind1,ind2+1,ind3+1);
        }

        return false;
    }
}









