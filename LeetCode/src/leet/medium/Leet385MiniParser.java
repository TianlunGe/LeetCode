package leet.medium;

import java.util.Stack;

import leet.util.NestedInteger;

public class Leet385MiniParser {
	public NestedInteger deserialize(String s) {
		if(s == null || s.isEmpty()){
			return new NestedInteger();
		}
        char[] cs = s.toCharArray();
        Stack<NestedInteger> res = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : cs){
        	if(c == '['){
        		NestedInteger out = new NestedInteger();
                res.push(out);
        	}
        	else if(c == ']'){
        		NestedInteger in = res.pop();
        		if(sb.length() > 0){
        			in.add(new NestedInteger(Integer.parseInt(sb.toString())));
        			sb.delete(0, sb.length());
        		}
        		if(res.isEmpty()){
        			res.push(in);
        		}
        		else {
        			res.peek().add(in);
        		}
        	}
        	else if(c == ','){
        		if(sb.length() != 0){
        			res.peek().add(new NestedInteger(Integer.parseInt(sb.toString())));
        		}
        		sb.delete(0, sb.length());
        	}
        	else{
        		sb.append(c);
        	}
        }
        if(res.isEmpty()){
        	return new NestedInteger(Integer.parseInt(sb.toString()));
        }
        return res.pop();
    }
}
