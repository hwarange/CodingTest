import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1230_암호문3 {
	
	static class Node {
		
		int val;
		Node next;
		
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		
	}
	
	static class LinkedList{
		
		int size = 0;
		Node head, tail;
		
		public LinkedList() {
			// TODO Auto-generated constructor stub
		}

		public void insert (int idx, int cnt, LinkedList list) {
			
			if(head == null) {
				head = list.head;
				tail = list.tail;
				size = cnt;
				return;
			}
			
			if(idx == 0) {
				list.tail.next = head;
				head = list.head;
				size += cnt;
				return;
			}
			
			Node curr = head;
			for(int i=1; i<idx; i++) {
				if(curr.next == null)break;
				curr = curr.next;
			}
			
			
			Node tmp = curr.next;
			curr.next = list.head;
			list.tail.next = tmp;
			
			if(tmp == null) tail = list.tail;
		    size += cnt;
		}
		
		public void delete (int idx, int cnt) {
			
			if(size <= idx || head == null) return;
			
			if(idx == 0) {
				Node curr = head;
				for(int i=0; i<cnt; i++) {
					if(curr.next == null)break;
					curr = curr.next;
				}
				
				head = curr.next;
				size -= cnt;
				return;
			}
			
			Node curr = head;
			for(int i=0; i<idx; i++) {
				if(curr.next == null) break;
				
				curr = curr.next;
			}
			
			int count = 0;
			Node tmp = curr;
			for(int i=0; i<cnt; i++) {
				if(curr.next == null)break;
				curr = curr.next;
				count++;
			}
			
			if(count < cnt) tail = tmp;
			else tmp.next = curr.next;
			
			size -= count;
			
			
		}
		
		public void addLast(int val) {
			Node newNode = new Node(val, null);
			
			if(tail == null) {
				head = tail = newNode;
				size++;
				return;
			}
			
			tail.next = newNode;
			tail = newNode;
			size++;
		}
		
		
		public void add (int cnt, LinkedList list) {
			tail.next = list.head;
			tail = list.tail;
			
			size += cnt;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			LinkedList list = new LinkedList();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int code = Integer.parseInt(st.nextToken());
				list.addLast(code);
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				String s = st.nextToken();
				
				if(s.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					LinkedList tmp = new LinkedList();
					
					for(int j=0; j<y; j++) {
						int code = Integer.parseInt(st.nextToken());
						tmp.addLast(code);
					}
					
					list.insert(x, y, tmp);
				}
				
				else if(s.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					list.delete(x, y);
				}
				
				else {
					int y = Integer.parseInt(st.nextToken());
					
					LinkedList tmp = new LinkedList();
					
					for(int j=0; j<y; j++) {
						int code = Integer.parseInt(st.nextToken());
						tmp.addLast(code);
					}
					
					list.add(y, tmp);
				}
			}
			
			Node curr = list.head;
			for(int i=0; i<10; i++) {
				sb.append(curr.val);
				curr = curr.next;
				
				if(i == 9) sb.append("\n");
				else sb.append(" ");
			}
		
			
		}
		System.out.print(sb);
	}
}
