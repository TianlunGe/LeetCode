package leet.easy;

public class Leet387FirstUniqueCharacterInString {
	public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] ss = s.toCharArray();
        int len = ss.length;
        for(int i=0; i<len; i++){
        	arr[ss[i] - 'a']++;
        }
        int res = len;
        /*for(int i=0; i<26; i++){
        	if(arr[i] == 1){
        		char c = (char) (i + 'a');
        		for(int j=0; j<len; j++){
        			if(ss[j] == c){
        				res = Math.min(res, j);
        			}
        		}
        	}
        }*/
        //二次遍历原字符串，而不是遍历字符数组，会快好多。
        for(int i=0; i<len; i++){
        	if(arr[ss[i] - 'a'] == 1){
        		res = i;
        		break;
        	}
        }
        if(res == len){
        	res = -1;
        }
        return res;
    }
}
