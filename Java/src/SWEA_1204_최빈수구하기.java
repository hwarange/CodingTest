import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			int times = Integer.parseInt(br.readLine());
			sb.append("#").append(times).append(" ");
			
			int[] freq = new int[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				
				freq[score]++;
			}
			
			int max = 0;
			int idx = 0;
			for(int i=0; i<101; i++) {
				if(max <= freq[i]) {
					max = freq[i];
					idx = i;
				} 
			}
			
			sb.append(idx).append("\n");
		}
		System.out.print(sb);
	}

}
