def solution(emergency):
    answer = []
    scores = sorted(emergency, reverse=True)
    for e_score in emergency:
        for i in range(len(scores)):
            if e_score == scores[i]:
                answer.append(i+1)
                pass
                   
    return answer