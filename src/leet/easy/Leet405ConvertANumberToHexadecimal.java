package leet.easy;

public class Leet405ConvertANumberToHexadecimal {
	
	public static void main(String[] args) {
		System.out.println(Integer.toHexString(-1));
		System.out.println(new Leet405ConvertANumberToHexadecimal().toHex(-1));
	}
	
	private char[] code = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'a', 'b', 'c', 'd', 'e', 'f'};
	
	public String toHex(int num) {
        if(num == 0) return "0";
        else if(num > 0){
        	return this.toHexHelper(num);
        }
        else{
        	return this.toHexHelper(((Integer.MAX_VALUE + 1L) << 1) + num);
        }
    }
	
	private String toHexHelper(long num){
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(code[(int) (num % 16)]);
			num >>= 4;
		}
		return sb.reverse().toString();
	}
	
}
