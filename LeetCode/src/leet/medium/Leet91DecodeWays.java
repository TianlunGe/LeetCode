package leet.medium;

public class Leet91DecodeWays {
	
	public static void main(String[] args) {
		System.out.println(new Leet91DecodeWays().numDecodings("30"));
	}
	
	//每个位置最大的数量为去除本位置之后的字符串的数和去除两位之后的字符串（如果两位小于26）的数之和。
	//如12345最大解法为2345和345解法的和；但如果开头两位数超过26如54321，5对应的最大数与4321一样。
	public int numDecodings(String s) {
		if(s.length() < 1){
			return 0;
		}
		if(s.length() < 2){
			if(s.charAt(0) != '0'){
				return 1;
			}
			else{
				return 0;
			}
		}
        char[] ds = s.toCharArray();
        int len = ds.length;
        /*int[] res = new int[len];
        if(ds[len-1] != '0'){
        	res[len-1] = 1;
        }
        if(ds[len-2] != '0'){
	        if(this.two(ds[len-2], ds[len-1])){
	        	res[len-2] = 1 + res[len-1];
	        }
	        else{
	        	res[len-2] = res[len-1];
	        }
        }
		for(int i=len-3; i>=0; i--){
			if(ds[i] - '0' == 0){
				continue;
			}
			if(this.two(ds[i], ds[i+1])){
				res[i] = res[i+1] + res[i+2];
			}
			else{
				res[i] = res[i+1];
			}
		}*/
        int[] res = new int[len+1];
        if(ds[len-1] != '0'){
        	res[len-1] = 1;
        }
        if(ds[len-2] != '0' && this.two(ds[len-2], ds[len-1])){
	        res[len] = 1;
        }
		for(int i=len-2; i>=0; i--){
			if(ds[i] - '0' == 0){
				continue;
			}
			if(this.two(ds[i], ds[i+1])){
				res[i] = res[i+1] + res[i+2];
			}
			else{
				res[i] = res[i+1];
			}
		}
		return res[0];
    }
	
	private boolean two(char c1, char c2){
		if((c1 - '0') == 1 || ((c1 - '0') == 2 && (c2 - '0') < 7)){
			return true;
		}
		return false;
	}
	
}
