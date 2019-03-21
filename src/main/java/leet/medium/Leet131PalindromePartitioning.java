package leet.medium;

import java.util.ArrayList;
import java.util.List;

public class Leet131PalindromePartitioning {
	
	List<List<String>> res;
	
	public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        this.findPermutation(new ArrayList<String>(), s);
        return res;
    }
	
	private void findPermutation(List<String> list, String s) {
		if(s.isEmpty()) {
			res.add(new ArrayList<String>(list));
			return;
		}
		for(int len=1; len<=s.length(); len++) {
			String tmp = s.substring(0, len);
			if(this.isPalindrome(tmp)) {
				list.add(tmp);
				this.findPermutation(list, s.substring(len));
				list.remove(list.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		if(s.length() == 1) return true;
		for(int l=0, r=s.length()-1; l<r; l++, r--) {
			if(s.charAt(l) != s.charAt(r)) return false;
		}
		return true;
	}
	
}
