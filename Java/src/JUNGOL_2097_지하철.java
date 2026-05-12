import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_2097_지하철 {
	
	static class Node implements Comparable<Node>{
		int to, cost;

		public Node(int to, int val) {
			this.to = to;
			this.cost = val;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static List<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d;
	static int[] p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		d = new int[n+1];
		p = new int[n+1];
		
		// 0번부터 n번까지 리스트 미리 초기화 (인덱스 에러 방지)
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            d[i] = INF;
        }
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				graph.get(i).add(new Node(j, Integer.parseInt(st.nextToken())));
			}
	
		}
		
		dijkstra(1);
		System.out.println(d[m]);
		
		
		//경로 추적하기
		Stack<Integer> stack = new Stack<>();
		
		int curr = m;
		while(curr != 0) {
			stack.push(curr);
			curr = p[curr];
		}
		
		//꺼내면서 출력
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//시작 노드 0으로 설정
		pq.offer(new Node(start, 0));
		d[start] = 0;
		p[start] = 0;
		
		while(!pq.isEmpty()) {
			
			//가장 최단거리 노드 꺼내기
			Node node = pq.poll();
			int dist = node.cost;
			int num = node.to;
			
			//큐에서 꺼낸 거리가 현재 테이블에 기록된 거리보다 크면 이미 처리된 노드임으로 점프
			if(d[num] < dist) continue;
			
			//현재 노드와 연결된 다른 노드들 확인
			//i는 0부터 인접 노드들 개수만큼 반복
			for(int i=0; i<graph.get(num).size(); i++) {
				Node nextNode = graph.get(num).get(i);
				int distance = d[num]+nextNode.cost; // 현재 노드를 거쳐서 지나갈 때 거리
				
				// 거쳐서 가는 거리가 더 짧ㅇ느 경우 배열 갱신 및 큐에 삽입
				if(distance < d[nextNode.to]) {
					d[nextNode.to] = distance;
					p[nextNode.to] = num;
					pq.offer(new Node(nextNode.to, distance));
				}
			}
		}
	}
}
