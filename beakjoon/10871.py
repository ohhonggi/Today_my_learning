count, limit = map(int, input().split())
list = list(map(int, input().split()))
for i in range(len(list)):
    if list[i] < limit:
        print (list[i], end =' ')
