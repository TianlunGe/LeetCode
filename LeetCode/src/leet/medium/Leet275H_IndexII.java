package leet.medium;

public class Leet275H_IndexII {
	
	public int hIndex(int[] citations) {
		int len = citations.length;
		if(len == 0){
			return 0;
		}
		int lo = 0, hi = citations.length-1;
		while(lo <= hi){
			int mid = (lo + hi)/2;
			if(citations[mid] > len - mid){
        		hi = mid - 1;
        	}
			else if(citations[mid] < len - mid){
				lo = mid + 1;
			}
			else{
				return len - mid;
			}
		}
        return len - lo;
    }

}
