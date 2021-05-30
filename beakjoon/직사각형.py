# 직사각형을 만들기 위해 3개의 점이 주어졌을 때, 나머지 하나의 점을 구하는 문제
def solution(v):
    answer = []
    x1 = []
    y1 = []
    for i in v:
        if i[0] not in x1:
            x1.append(i[0])
        else:
            x1.remove(i[0])
        if i[1] not in y1:
            y1.append(i[1])
        else:
            y1.remove(i[1])
    answer = x1 + y1
    return answer
