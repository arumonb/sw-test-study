package chap8;

import java.io.FileInputStream;
import java.util.Scanner;

public class ASYMTILING {
	static int MOD = 1000000007;
	static int[] cache = new int[101];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/chap8/ASYMTILING.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			for(int i=0; i < 101 ; i++) {
				cache[i] = -1;
			}
			int n = sc.nextInt();
			
			System.out.println(async(n));
		}
		sc.close();
	}
	
	public static int tiling(int width) {
		if(width <= 1) return 1;
		
		int ret = cache[width];
		if(ret != -1) return ret;
		
		ret = (tiling(width-2) + tiling(width - 1)) % MOD;
//		ret = (tiling(width-2) + tiling(width - 1));
		cache[width] = ret;
		
		return ret;
	}
	
	public static int async(int width) {
		// 홀수
		if(width %2 ==1) return (tiling(width)- tiling(width/2) + MOD) % MOD;
		// 짝수
		int ret = tiling(width);
		// 가운데 가로로 있는거
		ret = (ret - tiling(width/2) + MOD) % MOD;
		// 가운데 세로로 있는거
		ret = (ret - tiling(width/2 -1) + MOD) % MOD;
		
		return ret;
	}
}
