package leet.medium;

public class Leet208ImplementTrie {
	
	Node[] root;
	
	/** Initialize your data structure here. */
	public Leet208ImplementTrie() {
//    public Trie() {
        root = new Node[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Node[] cur = root;
    	Node[] pre = null;
        for(char c : word.toCharArray()) {
        	if(cur[c-'a'] == null) {
        		cur[c-'a'] = new Node();
        	}
        	pre = cur;
        	cur = cur[c-'a'].next;
        }
        pre[word.charAt(word.length()-1)-'a'].end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Node[] cur = root;
        Node[] pre = null;
        for(int i=0; i<cs.length; i++) {
        	if(cur[cs[i]-'a'] == null) return false;
//        	if(i == cs.length-1) return cur[cs[i]-'a'].end;
        	pre = cur;
        	cur = cur[cs[i]-'a'].next;
        }
        return pre[cs[cs.length-1]-'a'].end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node[] cur = root;
        for(char c : prefix.toCharArray()) {
        	if(cur[c-'a'] == null) return false;
        	cur = cur[c-'a'].next;
        }
        return true;
    }
}

class Node {
	boolean end = false;
	Node[] next;
	public Node() {
		next = new Node[26];
	}
}
