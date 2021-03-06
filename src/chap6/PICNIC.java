package chap6;

import java.io.FileInputStream;
import java.util.Scanner;

public class PICNIC {

	static int N;
	static int M;
	static int AnswerN;
	static boolean[][] areFriends = new boolean[10][10];

	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이
		 * 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에
		 * 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래
		 * 주석을 지우고 이 메소드를 사용하셔도 좋습니다. 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석
		 * 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("input/chap6/PICNIC.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 */

			boolean[] taken = new boolean[10];
			// areFriends 초기화
			// taken 초기화
			for (int j = 0; j < taken.length; j++) {
				taken[j] = false;
				for (int i = 0; i < taken.length; i++) {
					areFriends[j][i] = false;
				}
			}
			
			N = sc.nextInt();
			M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				
				int x = Integer.parseInt(sc.next());
				int y = Integer.parseInt(sc.next());
				
//				System.out.println(x + " " + y);
				areFriends[x][y] = true;
				areFriends[y][x] = true;
				
			}
			
			// ///////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다. 여러분의 정답은 AnswerN에 저장되는 것을 가정하였습니다.
			 */
			// ///////////////////////////////////////////////////////////////////////////////////////////
			
			AnswerN = countPairings(taken);

			// 표준출력(화면)으로 답안을 출력합니다.

//			System.out.println("#" + test_case + " " + AnswerN);
			System.out.println(AnswerN);
		}
		sc.close();
	}
	
	private static int countPairings(boolean[] taken) {
		int firstFree = -1;

		for(int i=0;i<N;++i) {
			if(!taken[i]) {
				firstFree = i;
				break;
			}
		}
		if(firstFree == -1) return 1;
		int ret = 0;
		for (int pairWith = firstFree + 1; pairWith < N; ++pairWith) {
			if(!taken[pairWith] && areFriends[firstFree][pairWith]) {
				taken[firstFree] = taken[pairWith] = true;
				ret += countPairings(taken);
				taken[firstFree] = taken[pairWith] = false;
			}
		}
		return ret;
	}
 
}
