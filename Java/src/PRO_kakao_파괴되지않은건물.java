
public class PRO_kakao_파괴되지않은건물 {
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        for(int[] arr : skill) {
        	
        	int r1 = arr[1];
        	int c1 = arr[2];
        	int r2 = arr[3];
        	int c2 = arr[4];
        	
        	int degree = arr[5];
        	
        	if(arr[0] == 1) {
        		for(int i=r1; i<=r2; i++) {
        			for(int j=c1; j<=c2; j++) {
        				board[i][j] -= degree;
        			}
        		}
        	}
        	
        	else {
        		for(int i=r1; i<=r2; i++) {
        			for(int j=c1; j<=c2; j++) {
        				board[i][j] += degree;
        			}
        		}
        	}
        }
        
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(board[i][j] > 0) answer++;
        	}
        }
        
        return answer;
    }
}
