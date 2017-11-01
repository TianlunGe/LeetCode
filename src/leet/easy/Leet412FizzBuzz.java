package leet.easy;

import java.util.ArrayList;
import java.util.List;

public class Leet412FizzBuzz {
	public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
        	if(i % 3 == 0){
        		sb.append("Fizz");
        	}
        	if(i % 5 == 0){
        		sb.append("Buzz");
        	}
        	if(sb.length() > 0){
        		res.add(sb.toString());
        		sb.delete(0, sb.length());
        	}
        	else{
        		res.add(String.valueOf(i));
        	}
        }
        return res;
    }
}
