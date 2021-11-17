import java.util.*;
import java.io.*;
import java.math.*;

public class IntersectionOfLinkedLists {
	
	static class Node {
		int data;
		Node next;
		public Node(int item) {
			this.data = item;
			this.next = null;
		}
	}
	
	static int findIntersection(Node h1, Node h2) {
		int l1 = 0, l2 = 0;
		Node it1 = h1, it2 = h2;
		while( it1 != null) {
			l1++;
			it1 = it1.next;
		}
		while( it2 != null) {
			l2++;
			it2 = it2.next;
		}
		int i = 0;
		while (i < Math.abs(l1-l2)) {
			h1 = h1.next;
			h2 = h2.next;
			i++;
		}
		System.out.println(h1.data + " & "+h2.data);
		while( h1 != null && h2 != null) {
			if (h1.next == h2.next)
				return h1.data;
			else {
				h1 = h1.next;
				h2 = h2.next;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Node h1 = new Node(23);
		h1.next = new Node(45);
		h1.next.next = new Node(21);
		h1.next.next.next = new Node(78);
		h1.next.next.next.next = new Node(91);
		h1.next.next.next.next.next = new Node(30);
		
		
		Node h2 = new Node(12);
		h2.next = new Node(14);
		h2.next.next = new Node(78);
		h2.next.next.next = new Node(91);
		h2.next.next.next.next = new Node(30);
		
		
		System.out.println(findIntersection(h1, h2));
		
	}
	
}