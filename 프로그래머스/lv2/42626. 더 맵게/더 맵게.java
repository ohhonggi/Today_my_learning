import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    /*
        1. 정렬하여 PriorityQueue에 삽입
        2. k 스코빌보다 낮은 음식에 대해 mix진행
        3. queue의 head의 원소가 k스코빌보다 같거나 큰 경우 종료
        
    */
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(
            Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        
        while (queue.peek() < K && queue.size() > 1){
            queue.add(queue.remove() + (queue.remove()*2));
            answer++;
        }
        
        return queue.peek() < K ? -1 : answer;
    }
}
