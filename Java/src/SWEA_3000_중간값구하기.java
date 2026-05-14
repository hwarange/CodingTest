import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3000_중간값구하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			PriorityQueue<Integer> smallpq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
			PriorityQueue<Integer> bigpq = new PriorityQueue<>();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			bigpq.offer(A);
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				smallpq.offer(Math.min(X, Y));
				bigpq.offer(Math.max(X, Y));
				
				if(smallpq.peek() > bigpq.peek()) {
					int tmp = smallpq.poll();
					smallpq.offer(bigpq.poll());
					bigpq.offer(tmp);
				}
				
				sum  = (sum + bigpq.peek())%20171109;
			}
			
			sb.append(sum).append("\n");
			
		}
		System.out.print(sb);
	}
}
