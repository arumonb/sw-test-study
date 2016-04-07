package chap8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * 두 개의 정수 수열 A 와 B 에서 각각 증가 부분 수열을 얻은 뒤 
 * 이들을 크기 순서대로 합친 것을 "합친 증가 부분 수열" 이라고 할 때
 * 예를 들어 '1 3 4 7 9' 은 '1 9 4' 와 '3 4 7' 의 JLIS입니다
 * --->두개의 수열을 Arrays.sort로 합친 뒤 중복을 제거하여 길이를 체크 
 * 
 */


public class JLIS2 {

	static int AnswerN;
	static int T;
	
	public static void main(String args[]) throws FileNotFoundException
	{
		//estimate time
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("input/chap8/JLIS.txt"));
		
		Scanner sc = new Scanner(System.in);
		//BufferedReader= new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=sc.nextInt();
		int a; //a열의 수
		int b; //b열의 수		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			
			int arr[] = new int[a];
			int brr[] = new int[b];

			for (int i=0;i<a;i++) {
				arr[i] = sc.nextInt();
			}
			// System.out.println("===arr===");
			Set<Set<Integer>> aLIS = new HashSet<Set<Integer>>();
			for (int i = 0; i < a; i++) {
				aLIS.add(calcLIS(arr, i));
			}
			// System.out.println(aSet.toString());
			
			for (int i=0;i<b;i++) {
				brr[i] = sc.nextInt();
			}
			// System.out.println("===brr===");
			Set<Set<Integer>> bLIS = new HashSet<Set<Integer>>();
			for (int i = 0; i < a; i++) {
				bLIS.add(calcLIS(brr, i));
			}
			// System.out.println(bSet.toString());
			
			Iterator<Set<Integer>> ai = aLIS.iterator();
			
			int JLIST_LENGTH = 0;
			Set<Integer> JLIS;
			while(ai.hasNext()) {
				Set<Integer> a1 = ai.next();
				Iterator<Set<Integer>> bi = bLIS.iterator();
				while(bi.hasNext()) {
					Set<Integer> b1 = bi.next();
					JLIS = new HashSet<Integer>();
					JLIS.addAll(a1);
					JLIS.addAll(b1);
					if(JLIST_LENGTH < JLIS.size()) {
						JLIST_LENGTH = JLIS.size();
					}
				}
			}
			
			AnswerN = JLIST_LENGTH;
			System.out.println(AnswerN);
		}
		sc.close();
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
	
	private static Set<Integer> calcLIS(int[] array, int begin) {
		Set<Integer> LIS = new HashSet<Integer>();
		int increment = -1;
		for (int i = begin; i < array.length; i++) {
			if(increment < array[i]) {
				LIS.add(array[i]);
				increment = array[i];
			}
		}
		return LIS;
	}
	
	
}
