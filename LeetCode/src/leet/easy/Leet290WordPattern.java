package leet.easy;

import java.util.HashSet;
import java.util.Set;

//Test
public class Leet290WordPattern {
	public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s");
        if(words.length != pattern.length()){
        	return false;
        }
        String[] temp = new String[26];
        Set<String> set = new HashSet<>();
        for(int i=0; i<pattern.length(); i++){
        	int index = pattern.charAt(i) - 'a';
        	if(temp[index] == null){
        		if(set.contains(words[i])){
        			return false;
        		}
        		temp[index] = words[i];
        		set.add(words[i]);
        	}
        	else if(!words[i].equals(temp[index])){
        		return false;
        	}
        }
        return true;
    }
}
