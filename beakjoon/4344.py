casecount = int(input())
for i in range(casecount):
    score = list(map(int, input().split()))
    avg = (sum(score)-score[0])/score[0]
    ratio = 0
    for i in range(score[0]):
        if score[i+1] > avg :
            ratio +=1
    print("%.3f%%" %((ratio/score[0])*100))
