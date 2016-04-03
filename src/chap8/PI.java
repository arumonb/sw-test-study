package chap8;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class PI {
	
	static int AnswerN;
	static String N;
	static int INF = 987654321;
	static int[] cache = new int[10002];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/chap8/8_7_PI.txt"));

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
			N = sc.next();
			AnswerN = memorize(0);
			System.out.println(AnswerN);
		}
		
//		4
//		2
//		5
//		2
//		14

		sc.close();

	}
	
	private static int classify(int a, int b) {
		String M = N.substring(a, b-a+1);
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
	
	private static int memorize(int begin) {
		if(begin == N.length()) return 0;
		int ret = cache[begin];
		if(ret != -1) {
			return ret;
		}
		ret = INF;
		for (int i = 3; i <= 5; i++) {
			if(begin + i <= N.length()) {
				ret = Math.min(ret, memorize(begin + i) + classify(begin, begin + i -1));
			}
		}
		return ret;
	}

}
