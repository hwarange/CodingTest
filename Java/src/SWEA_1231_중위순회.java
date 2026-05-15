import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1231_중위순회 {
	
	static String[] node; 
	static int[] left, right;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {			
			int N = Integer.parseInt(br.readLine());
			
			node = new String[N+1];
			left = new int[N+1];
			right = new int[N+1];
			
			for(int i=0; i<N; i++) {
				String[] tmp = br.readLine().split(" ");
				int len = tmp.length;

				int idx = Integer.parseInt(tmp[0]);
				node[idx] = tmp[1];
				
				if(len == 4) {
					int leftNum = Integer.parseInt(tmp[2]);
					left[idx] = leftNum; 
					
					int rightNum = Integer.parseInt(tmp[3]);
					right[idx] = rightNum;
				}
				else if(len == 3) {
					int leftNum = Integer.parseInt(tmp[2]);
					left[idx] = leftNum;
				}
			}
			
			System.out.print("#"+tc+" ");
			inorder(1);
			System.out.println();
		}
		
	}
	static void inorder(int num) {
		if(left[num] != 0) inorder(left[num]);
		
		System.out.print(node[num]);
		
		if(right[num] != 0) inorder(right[num]);
	}
}	
