
def solution(n,r,c):
    num=1
    list = [[0]*n for _ in range(n)]
    for k in range(n):
        i = 0
        j = k
        if k % 2 == 0:  # k 짝수는 아래에서 위로
            j = 0   # j는 y축, i는 x축
            i = k
            for n_ in range(k + 1):
                list[i][j] =num
                num += 1
                i -= 1
                j += 1
        else:   # k가 홀수일 경우 위에서 아래로
            for n_ in range(k + 1):
                list[i][j] = num
                num += 1
                i += 1
                j -= 1
    if list[r-1][c-1] != 0:
        return list[r-1][c-1]
    for k in range(n-1):
        i = n-1
        j = k+1
        if k % 2 == 0:  # k가 짝수일 경우 오른쪽 위에서 왼쪽 아래 대각선
            j = n-1
            i = k+1
            for n_ in range(n-1-k):
                list[i][j] =num
                num += 1
                i += 1
                j -= 1
        else:
            for n_ in range(n-1-k):
                list[i][j] = num
                num += 1
                i -= 1
                j += 1
    for i in range(n):
        print(list[i])
    return list[r-1][c-1]

print(solution(5,4,3))