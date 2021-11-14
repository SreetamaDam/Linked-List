import java.util.*;
import java.io.*;

public class AreaUnderHistogram {
	
	
	static int getMaxArea( int[] ar ) {
		Stack<Integer> s = new Stack<Integer>();
		int n = ar.length, i = 0;
		int top , max_area = 0, area;
		while (i < n) {
			if (s.isEmpty() || ar[i] > ar[s.peek()]) {
				s.push(i++);
			} else {
				top = s.peek();
				s.pop();
				area = ar[top] * (s.isEmpty() ? i : i - s.peek() - 1);
				
				if (max_area < area)
					max_area = area;
			}
		}
		return max_area;
	}
	
	public static void main(String[] rags) {
		int[] ar = {6, 2, 5, 4, 5, 1, 6 };
		System.out.println(getMaxArea(ar));
	}
}