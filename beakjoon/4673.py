# lists = [0 for i in range(10001)]

# def constrant(number):
#     severalSt = sum(map(int,str(number)))
#     return severalSt
#
# for i in range(1,10001):
#     i += constrant(i)
#     if i < 10001:
#         lists[i] = 1
#
# for i in range(1,10001):
#     if lists[i+1] == 0:
#         print(i+1)

allNum = set(range(1,10001))
constructor = set()

for i in range(1,10001):
    for j in str(i):
        i += int(j)
    constructor.add(i)
result = sorted(allNum - constructor)

for i in result:
    print(i)