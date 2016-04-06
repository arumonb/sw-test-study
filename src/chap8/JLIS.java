package chap8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 두 개의 정수 수열 A 와 B 에서 각각 증가 부분 수열을 얻은 뒤 
 * 이들을 크기 순서대로 합친 것을 "합친 증가 부분 수열" 이라고 할 때
 * 예를 들어 '1 3 4 7 9' 은 '1 9 4' 와 '3 4 7' 의 JLIS입니다
 * --->두개의 수열을 Arrays.sort로 합친 뒤 중복을 제거하여 길이를 체크 
 * 
 */


public class JLIS {

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
			
			int aArray[] = new int[a+b];

			//System.out.println(test_case+"번 case의");
			//System.out.println("A열의 수는 "+a);
			for (int i=0;i<a;i++) {
				aArray[i] = sc.nextInt();
//				System.out.print(aArray[i] + " ");
			}			
//			System.out.println("");
//			System.out.println("B열의 수는 "+b);
			for (int i=a;i<a+b;i++) {
				aArray[i] = sc.nextInt();
				//aArrayList.add(bArray[i]);
//				System.out.print(aArray[i] + " ");
			}
			Arrays.sort(aArray);

//			System.out.println("");
//			System.out.println("--------------------");
			
//			for (int i=0;i<a+b;i++) {
//				System.out.println(aArray[i]);			
//			}
			
			int minus = 0;			
			for (int i=0;i<a+b;i++) {			
				if ((i<a+b-1) && (aArray[i] == aArray[i+1])) {
//					System.out.println(i+"번째 값 "+aArray[i] + "이 " + aArray[i+1]+"와 같음");
					
					minus++;					
				}
			}
			System.out.println(aArray.length - minus);
			//System.out.println("aArray:"+(aArray.length - minus));
		}
		sc.close();
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
}
