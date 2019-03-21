package leet.medium;

public class Leet299BullsAndCows {
	/*
	 * 思路：
	 * 从头到尾取出两个字符串中每个字符，如果相等则A++；不相等则保存起来，因为题目规定仅是数字，因此可以用两个长度为10的数组来保存。
	 * 遍历完字符串之后，再两个数组中查找相同位置的个数，取两者较小的数加到B上，然后输出A和B。
	 */
	public String getHint(String secret, String guess) {
        int[] sA = new int[10];
        int[] gA = new int[10];
        int a = 0;
        int b = 0;
		for(int i=0; i<secret.length(); i++){
        	char s = secret.charAt(i);
        	char g = guess.charAt(i);
        	if(s == g){
        		a++;
        	}
        	else{
        		sA[s - '0']++;
        		gA[g - '0']++;
        	}
        }
		for(int i=0; i<sA.length; i++){
			b += Math.min(sA[i], gA[i]);
		}
		return a + "A" + b + "B";
    }
}
