import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {
	
	//상하좌우, 좌상 좌하, 우상 우하
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	
	static char[][] map;
	static boolean[][] visited;
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int cnt=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {	
					if(!visited[i][j] && map[i][j] == '.' && noMine(i, j)) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {	
					if(!visited[i][j]&& map[i][j] == '.') {
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		
	}
	
	static void bfs(int y, int x) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[y][x] = true;
		
		for(int d=0; d<8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(indexOutOf(ny, nx)) continue;
			
			if(!visited[ny][nx] && map[ny][nx] == '.') {
				q.add(ny);
				q.add(nx);
				visited[ny][nx] = true;
			}
		}
		
		while(!q.isEmpty()) {
			
			int r = q.poll();
			int c = q.poll();
			
			for(int d=0; d<8; d++) {
				int ny = r + dy[d];
				int nx = c + dx[d];
				
				if(indexOutOf(ny, nx)) continue;
				
				if(!visited[ny][nx] && map[ny][nx] == '.' && noMine(ny, nx)) {
					q.add(ny);
					q.add(nx);
					visited[ny][nx] = true;
				}
			}
		}
		
	}
	
	static boolean noMine (int y, int x) {
		for(int d=0; d<8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(indexOutOf(ny, nx)) continue;
			
			if(map[ny][nx] == '*') {
				return false;
			}
			
		}
		return true;
	}
	
	static boolean indexOutOf(int ny, int nx) {
		return ny >= N || ny < 0 || nx >= N || nx < 0;
	}
}
