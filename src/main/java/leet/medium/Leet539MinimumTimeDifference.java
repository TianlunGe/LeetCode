package leet.medium;

import java.util.Comparator;
import java.util.List;

public class Leet539MinimumTimeDifference {
	
	public static void main(String[] args) {
		String t1 = "123";
		String t2 = "zxc";
		String tmp = t1;
		t1 = t2;
		t2 = tmp;
		System.out.println(t1);
		System.out.println(t2);
	}
	
	public int findMinDifference(List<String> timePoints) {
        timePoints.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
        });
        int ans = this.timeDiff(timePoints.get(0), timePoints.get(timePoints.size()-1));
        for(int i=0; i<timePoints.size()-1; i++) {
        	ans = Math.min(ans, this.timeDiff(timePoints.get(i), timePoints.get(i+1)));
        }
        return ans;
    }
	
	private int timeDiff(String t1, String t2) {
		if(t1.compareTo(t2) > 0) {
			String tmp = t1;
			t1 = t2;
			t2 = tmp;
		}
		int ans = 60 - Integer.valueOf(t1.substring(3)) + Integer.valueOf(t2.substring(3));
		ans += (Integer.valueOf(t2.substring(0, 2)) - Integer.valueOf(t1.substring(0, 2)) - 1) * 60;
		return ans <= 720 ? ans : 1440 - ans;
	}
	
}
