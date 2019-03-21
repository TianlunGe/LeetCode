package leet.medium;

public class Leet556NextGreaterElementIII {
	public static void main(String[] args) {
		Leet556NextGreaterElementIII t = new Leet556NextGreaterElementIII();
		System.out.println(t.nextGreaterElement(21));
	}
	
	public int nextGreaterElement(int n) {
        int len = 0, copy = n;
        while(copy != 0) {
        	copy /= 10;
        	len++;
        }
        if(len < 2) return -1;
        int[] digits = new int[len];
        for(int i=len-1; i>=0; i--) {
        	digits[i] = n % 10;
        	n /= 10;
        }
        int loc = len - 2;
        for(; loc>=0 && digits[loc] >= digits[loc+1]; loc--);
        if(loc < 0) return -1;
        for(int i=len-1; i>=loc; i--) {
        	if(digits[i] > digits[loc]) {
        		int tmp = digits[i];
        		digits[i] = digits[loc];
        		digits[loc] = tmp;
        		return this.calculateNum(digits, loc+1);
        	}
        }
        return -1;
    }
	
	private int calculateNum(int[] digits, int loc) {
		long ans = 0;
		for(int i=0; i<loc; i++) ans = ans * 10 + digits[i];
		for(int i=digits.length-1; i>=loc; i--) ans = ans * 10 +digits[i];
		if(ans > Integer.MAX_VALUE) return -1;
		return (int) ans;
	}
	
}
