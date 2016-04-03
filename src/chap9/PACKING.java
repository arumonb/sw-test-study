package chap9;

import java.io.FileInputStream;
import java.util.Scanner;

public class PACKING {
	
	static int AnswerN = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input/chap9/PACKING.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			
			
			System.out.println(AnswerN);
		}
		sc.close();
	}

}
