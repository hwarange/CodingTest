import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long[] result = new long[4];
		result[3] = Long.MAX_VALUE;
		
		Arrays.sort(arr);
		
		for(int i=0; i<N-2; i++) {
			int left = i+1;
			int right = N-1;
			
			boolean isFind = false;
			
			while(left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				
				if(sum == 0) {
					result[0] = arr[i];
					result[1] = arr[left];
					result[2] = arr[right];
					isFind = true;
					break;
				}
				
				if(Math.abs(sum) < Math.abs(result[3])) {
					result[0] = arr[i];
					result[1] = arr[left];
					result[2] = arr[right];
					result[3] = sum;	
				}
				
				if(sum > 0) {
					right--;
				}
				
				else if(sum < 0) {
					left++;
				}

				
			}
			
			if(isFind) break;
		}
		
		System.out.println(result[0]+" "+result[1]+" "+result[2]);
		
	}
	
	
}
