package leet.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Leet347TopKFrequentElements {
	
	//优先级队列，以个数作为比较器，个数大的排前；按k个以此取出值。
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
        	if(map.containsKey(i)){
        		map.put(i, map.get(i) + 1);
        	}
        	else{
        		map.put(i, 1);
        	}
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Entry<Integer, Integer>>(){
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
        });
        for(Entry<Integer, Integer> pair : map.entrySet()){
        	pq.offer(pair);
        }
        for(int i=k; i>0; i--){
        	res.add(pq.poll().getKey());
        }
        return res;
    }
}
