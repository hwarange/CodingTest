import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int[] coin = new int[8];
			int[] unit = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10};
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0; i<8; i++) {
				if(N >= unit[i]) {
					coin[i] += N/unit[i];
					N %= unit[i];
				}
			}
			
			for(int i=0; i<8; i++) {
				sb.append(coin[i]).append(" ");
			}
			
			sb.deleteCharAt(sb.length()-1).append("\n");
		}
		
		System.out.print(sb);
	}
}
