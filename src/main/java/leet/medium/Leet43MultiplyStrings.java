package leet.medium;


public class Leet43MultiplyStrings {
	
	public static void main(String[] args) {
		System.out.println(new Leet43MultiplyStrings().multiply("-165", "215"));
	}
	
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}
		int n1 = 1, n2 = 1;
		if(num1.charAt(0) == '-'){
			n1 = -1;
			num1 = num1.substring(1);
		}
		if(num2.charAt(0) == '-'){
			n2 = -1;
			num2 = num2.substring(1);
		}
        char[] ds1 = num1.toCharArray();
        char[] ds2 = num2.toCharArray();
        int[] res = null;
        if(ds1.length < ds2.length){
        	res = multi(ds1, ds2);
        }
        else{
        	res = multi(ds2, ds1);
        }
        int index;
        for(index=0; index<res.length; index++){
        	if(res[index] != 0){
        		break;
        	}
        }
        StringBuilder resS = new StringBuilder();
        if(n1 * n2 < 0){
        	resS.append('-');
        }
        for(int i=index; i<res.length; i++){
        	resS.append(res[i]);
        }
        return resS.toString();
    }
	
	private int[] multi(char[] sh, char[] lo){
		int[] res = new int[sh.length * lo.length + 1];
		int resL = res.length;
		int len = sh.length;
		for(int i=0; i<sh.length; i++){
			this.helper(lo, res, sh[len-i-1] - '0', resL-i-1);
		}
		return res;
	}
	
	private void helper(char[] lo, int[] res, int d, int loc){
		int len = lo.length;
		int s = 0;
		for(int i=len-1; i>=0; i--){
			int temp = d * (lo[i] - '0') + res[loc] + s;
			res[loc--] = temp % 10;
			s = temp/10;
		}
		int temp = res[loc] + s;
		if(temp > 9){
			res[loc--] = temp%10;
			res[loc] = temp/10;
		}
		else{
			res[loc] = temp;
		}
	}
	
}
