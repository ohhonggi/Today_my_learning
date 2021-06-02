def solution(a,b):
    answer = 0
    partial = str(a**b)
    partial = partial[len(partial)-5:len(partial)]
    answer = int(partial)
    return answer
solution(2,30)