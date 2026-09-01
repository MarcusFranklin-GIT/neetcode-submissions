class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (a,b)-> Double.compare(b.distance,a.distance));

        for(int p[] : points){
            pq.add(new Point(p[0],p[1]));
            if(pq.size()>k)pq.poll();
        }
        int result[][] = new int[k][2];
        
        for(int i = 0 ; i < k ; i++){
            result[i][0] = pq.peek().X;
            result[i][1] = pq.peek().Y;

            pq.poll();
        }
        return result;
    }
}
class Point{
    int X;
    int Y;
    double distance;
    Point(int x,int y){
        X = x;
        Y = y;
        distance = Math.sqrt((X*X)+(Y*Y));
    }
}
