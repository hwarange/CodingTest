import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0
    
    while len(scoville) > 1:
        if scoville[0] >= K : break
        
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, first + (second*2))
        count += 1
        
    if scoville[0] < K:
        return -1
    
    return count