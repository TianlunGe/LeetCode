package leet.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import leet.util.NestedInteger;

public class Leet341FlattenNestedListIterator implements Iterator<Integer> {

		private Stack<NestedInteger> stack;
	    private List<Integer> list;
	    private Iterator<Integer> it;
	    
	    //想法：创建一个list，用来存储数字，在构造时就将所有数字按顺序存入这个list，实现只要返回这个list的iterator即可。
	    /*
	     *构造list方法：一个栈存储不是数字的NestedInteger。遍历初始nestedList，遇到Integer直接加入list，非数字push入栈。
	     *下次优先查找栈，栈非空就取出NestedInteger，递归地进行相同的遍历，直到栈为空继续之前的原始遍历。
	    */
	    public Leet341FlattenNestedListIterator(List<NestedInteger> nestedList) {
	    	stack = new Stack<>();
	    	list = new ArrayList<>();
	        this.constractor(nestedList);
	        it = list.iterator();
	    }
	    
	    private void constractor(List<NestedInteger> nestedList){
	    	Iterator<NestedInteger> it = nestedList.iterator();
	    	while(it.hasNext()){
	        	NestedInteger ni;
	        	if(stack.isEmpty()){
	        		ni = it.next();
	        	}
	        	else{
	        		ni = stack.pop();
	        	}
	        	if(ni.isInteger()){
	        		list.add(ni.getInteger());
	        	}
	        	else{
	        		constractor(ni.getList());
	        	}
	        }
	    }
	    
	    @Override
	    public Integer next() {
	        return it.next();
	    }

	    @Override
	    public boolean hasNext() {
	        return it.hasNext();
	    }
	    
}
