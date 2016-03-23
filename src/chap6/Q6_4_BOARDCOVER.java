package chap6;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Q6_4_BOARDCOVER {

	static int AnswerN = -1;
	static int H;
	static int W;
	
	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이
		 * 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에
		 * 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래
		 * 주석을 지우고 이 메소드를 사용하셔도 좋습니다. 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석
		 * 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("input/chap6/6_4_BOARDCOVER.txt"));

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

			
			
			H = sc.nextInt();
			W = sc.nextInt();
			
			String[][] board = new String[H][W];
			
			System.out.println(H + " " + W);
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					String t = sc.next();
					System.out.print(t);
					board[i][j] = t;
				}
				System.out.println("");
			}
			
			countCase(board);

			// 표준출력(화면)으로 답안을 출력합니다.

//			System.out.println("#" + test_case + " " + AnswerN);
			System.out.println(AnswerN);
		}
		sc.close();
	}
	

	/**
	 * 모든 경로를 다 더이상 놓을 곳이 없는지를 어떻게 판단?
	 */
	private static void countCase(String[][] board) {
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// 놓을 곳을 판단(중심 블럭 좌표를 기준으로 4가지 방법을 판단)
				
				// 블럭을 놓는데 성공했으면, 재귀호출
				
				// 흰색이 남아있지 않고 놓을 곳이 없으면 성공 카운트 +1
				
				// 흰색이 남아있는데 놓을 곳이 없으면 +0
			}
		}
		
	}
	
	private static boolean setBlock(int x, int y, String[][] board) {
		
		if(".".equals(board[x][y-1]) && ".".equals(board[x][y]) && ".".equals(board[x-1][y])) { // case 1
			
		}
		if(".".equals(board[x][y+1]) && ".".equals(board[x][y]) && ".".equals(board[x-1][y])) { // case 2
		
		}
		if(".".equals(board[x][y-1]) && ".".equals(board[x][y]) && ".".equals(board[x+1][y])) { // case 3
		
		}
		if(".".equals(board[x][y+1]) && ".".equals(board[x][y]) && ".".equals(board[x+1][y])) { // case 4
		
		}
		
		return false;
	}

}
