package leet.hard;

import java.util.LinkedHashMap;

public class Leet146LRUCache {
	
	public static void main(String[] args) {
		Leet146LRUCache lru = new Leet146LRUCache(2);
		lru.put(1, 1);
		lru.put(2, 2);
		System.out.println("size:" + lru.map.size());
		System.out.println(lru.get(1));
		lru.put(3, 3);
		System.out.println("size:" + lru.map.size());
		System.out.println(lru.get(2));
		lru.put(4, 4);
		System.out.println("size:" + lru.map.size());
		System.out.println(lru.get(1));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
	}
	
	private LinkedHashMap<Integer, Integer> map;
	private int capacity;
	
	public Leet146LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.5f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        return value == null ? -1 : value;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        if(map.size() > this.capacity) {
        	map.remove(this.map.keySet().iterator().next());
        }
    }
}
