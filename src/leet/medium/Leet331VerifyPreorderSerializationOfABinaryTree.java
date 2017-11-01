package leet.medium;

import java.util.LinkedList;

public class Leet331VerifyPreorderSerializationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
//        LinkedList<String> stack = new LinkedList<>();
        int count = 0;
        for(int i=0; i<nodes.length-1; i++){
        	if(nodes[i].equals("#")){
//        		if(stack.isEmpty()){
        		if(count == 0){
        			return false;
        		}
        		count--;
        	}
        	else{
        		count++;
        	}
        }
        if(count == 0 && nodes[nodes.length-1].equals("#")){
        	return true;
        }
        return false;
    }
}
