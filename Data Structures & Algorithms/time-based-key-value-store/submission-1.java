
class TimeMap {
    HashMap<String,List<Element>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       timeMap.computeIfAbsent(key, list -> new ArrayList<>()).add(new Element(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Element> curr = timeMap.get(key);
        if(curr == null) return "";

        int left = 0;
        int ans = -1;
        int right = curr.size() - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(curr.get(mid).timestamp <= timestamp){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans == -1 ? "" : curr.get(ans).value;
    }
}

class Element{
    String value;
    int timestamp;

    Element(String val,int time){
        this.value = val;
        this.timestamp = time;
    }
}
