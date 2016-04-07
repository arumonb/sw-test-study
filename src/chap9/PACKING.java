package chap9;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PACKING {
	
	static int N = 0;
	static int C = 0;
	static int SUMC = 0;
	static int SUMP = 0;
	static String result = null;
	static List<String> packs;
	static StringBuffer sb;
	static int[][] ARR = new int[100][3];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/chap9/PACKING.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 입력 처리
			N = sc.nextInt();
			C = sc.nextInt();
			packs = new ArrayList<String>();
			
			
			for (int i = 0; i < N; i++) {
				String key = sc.next();
				packs.add(key);
				ARR[i][0] = sc.nextInt();
				ARR[i][1] = sc.nextInt();
				ARR[i][2] = 0;
			}
			
			// 일단 무식하게풀기
			SUMP = 0;
			SUMC = 0;
			
			calc(ARR, 0);
			int count = 0;
			String k = "";
			for (int i = 0; i < N; i++) {
				if(result.charAt(i) == '1') {
					count++;
					if(i == N-1) {
						k += packs.get(i);
					}else{
						k += packs.get(i) + "\n";	
					}
				}
			}
			
			System.out.println(SUMP + " " + count);
			System.out.print(k);
		}
		sc.close();
	}
	
	private static void calc(int[][] arr, int index) {
		sb = new StringBuffer();
		int c = 0;
		int p = 0;
		for (int i =0;i<N;i++) {
			sb.append(arr[i][2]);
			
			if(arr[i][2] == 1) {
				c += arr[i][0];
				p += arr[i][1];
			}
		}
		
		String r = sb.toString();
		int v = Integer.parseInt(r, 2);
		
		if(c <= C && v != 0) {
			// System.out.println(v + "=(" + c + ", " + p + ")");
			if(SUMP <= p) {
				SUMC = c;
				SUMP = p;
				result = r;
			}
		}
		
		for (int i = 0 ;i<N;i++) {
			if(arr[i][2] == 1) continue;
			arr[i][2] = 1;
			calc(arr, i);
			arr[i][2] = 0;
		}
	}
}
