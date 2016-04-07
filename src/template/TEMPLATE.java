package template;

import java.io.FileInputStream;
import java.util.Scanner;

public class TEMPLATE {

	static int AnswerN;
	static int T;
	
	public static void main(String[] args) throws Exception {
		// estimate time
		long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("input/TEMPLATE.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println(AnswerN);
		}
		
		sc.close();
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);

	}

}
