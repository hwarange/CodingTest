import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2930_힙 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int seq = Integer.parseInt(st.nextToken());
				
				if(seq == 1) {
					int k = Integer.parseInt(st.nextToken());
					pq.add(k);
					continue;
				}
				
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append(" ");
				}
				else {
					sb.append(-1).append(" ");
				}
				
			}
			sb.deleteCharAt(sb.length()-1).append("\n");
		}
		System.out.print(sb);
	}
}
