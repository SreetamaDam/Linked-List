import java.util.*;
import java.io.*;

public class MaxInSlidingWindow {
	
	public static void getMax(int[] ar, int k) {
		
		Deque<Integer> dq = new LinkedList<Integer>();
		int i;
		int n = ar.length;
		for( i = 0; i < k ; i++) {
			while (!dq.isEmpty() && ar[i] >= ar[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		
		for (; i < n; i++) {
			System.out.print(ar[dq.peek()]+" ");
			while (!dq.isEmpty() && dq.peek() <= i-k ) {
				dq.removeFirst();
			}
			while (!dq.isEmpty() && ar[i] >= ar[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		
		System.out.print(ar[dq.peek()]+ " ");
	}
	
	public static void main(String[] args) throws IOException{
		int[] ar = {12, 1, 78, 90, 57, 89, 56};
		int k = 3;
		getMax(ar, k);
	}
}