package leet.medium;

import java.util.Stack;

public class Leet394DecodeString {
	
	public String decodeString(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char c : cs){
        	if(Character.isDigit(c) || c == '['){
        		stack.push(c);
        	}
        	else if(c == ']'){
        		while(stack.peek() != '['){
        			sb.insert(0, stack.pop());
        		}
        		stack.pop();
        		StringBuilder times = new StringBuilder();
        		while(!stack.isEmpty() && Character.isDigit(stack.peek())){
        			times.insert(0, stack.pop());
        		}
        		int t = Integer.parseInt(times.toString());
        		String temp = sb.toString();
        		while(--t > 0){
        			sb.append(temp);
        		}
        		if(stack.isEmpty()){
        			res.append(sb);
        			sb.delete(0, sb.length());
        		}
        		else{
        			for(char c2 : sb.toString().toCharArray()){
        				stack.push(c2);
        			}
        			sb.delete(0, sb.length());
        		}
        	}
        	else {
        		if(stack.isEmpty()){
        			res.append(c);
        		}
        		else{
        			stack.push(c);
        		}
        	}
        }
        return res.toString();
    }
	
}
