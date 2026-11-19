def solution(array, commands):
    answer = []
    
    for command in commands:
        i, j, k = command[0]-1, command[1], command[2]-1
        cut = sorted(array[i:j])
        answer.append(cut[k])
        
    return answer