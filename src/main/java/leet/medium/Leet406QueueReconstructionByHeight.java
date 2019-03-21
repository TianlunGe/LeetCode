package leet.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet406QueueReconstructionByHeight {
	
	public int[][] reconstructQueue(int[][] people) {
		int len = people.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1]) return o1[1] - o2[1];
				return o2[0] - o1[0];
			}
        });
        for(int[] a : people){
        	pq.add(a);
        }
        /*LinkedList<int[]> list = new LinkedList<>();
        while(!pq.isEmpty()){
        	int[] cur = pq.poll();
        	list.add(this.getLoc(list, cur), cur);
        }*/
        int[][] res = new int[len][];
        int size = 0;
        while(!pq.isEmpty()){
        	int[] tmp = pq.poll();
        	int idx = this.getLoc(res, tmp, size);
        	for(int i=size; i>idx; i--){
        		res[i] = res[i-1];
        	}
        	res[idx] = tmp;
        	size++;
        }
        return res;
    }
	
	private int getLoc(int[][] list, int[] cur, int size){
		int res = 0;
		int flag = cur[1];
		for(int i=0; i<size; i++){
			if(flag <= 0) return res;
			if(list[i][0] >= cur[0]){
				flag--;
			}
			res++;
		}
		return res;
	}
	
	/*private int getLoc(LinkedList<int[]> list, int[] cur){
		int res = 0;
		int flag = cur[1];
		for(int i=0; i<list.size(); i++){
			if(flag <= 0) return res;
			if(list.get(i)[0] >= cur[0]){
				flag--;
			}
			res++;
		}
		return res;
	}*/
	
}
