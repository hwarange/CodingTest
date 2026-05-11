import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_13736_사탕분배 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			
			long sum = a+b;
			
			long pow = modPow(2, k, sum);
			
			//k번 반복 후의 a의 사탕 개수
			long resultA = (a*pow) % sum;
			//k번 반복 후의 b의 사탕 개수 b = sum-a
			long resultB = sum - resultA;
			
			long resultMin = Math.min(resultA, resultB);
			sb.append(resultMin).append("\n");
		}
		System.out.print(sb);
	}
	
	//분할정복으로 나머지 연산
	static long modPow(long base, long exp, long mod) {
		long result = 1;
		base %= mod;
		
		while(exp > 0) {
			// exp가 홀수일 때는 결과값에 밑을 한 번 곱해줌
			if((exp % 2) == 1) result = (result * base) % mod;
			
			// 밑을 제곱하고 지수를 반으로 나눔
			base = (base*base) % mod;
			exp /= 2;
		}
		
		return result;
	}
}
