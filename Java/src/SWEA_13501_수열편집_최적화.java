import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SWEA_13501_수열편집_최적화 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 초기 수열 길이
            int M = Integer.parseInt(st.nextToken()); // 추가 횟수
            int L = Integer.parseInt(st.nextToken()); // 출력할 인덱스

            LinkedList list = new LinkedList();

            // 초기 수열 입력 (addLast를 사용하여 O(N)으로 최적화)
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.addLast(Integer.parseInt(st.nextToken()));
            }

            // M번의 편집 명령 수행
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int idx = Integer.parseInt(st.nextToken());

                if (cmd.equals("D")) {
                    list.Delete(idx);
                } else {
                    int val = Integer.parseInt(st.nextToken());
                    if (cmd.equals("I")) {
                        list.Insert(idx, val);
                    } else if (cmd.equals("C")) {
                        list.Change(idx, val);
                    }
                }
            }

            // L번째 인덱스의 값 가져오기 (get 메서드 사용으로 메인 로직 단순화)
            sb.append(list.get(L)).append("\n");
        }
        System.out.print(sb);
    }
    
    
 // 1. Node 클래스 수정 (next 매개변수 정상 반영)
    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next; // null 대신 매개변수로 받은 next를 연결
        }
    }

    // 2. 최적화된 LinkedList 클래스
    static class LinkedList {
        Node head;
        Node tail; // O(1) 초기 삽입을 위한 꼬리 포인터
        int size;  // 리스트의 크기를 추적하여 NullPointerException 방지

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // 3. O(1) 성능의 끝단 삽입 (초기 데이터 세팅용)
        public void addLast(int val) {
            Node newNode = new Node(val, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // 4. 반복문 최적화: idx-1 까지만 이동 후 한 번만 연결
        public void Insert(int idx, int val) {
            if (idx == 0) {
                head = new Node(val, head);
                if (tail == null) tail = head; // 비어있었다면 tail도 업데이트
                size++;
                return;
            }

            Node current = head;
            // 삽입할 위치의 '이전 노드'까지만 이동
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }

            current.next = new Node(val, current.next);
            if (current.next.next == null) {
                tail = current.next; // 맨 끝에 삽입된 경우 tail 업데이트
            }
            size++;
        }

        public void Delete(int idx) {
            if (head == null) return;

            if (idx == 0) {
                head = head.next;
                if (head == null) tail = null; // 모두 지워졌다면 tail도 null
                size--;
                return;
            }

            Node current = head;
            // 삭제할 위치의 '이전 노드'까지만 이동
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next; // 삭제할 노드를 건너뜀
                if (current.next == null) {
                    tail = current; // 마지막 노드가 삭제된 경우 tail 업데이트
                }
                size--;
            }
        }

        public void Change(int idx, int val) {
            Node current = head;
            // 변경할 위치까지 정확히 이동
            for (int i = 0; i < idx; i++) {
                current = current.next;
            }
            
            if (current != null) {
                current.val = val;
            }
        }

        // 5. 안전한 조회 메서드 추가 (NullPointerException 해결)
        public int get(int idx) {
            // 인덱스가 범위를 벗어나면 즉시 -1 반환
            if (idx >= size || idx < 0) {
                return -1;
            }

            Node current = head;
            for (int i = 0; i < idx; i++) {
                current = current.next;
            }
            return current.val;
        }
    }
}