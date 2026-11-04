def solution(numbers):
    answer = []
    lenth = len(numbers)
    for i in range(lenth-1):
        for j in range(1+i, lenth):
            answer.append(numbers[i]+numbers[j])
    answer = list(set(answer))
    answer.sort()
    return answer