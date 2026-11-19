def solution(N, stages):
    answer = [0]*(N)
    count = [0]*(N)   
    fail = [0]*(N)
    people = len(stages)
    
    for stage in stages:
        if stage > N:
            continue
        count[stage-1]+=1 
        
    for i in range(N):
        if people == 0:
            fail[i] = 0
        else:
            fail[i] = count[i]/people
            people -= count[i]
    
    for i in range(N):
        answer[i] = (i+1, fail[i])  
    answer = sorted(answer, key=lambda x:x[1], reverse=True)
    answer = [stage[0] for stage in answer]
    
    return(answer)