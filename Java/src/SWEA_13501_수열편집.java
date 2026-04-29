import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int val;
	Node next;
	
	public Node(int val, Node next) {
		this.val = val;
		this.next = null;
	}
	
}

class LinkedList{

	Node head;
	
	public LinkedList() {

	}
	
	public void Insert(int idx, int val) {
		
		Node newNode = new Node(val, null);
		Node current = head;
		
		
		if(head == null) {
			head = newNode;
			return;
		}
			
		if(idx == 0) {
			newNode.next = current;
			head = newNode;
			return;
		}
	
		for(int i=0; i<idx; i++) {
			if(i == idx-1) {
				Node tmp = current.next;
				current.next = newNode;
				newNode.next = tmp;
			}
			
			current = current.next;
		}
			
	}
	
	
	public void Delete(int idx) {
		Node current = head;
		
		if(idx == 0) {
			head = current.next;
			return;
		}
		
		for(int i=0; i<idx; i++) {
			if(i == idx-1) {
				current.next = current.next.next;
			}
			
			current = current.next;
		}
	}
	
	public void Change(int idx, int val) {
		Node current = head;
		
		if(idx == 0) {
			head.val = val;
			return;
		}
		
		for(int i=0; i<=idx; i++) {
			if(i == idx) {
				current.val = val;
			}
			
			current = current.next;
		}
	}
}


public class SWEA_13501_수열편집 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			LinkedList list = new LinkedList();
			
			for(int i=0; i<N; i++) {
				int val = Integer.parseInt(st.nextToken());
				list.Insert(i, val);
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				String s = st.nextToken();
				
				if(s.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					list.Delete(idx);
					continue;
				}
				
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				
				if(s.equals("I")) list.Insert(idx, val); 
				else list.Change(idx, val);

			}
			
			Node curr = list.head;
			for(int i=0; i<=L; i++) {				
				
				if(i==L) {
					sb.append(curr.val).append("\n");
					break;
				}
				
				if(curr.next == null) {
					sb.append(-1).append("\n");
					break;
				}
				
				curr = curr.next;
			}
		}
		System.out.print(sb);
		
	}
	
}
