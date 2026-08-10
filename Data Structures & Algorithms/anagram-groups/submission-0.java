class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            int fre[] = new int[26];
            for(char ch:str.toCharArray()){
                fre[ch-'a']++;
            }
            String key = Arrays.toString(fre);
            if(map.get(key)==null){
                List<String> list = new ArrayList<>();
                map.put(key,list);
            }

            map.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>();

        for(String key:map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }
}
