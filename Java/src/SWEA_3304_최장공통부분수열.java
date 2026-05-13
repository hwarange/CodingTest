import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3304_최장공통부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			//dp배열 생성 => 문자열길이보다 1많게 해서 
			//첫번째 열과 행을 0으로 채워줌
			int[][] dp = new int[str1.length()+1][str2.length()+1];
			
			//실질적인 dp배열을 1부터 사용
			for(int i=1; i<=str1.length(); i++) {
				for(int j=1; j<=str2.length(); j++) {
					
					//하지만 문자열 문자 비교는 0번부터해야해서 -1
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						
						//문자가 같은 경우 dp배열 대각선좌측위 값 +1 
						dp[i][j] = dp[i-1][j-1]+1;
					}
					
					else {
						//문자가 다른 경우
						//비교하는 문자를 버리고 문자열끼리 비교 혹은
						//비교당하는 문자를 버리고 문자열끼리 비교값 중에 최대
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			sb.append(dp[str1.length()][str2.length()]).append("\n");
		}
		
		System.out.print(sb);
	}
}
