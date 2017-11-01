package leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import leet.util.ListNode;

public class Leet382LinkedListRandomNode {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(1);
		head.next.next = new ListNode(10);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(100);
		Leet382LinkedListRandomNode l = new Leet382LinkedListRandomNode(head);
		System.out.println(l.size);
	}
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Leet382LinkedListRandomNode(ListNode head) {
		list = new ArrayList<>();
    	rnd = new Random();
		while(head != null){
	    	list.add(head.val);
	    	head = head.next;
	    }
	    size = list.size();
	}
	List<Integer> list;
	Random rnd;
	int size;
	
	/** Returns a random node's value. */
	public int getRandom() {
	    return list.get(rnd.nextInt(size));
	}
}
