package leet.easy;

public class Leet383RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
        	return false;
        }
        int[] nums = new int[26];
        char[] mag = magazine.toCharArray();
        for(char c : mag){
        	nums[c - 'a']++;
        }
        char[] ran = ransomNote.toCharArray();
        for(char c : ran){
        	nums[c - 'a']--;
        }
        for(int i : nums){
        	if(i < 0){
        		return false;
        	}
        }
        return true;
    }
}
