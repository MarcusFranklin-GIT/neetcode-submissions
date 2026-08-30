class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];

        for(int node[] : prerequisites){
            indegree[node[0]]++;
        }

        Queue<Integer> Q = new LinkedList<>();

        for(int i =0 ;i < numCourses ; i++){
            if(indegree[i]==0)Q.add(i);
        }

        int result[] = new int[numCourses];
        int ind=0;

        while(!Q.isEmpty()){
            int curr = Q.poll();
            for(int []nodes : prerequisites){
                if(nodes[1] == curr){
                    indegree[nodes[0]]--;
                    if(indegree[nodes[0]] == 0)Q.add(nodes[0]);
                }
            }
            result[ind++]= curr;
        }
        return ind == numCourses ? result : new int[]{};
    }
}