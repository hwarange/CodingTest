def solution(s):
    answer = True
    
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    
    c_list = []
    
    for c in s:
        if c == ")" and len(c_list) == 0:
            answer = False
            break
        elif c == ")" and c_list[-1] == "(": 
            c_list.pop() 
        else:
            c_list.append(c)
            
    if len(c_list) != 0 :
        answer = False

    return answer