import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	
	static int L, cnt, ty, tx;
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ty = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			
			visited = new boolean[L][L];
			
			cnt = 0;
			bfs(sy, sx, 0);
			System.out.println(cnt);
		}
	}
	
	static void bfs(int y, int x, int count) {
		Queue<Integer> q = new ArrayDeque<>();
		if(y == ty && x == tx) return;

		q.add(y);
		q.add(x);
		q.add(count);
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			
			int r = q.poll();
			int c = q.poll();
			int moveCnt = q.poll();
			
			if(r == ty && c == tx) {
				cnt = moveCnt;
				break;
			}
			
			for(int d=0; d<8; d++) {
				int nr = r+dy[d];
				int nc = c+dx[d];
				
				if(nr < 0 || nr >= L || nc < 0 || nc >= L) continue;
				
				if(!visited[nr][nc]) {
					q.add(nr);
					q.add(nc);
					q.add(moveCnt + 1);
					visited[nr][nc] = true;
				}
			}
		}
	}
}
