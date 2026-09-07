class LRUCache {

    final int capacity;
    Node head;
    Node tail;
    HashMap<Integer,Node> LRU;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        LRU = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        
        Node curr = LRU.get(key);

        if(curr == null)return -1;

        if(head == curr)return curr.val;

        if(tail == curr){
            tail = tail.prev;
            insertFront(curr);
        }else{
            deleteBetween(curr);
            insertFront(curr);
        }


        return curr.val;

    }
    
    public void put(int key, int value) {

        if(LRU.get(key) != null){
            Node curr = LRU.get(key);
            curr.val = value;

            if(head == curr)return;

            if(tail == curr){
                tail = curr.prev;
                curr.prev.next = null;
                insertFront(curr);
            }else{
                deleteBetween(curr);
                insertFront(curr);
            }

        }else{

            Node newnode = new Node(key,value);
            LRU.put(key,newnode);

            if(head == null){
                head = newnode;
                tail = newnode;
            }else{
                insertFront(newnode);
            }

            if(LRU.size() > capacity){
                LRU.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public void insertFront(Node curr){
        curr.next = head;
        curr.prev = null;
        head.prev = curr;
        head = curr;
    }
    public void deleteBetween(Node curr){
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}

class Node{
    int val;
    int key;
    Node prev;
    Node next;
    Node(int key,int val){
        this.val = val;
        this.key = key;
    }
}






