import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1231_중위순회_완전이진트리활용_최적화 {
	
	static char[] node; 
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {			
			N = Integer.parseInt(br.readLine());
			
			node = new char[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken().charAt(0);
				node[i] = st.nextToken().charAt(0);
			}
			
			sb.append("#").append(tc).append(" ");
			inorder(1);
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	/*
	완전 이진트리는 인덱스를 활용해서 좌, 우 노드를 알 수 있다.
	 */
	static void inorder(int num) {
		if(num > N) return;
		inorder(num*2);
		sb.append(node[num]);
		inorder(num*2+1);
	}
}	
