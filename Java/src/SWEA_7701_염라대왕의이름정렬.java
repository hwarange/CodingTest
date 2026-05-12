import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SWEA_7701_염라대왕의이름정렬 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int n = Integer.parseInt(br.readLine());
			
			Set<String> set = new HashSet<>();
			
			for(int i=0; i<n; i++) {
				set.add(br.readLine());
			}
			
			List<String> dict = new ArrayList<>();
			
			dict.addAll(set);			
			
			dict.sort((o1, o2) -> {
				if(o1.length() == o2.length()) {
					for(int i=0; i<o1.length(); i++) {
						if(o1.charAt(i) != o2.charAt(i)) {
							return o1.charAt(i) - o2.charAt(i);
						}
					}

				}
				
				return o1.length() - o2.length();
			});			
			
			for(String s: dict) {
				sb.append(s).append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
}
