class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        //adjacent list
        List<List<int[]>> adj = getAdjList(n,flights);

        int visited[] = new int[n];
        Arrays.fill(visited,Integer.MAX_VALUE);
        visited[src] = 0;

        Queue<cities> Q = new LinkedList<>();
        Q.add(new cities(0,src,0));

        while(!Q.isEmpty()){
            cities curr = Q.poll();
            
            int stops = curr.stops;
            int city = curr.city;
            int distance = curr.distance;

            if(stops > k)continue;

            for(int[] adjFlights : adj.get(city)){

                int destinationCity = adjFlights[0];
                int destinationDist = adjFlights[1];

                if(distance + destinationDist < visited[destinationCity] && stops <= k){
                    visited[destinationCity] = distance + destinationDist;
                    Q.add(new cities(stops+1,destinationCity,distance + destinationDist));
                }
            }
        }

        if(visited[dst] == Integer.MAX_VALUE)return -1;
        return visited[dst];


    }
    public List<List<int[]>> getAdjList(int n,int[][] flights){

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int []flight : flights ){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        return adj;
    }
}

class cities{
    int stops;
    int city;
    int distance;
    cities(int stops,int city,int distance){
        this.stops = stops;
        this.city = city;
        this.distance = distance;
    }
}
