package leet.easy;

import java.util.ArrayList;
import java.util.List;

public class Leet438FindAllAnagramsInAString {
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        int[] window = new int[26];
        int len = p.length();
        if(len > s.length()) return res;
        char[] cs1 = s.toCharArray(), cs2 = p.toCharArray();
        for(int i=0; i<len; i++) {
        	count[cs2[i] - 'a']++;
        	window[cs1 [i]- 'a']++;
        }
        if(this.isSame(window, count)) res.add(0);
        for(int i=0; i<cs1.length-len; i++) {
        	if(this.isSame(count, window)) res.add(i);
        	window[cs1[i] - 'a']--;
        	window[cs1[i+len] - 'a']++;
        }
        return res;
    }
	
	private boolean isSame(int[] a1, int[] a2) {
		for(int i=0; i<26; i++) {
			if(a1[i] != a2[i]) return false;
		}
		return true;
	}
	
}
