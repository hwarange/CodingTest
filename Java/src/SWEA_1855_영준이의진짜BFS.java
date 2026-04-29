import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1855_영준이의진짜BFS {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[N+1][N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=2; i<=N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = i;
				
				graph[from][to] = graph[to][from] = 1;
			}
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Integer> q = new ArrayDeque<>();
		
	}
}
