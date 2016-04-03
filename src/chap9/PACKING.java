package chap9;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PACKING {
	
	static int N = 0;
	static int C = 0;
//	static int sumc = 0;
//	static int sump = 0;
	static Map<Set<String>, Integer[]> result = null;

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
			
			// 입력 처리
			N = sc.nextInt();
			C = sc.nextInt();
			result = new HashMap<Set<String>, Integer[]>();
			int[][] arr = new int[N][2];
			Set<String> set = new HashSet<String>();
			String[] keys = new String[N];
			for (int i = 0; i < N; i++) {
				String key = sc.next();
				keys[i] = key;
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			// 절박도/부피 가 가장 큰 순으로 
			
			// 일단 무식하게풀기
			aaa(arr, set,keys, 0, 0);
			Iterator<Set<String>> i = result.keySet().iterator();
			while(i.hasNext()) {
				Set<String> keySet = i.next();
				System.out.println(keySet);
				System.out.println(result.get(keySet)[0] + " " + result.get(keySet)[1]);
			}
//			System.out.println(result.toString());
		}
		sc.close();
	}
	
	private static void aaa(int[][] arr, Set<String> list,String[] keys, int sumc, int sump) {
		System.out.println("aaa->" + arr.toString());
		System.out.println("aaa->" + list.toString());
		if(arr.length == 0) {
			return;
		}
		for(int i =0;i< arr.length; i++){
			String key = keys[i];
			if(arr[i][0] == -1) {
				continue;
			}
			if(sumc + arr[i][0] > C) {
				result.put(list, new Integer[]{sumc, sump});
				return;
			}else if(sumc + arr[1][0] == C) {
				sumc += arr[i][0];
				sump += arr[i][1];
				list.add(key);
				result.put(list, new Integer[]{sumc + arr[i][0], sump + arr[i][1]});
				return;
			}else if(sumc + arr[i][0] < C) {
				sumc += arr[i][0];
				sump += arr[i][1];
				list.add(key);
				result.put(list, new Integer[]{sumc + arr[i][0], sump + arr[i][1]});
				arr[i][0] = -1;
				aaa(arr, list, keys, sumc, sump);
			}
		}
	}

}
