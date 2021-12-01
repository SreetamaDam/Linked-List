import java.util.*;
import java.io.*;

public class LRUCache {
	
	public static class Node {
		Node next, prev;
		int val;
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}
	
	public static void getLRUCache(int[] ar, int n, int k) {
		Node dummy = new Node(0);
		Node head = dummy;
		Node tail = dummy;
		HashMap<Integer, Node> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			Node newNode = new Node(ar[i]);
			if (!map.containsKey(ar[i])) {
				if (map.size() < k) {
					newNode.prev = tail;
				} else {
					dummy.next = dummy.next.next;
					dummy.next.prev = dummy;
				}
			} else {
				Node tempNode = map.get(ar[i]);
				Node prevNode = tempNode.prev;
				if (tempNode.next != null) {
					prevNode.next = prevNode.next.next;
					prevNode.next.prev = prevNode;
				} else {
					prevNode.next = null;
				}
			}
			head = dummy.next;
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
			map.put(ar[i], tail);
		}
		//System.out.println(head.val);
		head.prev = null;
		viewLRU(tail);
	}
	
	
	public static void viewLRU(Node tail) {
		if (tail == null) 
			return;
		Node currentNode = tail;
		System.out.println();
		while(currentNode != null) {
			System.out.print(currentNode.val+ " ");
			currentNode = currentNode.prev;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,1,4,5};
		int k = 4;
		getLRUCache(a, a.length, k);
	}
}