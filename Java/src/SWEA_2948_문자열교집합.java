import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_2948_문자열교집합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Set<String> nSet = new TreeSet<>();
			Set<String> mSet = new TreeSet<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nSet.add(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				mSet.add(st.nextToken());
			}
			
			int count = 0;
			for(String s: nSet) {
				if(mSet.contains(s)) count++;
			}
			
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}
