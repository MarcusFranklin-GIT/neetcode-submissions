class Solution {
    public String minWindow(String s, String t) {
        
        int len = s.length();

        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();

        for(char ch : t.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        int need = map1.size();
        int have =0;

        int strlen = Integer.MAX_VALUE;
        int[] res = {-1,-1};

        int right=0;
        int left =0;

        for(right=0 ; right < len ;right++){
            char ch = s.charAt(right);
            map2.put(ch , map2.getOrDefault(ch,0)+1);

            if(map1.get(ch)!=null && map1.get(ch).equals(map2.get(ch))){
                have++;
            }

            while(have == need){
                if(strlen > (right - left +1)){
                    strlen = right - left +1;
                    res[0] = left;
                    res[1] = right;
                }
                
                char leftChar = s.charAt(left);
                map2.put(leftChar,map2.get(leftChar)-1);

                if(map1.get(leftChar) != null && map2.get(leftChar) < map1.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return strlen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}