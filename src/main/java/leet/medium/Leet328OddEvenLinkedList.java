package leet.medium;

import leet.util.ListNode;

public class Leet328OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = odd;
        ListNode cur = odd.next;
        boolean addToEven = true;
        while(cur != null){
        	if(addToEven){
        		even.next = cur;
        		even = even.next;
        	}
        	else{
        		odd.next = cur;
        		odd = odd.next;
        	}
        	addToEven = !addToEven;
        	cur = cur.next;
        }
        even.next = oddHead;
        odd.next = null;
        return head;
    }
}
