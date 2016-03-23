package chap7;

import java.io.FileInputStream;
import java.util.Scanner;

public class QUADTREE {

	static String AnswerN = "";
	static int INDEX = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/chap7/QUADTREE.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String s = sc.next();
			INDEX = 0;
			AnswerN = reverse(s.toCharArray());
			
			System.out.println(AnswerN);
		}
		
		sc.close();

	}
	
	private static String reverse(char[] c) {
		char head = c[INDEX];
		++INDEX;
		if(head == 'b' || head == 'w') {
			return String.valueOf(head);
		}
		String upperLeft = reverse(c);
		String upperRight = reverse(c);
		String lowerLeft = reverse(c);
		String lowerRight = reverse(c);
		
		return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
	}

}
