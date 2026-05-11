import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1278_배낭채우기2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][W+1];
		
		//보석의 개별 무게
		int[] w = new int[N+1];
		//보석의 개별 값어치
		int[] p = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 첫번째 반복문은 보석의 개수(1번보석부터 N번보석까지)
		for(int i=1; i<=N; i++) {
			
			// 두번째 반복문은 뽑은 보석들 중에서 무게0부터 최대 무게까지의 최대 값어치
			for(int j=0; j<=W; j++) {
				
				// N번째 보석의 무게가 j를 넘는 경우
				// 이전의 최대 보석의 값어치를 씀
				if(w[i] > j) dp[i][j] = dp[i-1][j];
				
				//j가 N번째 보석의 무게를 넘으면
				//이전의 최대 보석의 값어치와 (현재 보석의 값어치 + 현재 보석의 무게를 뺀 무게 중에서 이전의 최대 값어치)를 비교함
				else dp[i][j] = Math.max(dp[i-1][j-w[i]]+p[i], dp[i-1][j]);
			}
		
		}
		
		System.out.println(dp[N][W]);
	}
}
