package leet.util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {}
	public ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		ListNode cur = this;
		StringBuilder sb = new StringBuilder();
		while(cur != null){
			sb.append(cur.val + " to ");
			cur = cur.next;
		}
		sb.append("null");
		return sb.toString();
	}

}
