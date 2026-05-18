import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class SWEA_1868_파핑파핑지뢰찾기_보완 {
	
	//상하좌우, 좌상 좌하, 우상 우하
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	
	static char[][] map;
	static int[][] mineCnt;
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
			mineCnt = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 주변지뢰가 몇개있는 지 카운팅
			makeMineCnt();
			
			int cnt=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {	
					if(!visited[i][j] && map[i][j] == '.' && mineCnt[i][j] == 0) {
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
	
	static void makeMineCnt() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				//해당하는 칸이 지뢰면 점프
				if(map[i][j] == '*') continue;
				
				//주변칸 지뢰 개수 세기
				int cnt = 0;
				for(int d=0; d<8; d++) {
					int ny = i+dy[d];
					int nx = j+dx[d];
					
					if(indexOutOf(ny, nx)) continue;
					
					if(map[ny][nx] == '*') cnt++;
				}
				
				mineCnt[i][j] = cnt;
			}
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[y][x] = true;
		
		//잘못 담는 경우를 대비해서 넣을 때 한번에 넣음
		//꺼내는 방법은 N으로 나눴을 때 몫 = y / N으로 나눴을 때 나머지 = x
		q.add(y*N+x);
		
		while(!q.isEmpty()) {
			
			int idxValue = q.poll();
			int r = idxValue/N;
			int c = idxValue%N;
			
			//주변에 지뢰가 있는 경우 점프
			if(mineCnt[r][c] != 0) continue;
			
			for(int d=0; d<8; d++) {
				int ny = r + dy[d];
				int nx = c + dx[d];
				
				if(indexOutOf(ny, nx)) continue;
				
				if(!visited[ny][nx] && map[ny][nx] == '.') {
					q.add(ny*N+nx);
					visited[ny][nx] = true;
				}
			}
		}
		
	}
	
	static boolean indexOutOf(int ny, int nx) {
		return ny >= N || ny < 0 || nx >= N || nx < 0;
	}
}
