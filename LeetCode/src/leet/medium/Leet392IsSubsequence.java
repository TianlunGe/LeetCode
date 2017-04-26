package leet.medium;

public class Leet392IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();
        if(scs.length > tcs.length){
        	return false;
        }
        int i = 0, j = 0;
        while(i < scs.length && j < tcs.length){
        	if(scs[i] == tcs[j]){
        		i++;
        		j++;
        	}
        	else{
        		j++;
        	}
        }
        if(i >= scs.length){
        	return true;
        }
        return false;
    }
}
