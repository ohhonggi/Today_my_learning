# 로프, N <=100,000,
# 정렬 후, 맨 뒤에서부터 값을 가져온다.

n = int(input())
weight_list = []

for _ in range(n):
    weight_list.append(int(input()))

weight_list.sort()

weight_avg_list = []

for weight in weight_list:
    weight_avg_list.append(weight*n)
    n -= 1
print(max(weight_avg_list))
