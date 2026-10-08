class LRUCache {

    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            list.remove(Integer.valueOf(key));
            list.add(key);
        }
        else if(map.size() < cap){
            map.put(key, value);
            list.add(key);
        }
        else
        {
            map.remove(Integer.valueOf(list.get(0)));
            list.remove(0);

            map.put(key, value);
            list.add(key);
        }
    }
}
