import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[V+1][V+1];
			boolean[][] visited = new boolean[V+1][V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int p = Integer.parseInt(st.nextToken()); 
				int s = Integer.parseInt(st.nextToken());
				
				graph[p][s] = graph[s][p] = 1;
			}
			
			List<Integer> num1List = new ArrayList<>();
			List<Integer> num2List = new ArrayList<>();
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.add(num1);
			
			while(pq.isEmpty()) {
				int root = pq.poll();
				
				num1List.add(root);
				if(root == 1) break;
				
				for(int i=1; i<V+1; i++) {
					if(graph[root][i] == 1) {
						pq.add(i);
					} 
				}
			}
			pq.clear();
			
			while(pq.isEmpty()) {
				int root = pq.poll();
				
				num2List.add(root);
				if(root == 1) break;
				
				for(int i=1; i<V+1; i++) {
					if(graph[root][i] == 1) {
						pq.add(i);
					} 
				}
			}
			
			int max = 0;
		}
	}

}
