package chap8;

import java.io.FileInputStream;
import java.util.Scanner;

public class PI {

	
	static int AnswerN;
	static int[] arr = new int[10000];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/chap8/PI.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
//		모든 숫자가 같을 때 (예: 333, 5555) 난이도: 1
//		숫자가 1씩 단조 증가하거나 단조 감소할 때 (예: 23456, 3210) 난이도: 2
//		두 개의 숫자가 번갈아 가며 출현할 때 (예: 323, 54545) 난이도: 4
//		숫자가 등차 수열을 이룰 때 (예: 147, 8642) 난이도: 5
//		그 외의 경우 난이도: 10
		
//		12341234 
//		11111222 
//		12122222 
//		22222222 
//		12673939 
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = sc.next();
			
			int l = input.length();
			
		    for (int i = 0; i < l; i++){
		        arr[i] = input.charAt(i) - '0';
		    }

		    for (int i=0;i<l;i++) {
		        System.out.print(arr[i]);
		    }
			
			System.out.println("\n");
		    
			AnswerN = aaa(0, l);
		    
			System.out.println(AnswerN);
		}
		
//		4
//		2
//		5
//		2
//		14

		sc.close();
	}

	private static int aaa(int start, int end) throws Exception {
		int r = 0;
		if(end - start <= 5) {
			r = eval(start, end);
		}else{
			// 처음 3개 자르고
			r = eval(start, start + 2) + aaa(start + 3, end);
			
			// 4개 자르고
			r = eval(start, start + 3) + aaa(start + 4, end);
			
			// 5개 자르고
			r = eval(start, start + 5) + aaa(start + 5, end);
		}
		
		
		return r;
	}
	
	
	private static int eval(int start, int end) {
		int k = 0;
		return k;
	}
}
