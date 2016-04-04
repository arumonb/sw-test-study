package chap9;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PACKING2 {
	
	static int N = 0;
	static int CAPACITY = 0;
	static String[] NAME = new String[100];
	static int[] VOLUME = new int[100];
	static int[] NEED = new int[100];
	static int[][] CACHE = new int[1001][100];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/chap9/PACKING.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 입력 처리
			N = sc.nextInt();
			CAPACITY = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				String key = sc.next();
				NAME[i] = key;
				VOLUME[i] = sc.nextInt();
				NEED[i] = sc.nextInt();
			}
			int ret = pack(CAPACITY, 0);
			
			List<String> picked = new ArrayList<String>();
			reconstruct(CAPACITY, 0, picked);
			System.out.println(ret + " " + picked.size());
//			System.out.println(picked.toString());
			for (String string : picked) {
				System.out.println(string);
			}
		}
		sc.close();
	}

	// 캐리어에 남은 용량이 CAPACITY일 때, item 이후의 물건들을 담아 얻을 수 있는 최대의 절박도의 합을 반환한다.
	private static int pack(int capacity, int item) {
		int ret  = 0;
		
		// 기저사례 : 더 담을 물건이 없을 때
		if(item == N) {
			return 0;
		}
		
		ret = CACHE[capacity][item];
		if(ret != 0) {
			return ret;
		}
		// 이 물건을 담지 않을 경우
		ret = pack(capacity, item + 1);
		CACHE[capacity][item] = ret;
		// 이 물건을 담을 경우
		if(capacity >= VOLUME[item]) {
			ret = Math.max(ret, pack(capacity - VOLUME[item], item + 1) + NEED[item]);
			CACHE[capacity][item] = ret;
		}
		return ret;
	}
	
	private static void reconstruct(int capaicity, int item, List<String> picked) {
		if(item == N) {
			return;
		}
		if(pack(capaicity, item) == pack(capaicity, item + 1)) {
			reconstruct(capaicity, item+1, picked);
		}else{
			picked.add(NAME[item]);
			reconstruct(capaicity - VOLUME[item], item + 1, picked);
		}
	}
}
