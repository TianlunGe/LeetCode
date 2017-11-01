package leet.easy;

public class Leet389FindTheDifference {
	public char findTheDifference(String s, String t) {
		/*int[] sa = new int[26];
        int[] ta = sa.clone();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i=0; i<sc.length; i++){
        	sa[sc[i] - 'a']++;
        	ta[tc[i] - 'a']++;
        }
        ta[tc[sc.length] - 'a']++;
        for(int i=0; i<sa.length; i++){
        	if(ta[i] != sa[i]){
        		return (char)(i + 'a');
        	}
        }
        return '0';*/
		//第二种方法
		int res = 0;
		for(char c : s.toCharArray()){
			res ^= c;
		}
		for(char c : t.toCharArray()){
			res ^= c;
		}
		return (char)res;
    }
}
