import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	
	static class Node implements Comparable<Node>{
		int y, x, val;

		public Node(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
	}
	
	static final int INF = Integer.MAX_VALUE; 
	static int N, min;
	static int[][] map, sum;
	static int[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			sb.append("Problem ").append(tc).append(": ");
			
			map = new int[N][N];
			sum = new int[N][N];
			visited = new int[N][N];
			
			for(int i=0; i<N; i++) {
				Arrays.fill(visited[i], INF);				
			}
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			min = Integer.MAX_VALUE;
			djikstra(0, 0);
			min = visited[N-1][N-1];
			
			sb.append(min).append("\n");			
			tc++;
		}
		System.out.print(sb);
	}
	
	static void djikstra(int sy, int sx) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(sy, sx, map[sy][sx]));
		visited[sy][sx] = map[sy][sx];
		
		while(!pq.isEmpty()) {
			Node newNode = pq.poll();
			
			if(newNode.val > visited[newNode.y][newNode.x]) continue;
			
			for(int d=0; d<4; d++) {
				int nr = newNode.y + dy[d];
				int nc = newNode.x + dx[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				
				if(visited[nr][nc] > map[nr][nc] + newNode.val) {
					pq.add(new Node(nr, nc, map[nr][nc]+newNode.val));
					visited[nr][nc] = map[nr][nc] + newNode.val;
				}
			}
		}

	}
}
