package leet.medium;

import java.util.Iterator;

/**
 * @author Happy
 *
 * @param <E>
 * 实现Iterator，要求有peek()方法。实现方式将当前变量保存下来并将原生Iterator往后移一位，自己维护原生的Iterator，原生Iterator比这个Iterator快一个变量。
 */
public class Leet284PeekingIterator<E> implements Iterator<E> {
	
	E now;
	Iterator<E> it;
	
	public Leet284PeekingIterator(Iterator<E> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    if(it.hasNext()){
	    	now = it.next();
	    }
	    else{
	    	now = null;
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public E peek() {
        return now;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public E next() {
	    E temp = now;
	    if(it.hasNext()){
	    	now = it.next();
	    }
	    else{
	    	now = null;
	    }
	    return temp;
	}

	@Override
	public boolean hasNext() {
	    return now == null;
	}
	
}
