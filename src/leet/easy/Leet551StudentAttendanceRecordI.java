package leet.easy;

import org.junit.Test;

public class Leet551StudentAttendanceRecordI {
	@Test
	public void test() {
		System.out.println(this.checkRecord("AL"));
	}
	
	public boolean checkRecord(String s) {
        char[] cs = s.toCharArray();
        int a = 0;
        int i=0;
        for(; i<cs.length-2; i++) {
        	if(cs[i] == 'A') a++;
        	if(cs[i] == 'L' && this.continousL(cs, i)) return false;
        	if(a > 1) return false;
        }
        for(int j=Math.max(0, i); j<cs.length; j++) {
        	if(cs[j] == 'A') a++;
        }
        return a > 1 ? false : true;
    }
	
	private boolean continousL(char[] cs, int start) {
		return cs[start+1] == 'L' && cs[start+2] == 'L';
	}
	
}
