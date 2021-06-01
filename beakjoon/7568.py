persons = int(input())
personList = []
ranklist = []

for i in range(persons):
    weight, height = map(int, input().split())
    personList.append((weight,height))

for i in personList:
    rank = 1
    for j in personList:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    ranklist.append(rank)

for i in ranklist:
    print("%d" %i ,end=' ')
