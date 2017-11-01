package leet.easy;

import org.junit.Test;

public class Leet345ReverseVowelsOfAString {
	
	@Test
	public void test(){
		System.out.println(this.reverseVowels("aA"));
	}
	
	public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int l = 0, r = len - 1;
        while(l < r){
        	while(l < len){
        		char c = cs[l];
        		if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U'){
        			l++;
        		}
        		else{
        			break;
        		}
        	}
        	while(r >= 0){
        		char c = cs[r];
        		if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U'){
        			r--;
        		}
        		else{
        			break;
        		}
        	}
        	if(l < r){
        		char temp = cs[l];
        		cs[l] = cs[r];
        		cs[r] = temp;
        	}
        	l++;
        	r--;
        }
        return new String(cs);
    }
}
