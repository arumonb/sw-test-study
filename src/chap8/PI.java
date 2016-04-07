package chap8;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SDS
 * 미완성
 */
public class PI {

	
	static int AnswerN;
	static int[] arr = new int[10000];
	static String input;
	
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
			input = sc.next();
			
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
			r = classify(start, end);
		}else{
			int a = 0;
			int b = 0;
			int c = 0;
			// 처음 3개 자르고
			a = classify(start, start + 2) + aaa(start + 3, end);
			
			// 4개 자르고
			b = classify(start, start + 3) + aaa(start + 4, end);
			
			// 5개 자르고
			c = classify(start, start + 5) + aaa(start + 5, end);
			r = Math.min(a, Math.min(b, c));
		}
		
		
		return r;
	}
	
	
	private static int classify(int a, int b) {
//		System.out.println("a=" + a + ",b=" + b);
		String M = input.substring(a, b);
//		System.out.println("M=" + M);
		char[] arr = new char[M.length()];
		Arrays.fill(arr, M.charAt(0));
		if(M.equals(new String(arr))) {
			return 1;
		}
		boolean progressive = true;
		for (int i = 0; i < M.length()-1; i++) {
			if(M.charAt(i + 1) - M.charAt(i) != M.charAt(1) - M.charAt(0)) {
				progressive = false;
			}
		}
		if(progressive && Math.abs(M.charAt(1) - M.charAt(0)) == 1) {
			return 2;
		}
		
		boolean alternating = true;
		for (int i = 0; i < M.length(); i++) {
			if(M.charAt(i) != M.charAt(i % 2)) {
				alternating = false;
			}
		}
		if(alternating) return 4;
		if(progressive) return 5;
		return 10;
	}
}
