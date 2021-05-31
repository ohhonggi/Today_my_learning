input = int(input())
cycle = input
count = 0
while True:
    if cycle < 10:
        cycle = cycle*10 + cycle
    else:
        cycle = (cycle%10)*10 + (sum(map(int, str(cycle))))%10
    count +=1
    if input == cycle:
        print(count)
        break