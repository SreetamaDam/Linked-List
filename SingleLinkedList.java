import java.util.*;
import java.io.*;

public class SingleLinkedList {
	
	static Node head = null;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static void insertAtFront( int item) {
		Node node = new Node(item);
		if (head == null)
			head = node;
		else {
			node.next = head;
			head = node;
		}
	}
	
	static void insertAtEnd( int item) {
		Node node = new Node(item);
		if (head == null)
			head = node;
		else {
			Node currentNode = head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
		}
	}
	
	static void insertAtAny(int item, int pos) {
		if (pos == 1 || head == null)
			insertAtFront(item);
		else {
			Node newNode = new Node(item);
			Node currentNode = head;
			int i = 0;
			while ( currentNode != null && i < pos-2) {
				i++;
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}
	
	static void deleteAtAny(int pos) {
		if (pos == 1)
			deleteFromFront();
		else {
			if (head == null)
				return;
			Node currentNode = head;
			int i = 0;
			while(currentNode.next != null && i < pos-2) {
				i++;
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}
	
	static void deleteItem(int item) {
		if (head == null)
			return;
		Node currentNode = head;
		while(currentNode.next != null && currentNode.next.data != item ) {
			currentNode = currentNode.next;
		}
		if (currentNode.next != null)
			currentNode = currentNode.next.next;
	}
	
	static void deleteFromFront() {
		if (head == null) 
			return;
		head = head.next;
	}
	
	static void deleteFromEnd() {
		if(head == null)
			return;
		Node currentNode = head;
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}
	
	static void viewSLL() {
		if (head == null) 
			System.out.println("Empty list");
		else {
			Node currentNode = head;
			while (currentNode != null) {
				System.out.print(currentNode.data+ " ");
				currentNode = currentNode.next;
			}
		}
		System.out.println();
	}
	
	static void reverseSLL() {
		head = doReverse(head);
	}
	
	static Node doReverse(Node head) {
		if (head == null || head.next == null)
			return head;
		Node node = doReverse(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
	
	static boolean hasLoop() {
		if (head == null)
			return false;
		Node fastptr = head, slowptr = head;
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		return (fastptr == slowptr);
	}
	
	static void detectAndBreakLoop() {
		if (head == null)
			return;
		Node fastptr = head, slowptr = head;
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		if (slowptr == fastptr) {
			slowptr = head;
			if (slowptr != fastptr) {
				while(slowptr.next != fastptr.next) {
					slowptr = slowptr.next;
					fastptr = fastptr.next;
				}
			}
			fastptr.next = null;
		} else { //if loop in the first position
			while(slowptr != fastptr.next) {
				fastptr = fastptr.next;
			}
			fastptr.next = null;
		}
	}
	
	static void pairwiseSwap() {
		Node currentNode = head;
		while(currentNode != null && currentNode.next != null) {
			int k = currentNode.data;
			currentNode.data = currentNode.next.data;
			currentNode.next.data = k;
			currentNode = currentNode.next.next;
		}
	}
	
	static void oddAndEven() {
		if (head == null)
			return;
		Node dummyEven = new Node(0);
		Node dummyOdd = new Node(0);
		Node oddNode = dummyOdd;
		Node evenNode = dummyEven;
		Node currentNode = head;
		while( currentNode != null) {
			//System.out.println(currentNode.data);
			Node newNode = new Node(currentNode.data);
			if (currentNode.data % 2 == 0) {
				evenNode.next = newNode;
				evenNode = evenNode.next;
			} else {
				oddNode.next = newNode;
				oddNode= oddNode.next;
			}
			currentNode = currentNode.next;
		}
		oddNode.next = dummyEven.next;
		System.out.println(dummyEven.next.data);
		System.out.println("Even and odd list : ");
		dummyOdd = dummyOdd.next;
		while (dummyOdd != null) {
			System.out.print(dummyOdd.data + " ");
			dummyOdd = dummyOdd.next;
		}
	}
	
	static int getMid() {
		if (head == null)
			return -1;
		Node slowptr = head;
		Node fastptr = head;
		while (fastptr.next != null && fastptr.next.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		if (fastptr.next == null)
			return slowptr.data;
		return slowptr.next.data;
	}
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("Press 1 to insert item in front, press 2 to insert item at end, press 3 to insert at any position, press 4 to delete from any position, press 5 to delete an item, press 6 delete from front, press 7 to delete from end, press 8 to view linked list, press 9 to reverse linked list, press 10 to detect loop in linked list, press 11 to detect and remove loop in linked list, press 12 to pairwise swap, press 13 to seperate odd and even, press 14 to exit, press 15 to get mid of the list.....");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch(option) {
				case 1 : System.out.println("Enter item");
						int item = sc.nextInt();
						insertAtFront(item);
						break;
				case 2 : System.out.println("Enter item");
						item = sc.nextInt();
						insertAtEnd(item);
						break;
				case 3 : System.out.println("Enter item");
						item = sc.nextInt();
						System.out.println("Enter position");
						int pos = sc.nextInt();
						insertAtAny(item, pos);
						break;
				case 4 : System.out.println("Enter position to delete");
						pos = sc.nextInt();
						deleteAtAny(pos);
						break;
				case 5 : System.out.println("Enter item to delete");
						item = sc.nextInt();
						deleteItem(item);
						break;
				case 6 :deleteFromFront();
						break;
				case 7 :deleteFromEnd();
						break;
				case 8 :viewSLL();
						break;
				case 9 :reverseSLL();
						break;
				case 10 :if(hasLoop()) 
							System.out.println("Has loop");
						else 
							System.out.println("No loop");
						break;
				case 11: detectAndBreakLoop();
						break;
				case 12: pairwiseSwap();
						break;
				case 13: oddAndEven();
						break;
				case 14: System.exit(0);
						break;
				case 15 : System.out.println(getMid());
						break;
			}
		}
	}
}