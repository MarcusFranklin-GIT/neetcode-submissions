class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2)return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < len1 ; i++){
            char ch = s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        if (map1.equals(map2)) return true;

        int right = len1;
        int left = 0;

        while(right < len2){

            int ind = 0;

            char add = s2.charAt(right);
            map2.put( add, map2.getOrDefault(add,0) + 1);
            
            char remove = s2.charAt(left);
            map2.put(remove, map2.get(remove) - 1);

            if(map2.get(remove)==0)map2.remove(remove);

            if(map1.equals(map2))return true;


            left++;
            right++;
        }
        return false;

    }
}