index = []

## list에서 해당 학생을 찾아오는 함수
def findStudent (list,number):
    i = 0
    for i in range (len(list)):
        if list[i].id == number:
            return list[i]

## 과목별 총점/평균 조회
def sub_Sum_Avg():
    kSum=0
    eSum=0
    mSum=0
    for i in range(len(index)):
        kSum=kSum+index[i].kscore
    for i in range(len(index)):
        eSum=eSum+index[i].escore
    for i in range(len(index)):
        mSum=mSum+index[i].mscore
    kAvg=kSum/3.0
    eAvg=eSum/3.0
    mAvg=mSum/3.0
    print("국어 : %d점     %d점 " %(kSum, kAvg))
    print("영어 : %d점     %d점 " %(eSum, eAvg))
    print("수학 : %d점     %d점 " %(mSum, mAvg))

## 전체 총점 및 평균 조회
def total_Sum_Avg():
    totalSum=0
    for i in range(len(index)):
        totalSum=totalSum+index[i].getTotal()
    totalAVG= totalSum/3.0
    print("전체 총점은  %d점, 평균은  %d점입니다." %(totalSum ,totalAVG))

class Student:
    def __init__(self, id, name, major, kscore, escore, mscore):
        self.id = id
        self.name = name
        self.major = major
        self.kscore = kscore
        self.escore = escore
        self.mscore = mscore
        self.__total = kscore + escore + mscore
        self.__average = (kscore + escore + mscore)/3.0

    def setTotal(self, total):
        self.__total = total
    def setAverage(self, average):
        self.__average = average
    def getTotal(self):
        return self.__total
    def getAverage(self):
        return self.__average

    ## 개인 정보/점수 조회
    def show(self):
        print("====================\n")
        print("학번 : " ,self.id)
        print("이름 : " ,self.name)
        print("학과 : " ,self.major)
        print("국어 성적 : " ,self.kscore)
        print("영어 성적 : " ,self.escore)
        print("수학 성적 : " ,self.mscore)
        print("총점 : " ,self.getTotal())
        print("평균 : " ,self.getAverage())
        print("====================\n")

    ## 개인 과목별 등수 조회
    def searchSubjectRank(self):
        i = 0
        kRank = 1
        eRank = 1
        mRank = 1
        for i in range (len(index)):
            if index[i].kscore > self.kscore:
                kRank = kRank+1
            if index[i].escore > self.escore:
                eRank = eRank+1
            if index[i].mscore > self.mscore:
                mRank = mRank+1
        print("국어 과목 등수 : %d명 중 %d 등" %(len(index), kRank))
        print("영어 과목 등수 : %d명 중 %d 등" %(len(index), eRank))
        print("수학 과목 등수 : %d명 중 %d 등" %(len(index), mRank))

    ## 개인 전체 등수 조회
    def searchTotalRank(self):
        i = 0
        totalRank = 1;
        for i in range (len(index)):
            if index[i].getAverage() > self.getAverage():
                totalRank = totalRank+1;
        print("전체 등수 : %d명 중 %d 등" %(len(index),totalRank))

    def modify(self,c):
        newScore= 0
        if c == 1:
            newScore=int(input("국어 성적을 입력하시오:"))
            self.kscore=newScore
        if c == 2:
            newScore=int(input("영어 성적을 입력하시오:"))
            self.escore=newScore
        if c == 3:
            newScore=int(input("수학 성적을 입력하시오:"))
            self.mscore=newScore
        self.setTotal(self.mscore + self.escore + self.kscore)
        self.setAverage(self.getTotal()/3)
        return self
            
index.append(Student(202103394, "유재석", "국어국문과", 95, 92, 91))
index.append(Student(202101124, "이광수", "연극영화과", 85, 54, 88))
index.append(Student(202114223, "김종국", "체육학과", 90, 88, 62))
menu = -1

while(menu!=0):
    print("-------------------")
    print("-------------------")
    print("1.개인 정보/점수 조회")
    print("2.개인 과목별 등수 조회")
    print("3.개인 전체 등수 확인")
    print("4.과복별 총점/평균 조회")
    print("5.전체 총점/평균 조회")
    print("6.신규학생 정보/점수 등록")
    print("7.학생 점수 수정")
    print("8.전체학생 성적 출력")
    print("-------------------")
    print("0.종료")
    print("-------------------")

    menu = int(input("메뉴를 선택하시오 : "))
    if menu ==1:
        number = int(input("학생번호를 입력하시오: "))
        findStudent(index,number).show()

    if menu ==2:
        number = int(input("학생번호를 입력하시오: "))
        findStudent(index,number).searchSubjectRank()

    if menu ==3:
        number = int(input("학생번호를 입력하시오: "))
        findStudent(index,number).searchTotalRank()

    if menu ==4:
        sub_Sum_Avg()

    if menu ==5:
        total_Sum_Avg()
        
    if menu ==6:
        newNumber = int(input("학생번호:"))
        name = str(input("이름:"))
        major = str(input("학과:"))
        mscore = int(input("국어 성적:"))
        escore = int(input("영어 성적:"))
        mscore = int(input("수학 성적:"))
        newStudent = Student(newNumber,name,major,mscore,escore,mscore)
        index.append(newStudent)

    if menu ==7:
        number = int(input("학생번호를 입력하시오"))
        c=int(input("과목 선택 : 1. 국어  2. 영어 3. 수학"))
        modifyS = findStudent(index,number).modify(c)
        i = 0
        for i in range (len(index)):
            if index[i].id == number:
                index[i] = modifyS
                break

    if menu ==8:
        print("   학번     이름    학과    국어    영어    수학    총점    평균")
        for i in range(len(index)):
            print(index[i].id,index[i].name,index[i].major,"  ",index[i].kscore,"   ",index[i].escore,"   ",index[i].mscore,"   ",index[i].getTotal(),"   ",index[i].getAverage())
