import queue
class Data:
    def __init__(self, priority, index):
        self.priority = priority
        self.index = index
    def __lt__(self, obj):
        """self < obj."""
        return self.priority < obj.priority

    def __le__(self, obj):
        """self <= obj."""
        return self.priority <= obj.priority

    def __eq__(self, obj):
        """self == obj."""
        return self.priority == obj.priority

    def __ne__(self, obj):
        """self != obj."""
        return self.priority != obj.priority

    def __gt__(self, obj):
        """self > obj."""
        return self.priority > obj.priority

    def __ge__(self, obj):
        """self >= obj."""
        return self.priority >= obj.priority



def solution(N, coffee_times):
    answer = []
    datas = [ Data( coffee_times[i],i ) for i in range(len(coffee_times)) ]
    port = queue.PriorityQueue()
    inserted = []
    insertedIndex = 0

    while True:
        # port 꽉찰 때까지 넣기
        while port.isNotFull():
            if insertedIndex == coffee_times.size:
                break
            port.put( datas[insertedIndex] )
            inserted.add( datas[i] )

        # 맨위에꺼로 다 빼주기
        minTime = port.get()
        for i in range(N):
            inserted[i].time -= minTime.time

        # 0인것들 다 삭제하기
        while port.isNotEmpty():
            check = port.get()
            if check.time == 0:
                target = port.pop()
                inserted.remove(target)
                answer.add(target.index)
            else:
                break;