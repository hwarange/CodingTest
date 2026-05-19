import java.util.Arrays;

public class PRO_kakao_파괴되지않은건물 {
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] diff = new int[board.length+1][board[0].length+1];
        
        for(int[] arr: skill) {
        	int r1 = arr[1];
    		int c1 = arr[2];
    		int r2 = arr[3];
    		int c2 = arr[4];
    		
        	if(arr[0] == 1) {
        		
        		diff[r1][c1] -= arr[5];
        		diff[r2+1][c2+1] -= arr[5]; 
        		
        		// 행기준 누적합
        		diff[r1][c2+1] += arr[5];
        		
        		// 열기준 누적합
        		diff[r2+1][c1] += arr[5];

        	}
        	else {
        		
        		diff[r1][c1] += arr[5];
        		diff[r2+1][c2+1] += arr[5]; 
        		
        		// 행기준 누적합
        		diff[r1][c2+1] -= arr[5];
        		
        		// 열기준 누적합
        		diff[r2+1][c1] -= arr[5];
        	}
        }
        
        //행기준
        for(int i=0; i<diff.length; i++) {
        	for(int j=1; j<diff[0].length; j++) {
        		diff[i][j] += diff[i][j-1];
        	}
        }
        
        //열기준
        for(int i=1; i<diff.length; i++) {
        	for(int j=0; j<diff[0].length; j++) {
        		diff[i][j] += diff[i-1][j];
        	}
        }

        
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		
        		diff[i][j] += board[i][j];
        		
        		if(diff[i][j] > 0) answer++;
        	}
        }
        
        return answer;
    }
	
//	public static void main(String[] args) {
//		int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//		int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
//		
//		System.out.println(solution(board, skill));
//		
//	}
}
