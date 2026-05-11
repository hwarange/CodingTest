import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4038_단어가등장하는횟수 {
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			sb.append("#").append(tc).append(" ");
			String B = br.readLine();
			String S = br.readLine();
			
			cnt = 0;
			KMP(B, S);
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
	static int[] getPi(String pattern) {
		int m = pattern.length();
		int[] pi = new int[m];
		int j=0; //접두사(Prefix)를 가리키는 포인터이자, 일치하는 길이
		
		// i는 접미사(Suffix)를 가리킴
		for(int i=1; i<m; i++) {
			
			// 접두사와 접미사가 다른 경우 j를 이전의 일치했던 부분으로 되돌림
			while(j > 0 && (pattern.charAt(i) != pattern.charAt(j))) {
				j = pi[j-1];
			}
			
			// 접두사와 접미사가 같은 경우 일치하는 길이가 늘어났으니 j를 키우고 pi에 기록
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	static void KMP(String text, String pattern) {
		//pi만들기
		int[] pi = getPi(pattern);
		//문장의 전체 길이
		int n = text.length();
		//패턴의 길이
		int m = pattern.length();
		int j=0;	//패턴을 가리키는 포인터
		
		// i는 텍스트를 가리키면서 절대 뒤로 가지 않음(돌아가기X)
		for(int i=0; i<n; i++) {
			
			//가다가 글자가 다른 경우 pi배열을 보고 j점프
			while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			//글자가 같은 경우 j를 한 칸 전진
			if(text.charAt(i) == pattern.charAt(j)) {
				// j가 패턴 끝까지 도달한 경우? 찾음
				if(j == m-1) {
					cnt++;
					// 또 패턴이 존재하는 경우가 있으니 다음 위치로 점프
					j = pi[j];
				}
				
				else j++;
			}
		}
		
		
		
		
		
		
		
		
	}
}
