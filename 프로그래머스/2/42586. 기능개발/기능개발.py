from collections import deque
import heapq

def solution(progresses, speeds):
    answer = []
    q = deque(progresses)
    s = deque(speeds)
    
    while q:
        count = 0
        
        for i in range(len(q)):
            speed = s.popleft()
            q.append(q.popleft()+speed)
            s.append(speed)
            
        while q and q[0] >= 100:
            q.popleft()
            s.popleft()
            count+=1
        
        if count > 0:
            answer.append(count)

    return answer