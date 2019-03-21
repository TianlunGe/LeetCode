package leet.easy;

public class Leet415AddStrings {
	public String addStrings(String num1, String num2) {
        char[] ns1 = num1.toCharArray();
        char[] ns2 = num2.toCharArray();
        int[] digs = new int[Math.max(ns1.length, ns2.length)];
        int i1 = ns1.length - 1, i2 = ns2.length - 1, i3 = digs.length - 1;
        int ten = 0;
        int temp = 0;
        while(i1 >= 0 && i2 >= 0){
        	temp = ns1[i1--] + ns2[i2--] - '0' - '0' + ten;
        	ten = temp / 10;
        	digs[i3--] = temp % 10;
        }
    	while(i1 >= 0){
    		temp = ns1[i1--] -'0' + ten;
    		ten = temp / 10;
        	digs[i3--] = temp % 10;
    	}
    	while(i2 >= 0){
    		temp = ns2[i2--] -'0' + ten;
    		ten = temp / 10;
    		digs[i3--] = temp % 10;
    	}
    	StringBuilder res = new StringBuilder();
    	if(ten > 0){
    		res.append(ten);
    	}
    	for(int i : digs){
    		res.append(i);
    	}
    	return res.toString();
    }
}
