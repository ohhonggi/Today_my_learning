# 연구소, n by M
# 바이러스 - 2, 벽 - 1, 안전영역 0
# 바이러스는 안전영역에 퍼질 수 있다. 2의 개수는 2보다 크고, 10보다 작다
# 벽 3개를 세워서 안전영역을 확보, 안전 영역 크기의 최대값 구하기.

n, m = map(int, input().split())

space = []

for _ in n:
    space.append(list(map(int, input())))

print(space)

direction = [(-1,0), (1,0), (0,-1), (0,1)]


# 각 바이러스마다 상하좌우로 퍼져나갈 수 있는 공간이 있다.
