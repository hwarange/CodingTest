import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_1248_공통조상 {	
	
	static List<Integer>[] children;
	static int[] parent;
	
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
			
			parent = new int[V+1];
			children = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				children[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				//부모 배열에서 자식을 idx로 해당하는 부모를 넣어줌
				parent[c] = p;
				
				//자식 리스트에서 부모를 idx로 해당하는 자식들을 넣어줌
				children[p].add(c);
			}
			
			int commonParent = findLCA(num1, num2, V);
			int subTreeSize = countSubTree(commonParent);
		}
	}
	
	static int findLCA(int num1, int num2, int V) {
		boolean[] visited = new boolean[V+1];
		
		while(num1 != 0) {
			visited[num1] = true;
			num1 = parent[num1];
		}
		
		while(num2 != 0) {
			if(visited[num2]) return num2;
		}
	}

}
