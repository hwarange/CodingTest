def solution(myString, pat):
    answer = 0 
    
    len1 = len(myString)
    len2 = len(pat)
    
    for i in range(len1 - len2+1):
        index = i
        for j in range(len2):
            if myString[index] == pat[j]:
                index+=1
            else: break
            
            if j == len2-1 :
                answer+=1
    
    return answer

