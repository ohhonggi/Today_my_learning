# 거스름돈, 2 or 5원 동전

# 거스름돈을 5원으로 나눈 나머지가 홀수
# -> 몫-1만큼 count 후 나머지를 2원동전으로 count

n = int(input())
count = 0

if n == 1 or n == 3:
    print(-1)
else:
    if (n % 5) % 2 == 1:
        count += (n // 5)-1
    else:
        count += (n // 5)

    n -= count * 5
    count += n // 2

    print(count)