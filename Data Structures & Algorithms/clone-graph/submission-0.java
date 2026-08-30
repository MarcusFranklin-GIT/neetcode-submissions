/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null)return null;
        
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,new Node(node.val));

        Queue<Node> Q= new LinkedList<>();
        Q.add(node);

        while(!Q.isEmpty()){
            Node curr = Q.poll();

            for(Node near : curr.neighbors){
                if(map.get(near) == null){
                    map.put(near,new Node(near.val));
                    Q.add(near);
                }
                map.get(curr).neighbors.add(map.get(near));
            }
        }
        return map.get(node);
    }
}








