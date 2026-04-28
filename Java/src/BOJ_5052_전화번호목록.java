import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5052_전화번호목록 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] numbers = new String[n];
			
			for(int i=0; i<n; i++) {
				numbers[i] = br.readLine();
			}
			
			Arrays.sort(numbers);
			
			boolean isOk = true;
			for(int i=0; i<n-1; i++) {
				if(numbers[i+1].startsWith(numbers[i])) {
					isOk = false;
					break;
				}
			}
			if(isOk)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
