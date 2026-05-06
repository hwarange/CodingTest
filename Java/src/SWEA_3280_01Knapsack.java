import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3280_01Knapsack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] W = new int[N+1];
			int[] V = new int[N+1];
			
			//첫번째 행은 믈건
			//두번째 행은 무게
			int[][] dp = new int[N+1][K+1];
			
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				//부피
				W[i] = Integer.parseInt(st.nextToken());
				//가치
				V[i] = Integer.parseInt(st.nextToken());
			}
			
			//물건 i번부터 N번까지
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=K; j++) {
					if(W[i] > j) dp[i][j] = dp[i-1][j];
					else dp[i][j] = Math.max(dp[i-1][j-W[i]]+V[i], dp[i-1][j]);
				}
			}
			
			
		}
	}
}
